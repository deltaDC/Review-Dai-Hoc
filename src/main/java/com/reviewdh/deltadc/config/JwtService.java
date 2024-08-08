package com.reviewdh.deltadc.config;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.reviewdh.deltadc.model.entities.User;
import com.reviewdh.deltadc.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtService {

    private final UserRepository userRepository;

    private JWSSigner signer;
    private JWSVerifier verifier;

    @Value("${app.secretkey}")
    private String SECRET_KEY;

    public String extractEmail(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            if (signedJWT.verify(verifier)) {
                return signedJWT.getJWTClaimsSet().getSubject();
            }
        } catch (Exception e) {
            log.error("Failed to extract email from token", e);
        }
        return null;
    }

    @PostConstruct
    public void init() throws JOSEException {
        signer = new MACSigner(SECRET_KEY);
        verifier = new MACVerifier(SECRET_KEY);
    }

    public String generateToken(UserDetails userDetails, String email) throws JOSEException {
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(email)
                .issueTime(new Date())
                .expirationTime(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .claim("roles", userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .build();

        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
        signedJWT.sign(signer);

        return signedJWT.serialize();
    }

    public JWTClaimsSet extractAllClaims(String token) throws ParseException, JOSEException {
        SignedJWT signedJWT = SignedJWT.parse(token);
        if (!signedJWT.verify(verifier)) {
            throw new JOSEException("Signature verification failed");
        }
        return signedJWT.getJWTClaimsSet();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            JWTClaimsSet claims = extractAllClaims(token);
            String userEmailFromUserDetails = userRepository.findByUsername(userDetails.getUsername())
                    .map(User::getEmail)
                    .orElse(null);
            return claims.getSubject().equals(userEmailFromUserDetails) && !claims.getExpirationTime().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}

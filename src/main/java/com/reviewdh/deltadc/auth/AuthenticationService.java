package com.reviewdh.deltadc.auth;

import com.nimbusds.jose.JOSEException;
import com.reviewdh.deltadc.config.JwtService;
import com.reviewdh.deltadc.model.entities.User;
import com.reviewdh.deltadc.model.enums.Role;
import com.reviewdh.deltadc.repository.UserRepository;
import com.reviewdh.deltadc.request.AuthenticationRequest;
import com.reviewdh.deltadc.request.SignUpRequest;
import com.reviewdh.deltadc.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<AuthenticationResponse> signup(SignUpRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .isEnabled(true)
                .build();

//        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(AuthenticationResponse.builder()
//                            .message("Nguoi dung da ton tai")
//                            .build());
//        }

        userRepository.save(user);

        String token = UUID.randomUUID().toString();

//        ConfirmationToken confirmationToken = new ConfirmationToken(
//                token,
//                LocalDateTime.now(),
//                LocalDateTime.now().plusMinutes(15),
//                user
//        );
//
//        confirmationTokenService.saveConfirmationToken(confirmationToken);
//        String link = "http://localhost:8080/api/auth/confirm?token=" + token;
//        //bat cai nay len neu muon gui email
////        emailSender.send(
////                request.getEmail(),
////                buildEmail((request.getUsername()), link)
////        );

        return ResponseEntity.status(HttpStatus.OK)
                .body(AuthenticationResponse.builder()
                        .token(token)
                        .username(user.getUsername())
                        .message("Created user successfully")
                        .build());
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws JOSEException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user, user.getEmail());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(user.getUsername())
                .message("Success")
                .role(String.valueOf(user.getRole()))
                .build();
    }
}

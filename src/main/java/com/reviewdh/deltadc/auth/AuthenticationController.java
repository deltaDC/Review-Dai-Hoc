package com.reviewdh.deltadc.auth;

import com.nimbusds.jose.JOSEException;
import com.reviewdh.deltadc.request.AuthenticationRequest;
import com.reviewdh.deltadc.request.SignUpRequest;
import com.reviewdh.deltadc.response.AuthenticationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Validated
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> register(
            @Valid @RequestBody SignUpRequest request) {
        return authenticationService.signup(request);
    }

//    @GetMapping("/confirm")
//    public String confirm(@RequestParam("token") String token) {
//        return authenticationService.confirmToken(token);
//    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @Valid @RequestBody AuthenticationRequest request) throws JOSEException {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}

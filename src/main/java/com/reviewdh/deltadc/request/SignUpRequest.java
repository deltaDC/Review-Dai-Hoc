package com.reviewdh.deltadc.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    @NotNull(message = "Username is required")
    private String username;

    @Email
    @NotNull(message = "Email is required")
    private String email;

    @Size(min = 8)
    @NotNull(message = "Password is required")
    private String password;

}

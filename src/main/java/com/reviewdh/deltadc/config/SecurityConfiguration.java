package com.reviewdh.deltadc.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cor -> cor.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                //authentications
                                .requestMatchers("/api/auth/**").permitAll()

                                //users
                                .requestMatchers(HttpMethod.GET, "/api/user/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/university/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/teacher/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/major/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/course/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/teacher-contract/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/umct/**").permitAll()
//                                .requestMatchers(HttpMethod.GET, "/api/university-review/**").permitAll()
//                                .requestMatchers(HttpMethod.GET, "/api/teacher-course-review/**").permitAll()
//                                .requestMatchers(HttpMethod.GET, "/api/major-review/**").permitAll()

                                //admin
                                .requestMatchers("/api/user/**").hasAnyAuthority(
                                        "ROLE_ADMIN",
                                        "ROLE_DEVELOPER"
                                )
                                .requestMatchers("/api/university/**").hasAnyAuthority(
                                        "ROLE_ADMIN",
                                        "ROLE_DEVELOPER"
                                )
                                .requestMatchers("/api/teacher/**").hasAnyAuthority(
                                        "ROLE_ADMIN",
                                        "ROLE_DEVELOPER"
                                )
                                .requestMatchers("/api/major/**").hasAnyAuthority(
                                        "ROLE_ADMIN",
                                        "ROLE_DEVELOPER"
                                )
                                .requestMatchers("/api/course/**").hasAnyAuthority(
                                        "ROLE_ADMIN",
                                        "ROLE_DEVELOPER"
                                )
                                .requestMatchers("/api/teacher-contract/**").hasAnyAuthority(
                                        "ROLE_ADMIN",
                                        "ROLE_DEVELOPER"
                                )
                                .requestMatchers("/api/umct/**").hasAnyAuthority(
                                        "ROLE_ADMIN",
                                        "ROLE_DEVELOPER"
                                )

                                //reviews
                                .requestMatchers("/api/university-review/**")
                                            .hasAnyAuthority(
                                                    "ROLE_ADMIN",
                                                    "ROLE_USER",
                                                    "ROLE_DEVELOPER"
                                            )
                                .requestMatchers("/api/teacher-course-review/**")
                                            .hasAnyAuthority(
                                                    "ROLE_ADMIN",
                                                    "ROLE_USER",
                                                    "ROLE_DEVELOPER"
                                            )
                                .requestMatchers("/api/major-review/**")
                                            .hasAnyAuthority(
                                                    "ROLE_ADMIN",
                                                    "ROLE_USER",
                                                    "ROLE_DEVELOPER"
                                            )

                                .requestMatchers("/api/**").hasAnyAuthority(
                                        "ROLE_ADMIN",
                                        "ROLE_USER",
                                        "ROLE_DEVELOPER"
                                )
                                .anyRequest().authenticated()
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:4200");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

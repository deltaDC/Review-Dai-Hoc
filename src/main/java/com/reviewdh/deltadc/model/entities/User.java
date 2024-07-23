package com.reviewdh.deltadc.model.entities;

import com.reviewdh.deltadc.model.enums.Gender;
import com.reviewdh.deltadc.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {

    @Column(unique = true, nullable = false, length = 50)
    @NotBlank
    private String username;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 8)
    private String password;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    private String phone;

    private String avatar;

    @Lob
    private String bio;

    private String dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;

    private Boolean isEnabled;

//    private Favorite favorite;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", bio='" + bio + '\'' +
                ", dob='" + dob + '\'' +
                ", gender=" + gender +
                ", lastLoginDate=" + lastLoginDate +
                ", isEnabled=" + isEnabled +
                '}';
    }
}

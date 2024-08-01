package com.reviewdh.deltadc.model.dtos;


import com.reviewdh.deltadc.model.enums.Gender;
import com.reviewdh.deltadc.model.enums.Role;
import lombok.*;

import java.util.Date;

@Data
public class UserDto {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
    private String bio;
    private Date dob;
    private Gender gender;
    private Date lastLoginDate;
    private Boolean isEnabled;

}

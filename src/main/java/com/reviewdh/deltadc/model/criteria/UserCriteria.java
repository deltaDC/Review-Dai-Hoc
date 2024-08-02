package com.reviewdh.deltadc.model.criteria;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCriteria {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;

}

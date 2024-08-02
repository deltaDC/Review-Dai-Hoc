package com.reviewdh.deltadc.model.criteria;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherCriteria {

    private String fullName;
    private String email;
    private String phoneNumber;

}

package com.reviewdh.deltadc.model.criteria;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UniversityCriteria {

    private String name;
    private String abbreviation;
    private String location;

}

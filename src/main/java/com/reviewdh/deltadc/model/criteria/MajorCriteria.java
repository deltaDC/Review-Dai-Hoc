package com.reviewdh.deltadc.model.criteria;

import com.reviewdh.deltadc.model.enums.DegreeType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MajorCriteria {

    private String majorName;
    private String majorCode;
    private DegreeType degreeType;

}

package com.reviewdh.deltadc.model.entities.reviews;

import com.reviewdh.deltadc.model.entities.BaseEntity;
import com.reviewdh.deltadc.model.enums.ReviewType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseReview extends BaseEntity {

    private Long userId;

    private ReviewType reviewType;

    private int rating;

    private String title;

    private String content;

    private int upVote;

    private int downVote;

}

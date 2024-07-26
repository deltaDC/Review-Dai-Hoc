package com.reviewdh.deltadc.model.entities.reviews;

import com.reviewdh.deltadc.model.entities.BaseEntity;
import com.reviewdh.deltadc.model.entities.User;
import com.reviewdh.deltadc.model.enums.ReviewType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseReview extends BaseEntity {

    private Long userId;

    @Enumerated(EnumType.STRING)
    private ReviewType reviewType;

    @Min(0)
    @Max(5)
    private double rating;

    @Lob
    private String content;

    private int upVote;

    private int downVote;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

}

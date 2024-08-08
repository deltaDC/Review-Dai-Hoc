package com.reviewdh.deltadc.model.entities.reviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reviewdh.deltadc.model.entities.BaseEntity;
import com.reviewdh.deltadc.model.entities.User;
import com.reviewdh.deltadc.model.enums.ReviewType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseReview extends BaseEntity {

    @NotNull(message = "User ID is required")
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
    @JsonIgnore
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
}

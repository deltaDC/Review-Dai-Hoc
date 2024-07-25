package com.reviewdh.deltadc.model.entities.reviews;

import com.reviewdh.deltadc.model.entities.University;
import com.reviewdh.deltadc.model.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "university_reviews")
public class UniversityReview extends BaseReview {

    private Long userId;
    private Long universityId;

    @ManyToOne
    @JoinColumn(name = "universityId", insertable = false, updatable = false)
    private University university;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
}

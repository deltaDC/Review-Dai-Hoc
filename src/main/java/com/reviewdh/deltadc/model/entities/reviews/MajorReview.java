package com.reviewdh.deltadc.model.entities.reviews;

import com.reviewdh.deltadc.model.entities.Major;
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
@Table(name = "major_reviews")
public class MajorReview extends BaseReview {

    private Long userId;
    private Long majorId;

    @ManyToOne
    @JoinColumn(name = "majorId", insertable = false, updatable = false)
    private Major major;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
}

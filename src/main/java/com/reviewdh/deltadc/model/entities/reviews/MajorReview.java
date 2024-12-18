package com.reviewdh.deltadc.model.entities.reviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reviewdh.deltadc.model.entities.Major;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Major ID is required")
    private Long majorId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "majorId", insertable = false, updatable = false)
    private Major major;
}

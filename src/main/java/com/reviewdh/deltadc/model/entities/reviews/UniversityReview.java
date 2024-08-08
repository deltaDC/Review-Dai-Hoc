package com.reviewdh.deltadc.model.entities.reviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reviewdh.deltadc.model.entities.University;
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
@Table(name = "university_reviews")
public class UniversityReview extends BaseReview {

    @NotNull(message = "University ID is required")
    private Long universityId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "universityId", insertable = false, updatable = false)
    private University university;
}

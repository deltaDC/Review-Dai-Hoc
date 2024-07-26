package com.reviewdh.deltadc.model.entities;

import com.reviewdh.deltadc.model.entities.associative.UMCT;
import com.reviewdh.deltadc.model.enums.DegreeType;
import com.reviewdh.deltadc.validation.CreateGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "majors")
public class Major extends BaseEntity{

    @Column(nullable = false)
    @NotBlank(
            message = "University ID is required",
            groups = CreateGroup.class
    )
    private Long universityId;

    @NotBlank(
            message = "Major name is required",
            groups = CreateGroup.class
    )
    private String majorName;

    @NotBlank(
            message = "Major code is required",
            groups = CreateGroup.class
    )
    private String majorCode;

    @Lob
    private String majorDescription;

    private DegreeType degreeType;

    @Min(value = 1, message = "Duration must be at least 1 year")
    @Max(value = 10, message = "Duration must be at most 10 years")
    private int durationYears;

    @Min(value = 1, message = "Credits must be at least 1")
    @Max(value = 200, message = "Credits must be at most 200")
    private int credits;

    @URL(message = "Invalid URL")
    private String curriculumUrl;

    @ManyToOne
    @JoinColumn(name = "universityId", insertable = false, updatable = false)
    private University university;

    @OneToMany(mappedBy = "major")
    @Column(updatable = false, insertable = false)
    @JsonIgnore
    @ToString.Exclude
    private List<UMCT> courses;
}

package com.reviewdh.deltadc.model.entities;

import com.reviewdh.deltadc.model.entities.associative.UMCT;
import com.reviewdh.deltadc.model.entities.reviews.TeacherCourseReview;
import com.reviewdh.deltadc.validation.CreateGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course extends BaseEntity {

    @NotBlank(
            message = "Course name is required",
            groups = CreateGroup.class
    )
    private String name;

    @Lob
    private String description;

    @NotBlank(
            message = "Course code is required",
            groups = CreateGroup.class
    )
    private String courseCode;

    @Column(updatable = false, insertable = false)
    @OneToMany(mappedBy = "course")
    @JsonIgnore
    @ToString.Exclude
    private List<UMCT> courses;

    @Column(updatable = false, insertable = false)
    @OneToMany(mappedBy = "course")
    @JsonIgnore
    @ToString.Exclude
    private List<TeacherCourseReview> reviews;
}

package com.reviewdh.deltadc.model.entities;

import com.reviewdh.deltadc.model.entities.associative.UMCT;
import com.reviewdh.deltadc.model.entities.reviews.TeacherCourseReview;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    private String name;

    private String description;

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

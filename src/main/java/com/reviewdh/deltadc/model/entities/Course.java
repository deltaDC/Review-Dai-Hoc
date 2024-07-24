package com.reviewdh.deltadc.model.entities;

import com.reviewdh.deltadc.model.entities.associative.UniversityMajorCourseTeacher;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

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
    @ToString.Exclude
    private List<UniversityMajorCourseTeacher> courses;
}

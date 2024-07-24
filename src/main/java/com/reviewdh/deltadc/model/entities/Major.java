package com.reviewdh.deltadc.model.entities;

import com.reviewdh.deltadc.model.entities.associative.UniversityMajorCourseTeacher;
import com.reviewdh.deltadc.model.enums.DegreeType;
import jakarta.persistence.*;
import lombok.*;

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

    private Long universityId;

    private String majorName;

    private String majorCode;

    private String majorDescription;

    private DegreeType degreeType;

    private int durationYears;

    private int credits;

    private String curriculumUrl;

    @ManyToOne
    @JoinColumn(name = "universityId", insertable = false, updatable = false)
    private University university;

    @OneToMany(mappedBy = "major")
    @Column(updatable = false, insertable = false)
    @ToString.Exclude
    private List<UniversityMajorCourseTeacher> courses;
}

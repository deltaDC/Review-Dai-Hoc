package com.reviewdh.deltadc.model.entities;

import com.reviewdh.deltadc.model.entities.associative.TeacherContract;
import com.reviewdh.deltadc.model.entities.associative.UMCT;
import com.reviewdh.deltadc.model.entities.reviews.TeacherCourseReview;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
@Table(name = "teachers")
public class Teacher extends BaseEntity {

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Email
    private String email;

    private String phoneNumber;

    private String profilePictureUrl;

    private String bio;

    private String specializations;

    private String qualifications;

    private int experience;

    private Long teacherContractId;

    @Column(updatable = false, insertable = false)
    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    @ToString.Exclude
    private List<TeacherContract> teacherContracts;

    @Column(updatable = false, insertable = false)
    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    @ToString.Exclude
    private List<UMCT> courses;

    @Column(updatable = false, insertable = false)
    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    @ToString.Exclude
    private List<TeacherCourseReview> reviews;
}

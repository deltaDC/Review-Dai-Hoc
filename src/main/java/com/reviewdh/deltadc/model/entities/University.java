package com.reviewdh.deltadc.model.entities;

import com.reviewdh.deltadc.model.entities.associative.TeacherContract;
import com.reviewdh.deltadc.model.entities.associative.UMCT;
import com.reviewdh.deltadc.model.entities.reviews.UniversityReview;
import com.reviewdh.deltadc.model.enums.UniversityType;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "universities")
public class University extends BaseEntity {
    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 20)
    private String abbreviation;

    private String location;

    @Lob
    private String description;

    @Temporal(TemporalType.DATE)
    private Date establishedDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UniversityType universityType;

    private String websiteUrl;

    @Column(length = 100)
    private String contact;

    private String logoUrl;

    private int ranking;

    private Long totalStudents;

    @Column(updatable = false, insertable = false)
    @OneToMany(mappedBy = "university")
    @JsonIgnore
    @ToString.Exclude
    private List<TeacherContract> teacherContracts;

    @Column(updatable = false, insertable = false)
    @OneToMany(mappedBy = "university")
    @JsonIgnore
    @ToString.Exclude
    private List<UMCT> courses;

    @Column(updatable = false, insertable = false)
    @OneToMany(mappedBy = "university")
    @JsonIgnore
    @ToString.Exclude
    private List<Major> majors;

    @Column(updatable = false, insertable = false)
    @OneToMany(mappedBy = "university")
    @JsonIgnore
    @ToString.Exclude
    private List<UniversityReview> reviews;
}

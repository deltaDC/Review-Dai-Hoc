package com.reviewdh.deltadc.model.entities.associative;

import com.reviewdh.deltadc.model.entities.*;
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
@Table(name = "university_major_course_teacher")
public class UMCT extends BaseEntity {

    private Long universityId;

    private Long courseId;

    private Long majorId;

    private Long teacherId;

    private String description;

    private int credits;

    @ManyToOne
    @JoinColumn(name = "universityId", updatable = false, insertable = false)
    private University university;

    @ManyToOne
    @JoinColumn(name = "courseId", updatable = false, insertable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "majorId", updatable = false, insertable = false)
    private Major major;

    @ManyToOne
    @JoinColumn(name = "teacherId", updatable = false, insertable = false)
    private Teacher teacher;
}

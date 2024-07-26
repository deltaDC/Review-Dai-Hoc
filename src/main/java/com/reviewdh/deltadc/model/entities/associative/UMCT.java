package com.reviewdh.deltadc.model.entities.associative;

import com.reviewdh.deltadc.model.entities.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "University ID is required")
    private Long universityId;

    @NotBlank(message = "Course ID is required")
    private Long courseId;

    @NotBlank(message = "Major ID is required")
    private Long majorId;

    @NotBlank(message = "Teacher ID is required")
    private Long teacherId;

    @Lob
    private String description;

    @Min(1)
    @Max(10)
    @NotBlank(message = "Credits must be between 1 and 10")
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

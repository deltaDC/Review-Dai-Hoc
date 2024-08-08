package com.reviewdh.deltadc.model.entities.reviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reviewdh.deltadc.model.entities.Course;
import com.reviewdh.deltadc.model.entities.Teacher;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher_course_reviews")
public class TeacherCourseReview extends BaseReview {

    @NotNull(message = "Teacher ID is required")
    private Long teacherId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "teacherId", insertable = false, updatable = false)
    private Teacher teacher;

    @NotBlank(message = "Course ID is required")
    private Long courseId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "courseId", insertable = false, updatable = false)
    private Course course;
}

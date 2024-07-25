package com.reviewdh.deltadc.model.entities.reviews;

import com.reviewdh.deltadc.model.entities.Course;
import com.reviewdh.deltadc.model.entities.Teacher;
import com.reviewdh.deltadc.model.entities.User;
import jakarta.persistence.*;
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

    private Long teacherId;

    @ManyToOne
    @JoinColumn(name = "teacherId", insertable = false, updatable = false)
    private Teacher teacher;

    private Long courseId;

    @ManyToOne
    @JoinColumn(name = "courseId", insertable = false, updatable = false)
    private Course course;

    private Long userId;
    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
}

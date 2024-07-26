package com.reviewdh.deltadc.model.entities.associative;

import com.reviewdh.deltadc.model.entities.BaseEntity;
import com.reviewdh.deltadc.model.entities.Teacher;
import com.reviewdh.deltadc.model.entities.University;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher_contracts")
public class TeacherContract extends BaseEntity {

    @NotBlank(message = "Teacher ID is required")
    private Long teacherId;

    @NotBlank(message = "University ID is required")
    private Long universityId;

    private String position;

    private Date startDate;

    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "teacherId", insertable = false, updatable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "universityId", insertable = false, updatable = false)
    private University university;
}

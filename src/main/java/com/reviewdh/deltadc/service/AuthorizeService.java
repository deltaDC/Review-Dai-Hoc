package com.reviewdh.deltadc.service;

import com.reviewdh.deltadc.model.entities.reviews.BaseReview;
import com.reviewdh.deltadc.model.entities.reviews.MajorReview;
import com.reviewdh.deltadc.model.entities.reviews.TeacherCourseReview;
import com.reviewdh.deltadc.model.entities.reviews.UniversityReview;
import com.reviewdh.deltadc.repository.reviews.MajorReviewRepository;
import com.reviewdh.deltadc.repository.reviews.TeacherCourseReviewRepository;
import com.reviewdh.deltadc.repository.reviews.UniversityReviewRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorizeService {

    private final Map<String, JpaRepository<? extends BaseReview, Long>> repositoryMap;
    private final MajorReviewRepository majorReviewRepository;
    private final TeacherCourseReviewRepository teacherCourseReviewRepository;
    private final UniversityReviewRepository universityReviewRepository;

    @PostConstruct
    public void init() {
        repositoryMap.put(MajorReview.class.getSimpleName(), majorReviewRepository);
        repositoryMap.put(TeacherCourseReview.class.getSimpleName(), teacherCourseReviewRepository);
        repositoryMap.put(UniversityReview.class.getSimpleName(), universityReviewRepository);
    }

    public boolean isOwner(Long id, String reviewType) {
        JpaRepository<? extends BaseReview, Long> repository = repositoryMap.get(reviewType);
        if (repository == null) {
            throw new IllegalArgumentException("Invalid review type: " + reviewType);
        }
        Optional<? extends BaseReview> entityOpt = repository.findById(id);
        if (entityOpt.isPresent()) {
            BaseReview entity = entityOpt.get();
            String currentUsername = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
            return entity.getUser().getUsername().equals(currentUsername);
        }
        return true;
    }

}

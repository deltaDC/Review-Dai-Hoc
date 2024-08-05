package com.reviewdh.deltadc.controller;

import com.reviewdh.deltadc.model.entities.University;
import com.reviewdh.deltadc.response.BaseResponse;
import com.reviewdh.deltadc.service.BaseService;
import com.reviewdh.deltadc.service.UniversityService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/university")
public class UniversityController extends BaseController<University> {

    private final UniversityService universityService;

    public UniversityController(BaseService<University> service, UniversityService universityService) {
        super(service);
        this.universityService = universityService;
    }

    @GetMapping("/list")
    public ResponseEntity<BaseResponse> list(
            @Nullable @RequestParam("name") String name,
            @Nullable @RequestParam("abbreviation") String abbreviation,
            @Nullable @RequestParam("location") String location,
            @Nullable @RequestParam(defaultValue = "0") int page,
            @Nullable @RequestParam(defaultValue = "30") int size
    ) {
        Page<University> universities = universityService.list(page, size, name, abbreviation, location);

        return ResponseEntity.ok(
                BaseResponse.builder()
                        .status(HttpStatus.OK)
                        .message("Success")
                        .data(universities)
                        .build()
        );
    }

}

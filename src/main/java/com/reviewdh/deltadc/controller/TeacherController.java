package com.reviewdh.deltadc.controller;

import com.reviewdh.deltadc.model.entities.Teacher;
import com.reviewdh.deltadc.response.BaseResponse;
import com.reviewdh.deltadc.service.BaseService;
import com.reviewdh.deltadc.service.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController extends BaseController<Teacher>{

    private final TeacherService teacherService;

    public TeacherController(BaseService<Teacher> service, TeacherService teacherService) {
        super(service);
        this.teacherService = teacherService;
    }

    @GetMapping("/list")
    public ResponseEntity<BaseResponse> list(
            @Nullable @RequestParam("fullName") String fullName,
            @Nullable @RequestParam("email") String email,
            @Nullable @RequestParam("phoneNumber") String phoneNumber,
            @Nullable @RequestParam(defaultValue = "0") int page,
            @Nullable @RequestParam(defaultValue = "30") int size
    ) {
        Page<Teacher> teacherPage = teacherService.list(page, size, fullName, email, phoneNumber);

        return ResponseEntity.ok(
                BaseResponse.builder()
                        .status(HttpStatus.OK)
                        .message("Success")
                        .data(teacherPage)
                        .build()
        );
    }

}

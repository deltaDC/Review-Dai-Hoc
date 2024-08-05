package com.reviewdh.deltadc.controller;

import com.reviewdh.deltadc.model.entities.Major;
import com.reviewdh.deltadc.model.enums.DegreeType;
import com.reviewdh.deltadc.response.BaseResponse;
import com.reviewdh.deltadc.service.BaseService;
import com.reviewdh.deltadc.service.MajorService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/major")
public class MajorController extends BaseController<Major>{

    private final MajorService majorService;

    public MajorController(BaseService<Major> service, MajorService majorService) {
        super(service);
        this.majorService = majorService;
    }

    @GetMapping("/list")
    public ResponseEntity<BaseResponse> list(
            @Nullable @RequestParam("majorName") String majorName,
            @Nullable @RequestParam("majorCode") String majorCode,
            @Nullable @RequestParam("degreeType") DegreeType degreeType,
            @Nullable @RequestParam(defaultValue = "0") int page,
            @Nullable @RequestParam(defaultValue = "30") int size
    ) {
        Page<Major> majorPage = majorService.list(page, size, majorName, majorCode, degreeType.toString());

        return ResponseEntity.ok(
                BaseResponse.builder()
                        .status(HttpStatus.OK)
                        .message("Success")
                        .data(majorPage)
                        .build()
        );
    }

}

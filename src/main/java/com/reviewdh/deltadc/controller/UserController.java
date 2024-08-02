package com.reviewdh.deltadc.controller;

import com.reviewdh.deltadc.model.dtos.UserDto;
import com.reviewdh.deltadc.model.entities.User;
import com.reviewdh.deltadc.response.BaseResponse;
import com.reviewdh.deltadc.service.BaseService;
import com.reviewdh.deltadc.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController<User>{

    private final UserService userService;

    public UserController(BaseService<User> service, UserService userService) {
        super(service);
        this.userService = userService;
    }

    @GetMapping("/list")
    public ResponseEntity<BaseResponse> list(
            @Nullable  @RequestParam("username") String username,
            @Nullable @RequestParam("email") String email,
            @Nullable @RequestParam("firstName") String firstName,
            @Nullable @RequestParam("lastName") String lastName,
            @Nullable @RequestParam("phone") String phone,
            @Nullable @RequestParam(defaultValue = "0") int page,
            @Nullable @RequestParam(defaultValue = "30") int size
    ) {
        Page<UserDto> userDtos = userService.list(username, email, firstName, lastName, phone, page, size);

        return ResponseEntity.ok(
                BaseResponse.builder()
                        .status(HttpStatus.OK)
                        .message("Success")
                        .data(userDtos)
                        .build()
        );
    }

}

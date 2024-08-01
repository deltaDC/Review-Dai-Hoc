package com.reviewdh.deltadc.controller;

import com.reviewdh.deltadc.model.dtos.UserDto;
import com.reviewdh.deltadc.model.entities.User;
import com.reviewdh.deltadc.response.BaseResponse;
import com.reviewdh.deltadc.service.BaseService;
import com.reviewdh.deltadc.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("phone") String phone,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size
    ) {
        Page<UserDto> userDtos = userService.list(username, email, firstName, lastName, phone, page, size);
    }

}

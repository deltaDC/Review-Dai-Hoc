package com.reviewdh.deltadc.controller;

import com.reviewdh.deltadc.model.entities.User;
import com.reviewdh.deltadc.service.BaseService;
import com.reviewdh.deltadc.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController<User>{


    public UserController(BaseService<User> service, UserService userService) {
        super(service);
    }


}

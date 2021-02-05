package com.zeta.userservice.controller;

import com.zeta.userservice.dto.UserAddDTO;
import com.zeta.userservice.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    Environment environment;

    @GetMapping("/get")
    public UserDTO get(@RequestParam("id") Integer id) {
        log.info(environment.getProperty("spring.cloud.client.ip-address") + ":" + environment.getProperty("local.server.port"));
        return new UserDTO().setId(id)
                .setName("没有昵称：" + id)
                .setGender(id % 2 + 1); // 1 - 男；2 - 女
    }

    @PostMapping("/add")
    public UserDTO add(@RequestBody UserAddDTO addDTO) {
        log.info(environment.getProperty("spring.cloud.client.ip-address") + ":" + environment.getProperty("local.server.port"));
        return new UserDTO().setId((int) (Math.random() * 10))
                .setGender(addDTO.getGender())
                .setName(addDTO.getName());
    }

}

package com.springstack.demo.controller;

import com.springstack.demo.entity.User;
import com.springstack.demo.repostitory.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Properties;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserRepository repository;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(name = "username", defaultValue = "张三") String usernmae) {
        HttpServletResponse response = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
        assert response != null;
        System.out.println("Default charset: " + response.getCharacterEncoding());

        return "welcome to springboot world" + usernmae;
    }

    @PostMapping(value = "/create")
    public ResponseEntity getUserByCredential(@RequestParam(name = "username", defaultValue = "admin") String username,
                                              @RequestParam(name = "password", defaultValue = "admin") String password) {
        User user = new User();

        repository.save();

        return new ResponseEntity(HttpStatus.CREATED);
    }
}

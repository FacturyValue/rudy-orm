package com.springstack.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author heyahui
 */
@Data
public class User {
    private String username;
    private String password;
    private String email;
    private Integer id;
    private Date birth;

}

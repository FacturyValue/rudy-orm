package com.springstack.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author heyahui
 * @date 2022-04-13
 * SpringBoot的Application中增加注解@ServletComponentScan，这样容器会扫描到@Component注解的Filter。
 */
@RestController
@SpringBootApplication
//@ServletComponentScan("com.springstatck.demo.filter.MyCharacterEncodingFilter")
public class HelloWorldApplication {


    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);

    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "rudy") String name) {
        return "hello world!".concat("\t").concat(name);
    }

}

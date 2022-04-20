package com.springstack.demo.repostitory;

import org.springframework.stereotype.Repository;

import java.lang.annotation.Annotation;

/**
 *
 */
public class UserRepository implements Repository {


    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public void save() {

    }
}

package com.example.newsroom.controller;

import com.example.newsroom.entity.test;
import com.example.newsroom.service.testservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class testcontroller {
    @Autowired
    private testservice testservice;

    @RequestMapping(value = "/test/{id}")
    public test selectUser(@PathVariable int id){

        return testservice.selectUser(id);
    }
}

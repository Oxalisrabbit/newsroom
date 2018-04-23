package com.example.newsroom.service.impl;

import com.example.newsroom.dao.testmapper;
import com.example.newsroom.entity.test;
import com.example.newsroom.service.testservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Testserviceimpl implements testservice {

    @Autowired
    testmapper testmapper;

    @Override
    public test selectUser(int id){

        return testmapper.selectUser(id);
    }
}

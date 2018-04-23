package com.example.newsroom.dao;

import com.example.newsroom.entity.test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface testmapper {

    test selectUser(int id);
}

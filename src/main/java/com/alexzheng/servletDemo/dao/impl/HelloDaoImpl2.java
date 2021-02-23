package com.alexzheng.servletDemo.dao.impl;

import com.alexzheng.servletDemo.dao.HelloDao;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Alex Zheng
 * @Date 2021/2/23 20:34
 * @Annotation 新的Dao
 */
public class HelloDaoImpl2 implements HelloDao {
    @Override
    public List<String> findAll() {
        return Arrays.asList("4","5","6");
    }
}

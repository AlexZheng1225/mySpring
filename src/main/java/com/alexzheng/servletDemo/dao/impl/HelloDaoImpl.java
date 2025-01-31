package com.alexzheng.servletDemo.dao.impl;

import com.alexzheng.servletDemo.dao.HelloDao;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Alex Zheng
 * @Date 2021/2/23 20:34
 * @Annotation
 */
public class HelloDaoImpl implements HelloDao {
    @Override
    public List<String> findAll() {
        //假设Dao层需要修改，则这时候需要重写Dao
        return Arrays.asList("1","2","3");
    }
}

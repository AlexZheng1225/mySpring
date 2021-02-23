package com.alexzheng.servletDemo.service.impl;

import com.alexzheng.servletDemo.dao.HelloDao;
import com.alexzheng.servletDemo.dao.impl.HelloDaoImpl;
import com.alexzheng.servletDemo.factory.BeanFactory;
import com.alexzheng.servletDemo.service.HelloService;

import java.util.List;

/**
 * @Author Alex Zheng
 * @Date 2021/2/23 20:33
 * @Annotation
 */
public class HelloServiceImpl implements HelloService {

    //注入Service
    //由工厂提供
    private HelloDao helloDao = BeanFactory.getDao();

    @Override
    public List<String> findAll() {
        return helloDao.findAll();
    }
}

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

    //测试
    public static void main(String[] args) {
        for (int i = 0;i<5;i++){
            System.out.println(BeanFactory.getDao("HelloDao"));
        }
    }

    //注入Service
    //由工厂提供
    private HelloDao helloDao = (HelloDao)BeanFactory.getDao("HelloDao");

    @Override
    public List<String> findAll() {
        return helloDao.findAll();
    }
}

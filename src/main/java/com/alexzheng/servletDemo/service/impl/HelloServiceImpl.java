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
    //2 松耦合，编译之后仍然可以修改，程序具有扩张性
    private HelloDao helloDao = (HelloDao)BeanFactory.getDao("HelloDao");

    //1 强耦合，编译之后无法修改，没有扩展性
//    private HelloDao helloDao = new HelloDaoImpl();

    @Override
    public List<String> findAll() {
        return helloDao.findAll();
    }
}

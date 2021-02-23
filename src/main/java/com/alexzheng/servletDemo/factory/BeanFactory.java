package com.alexzheng.servletDemo.factory;

import com.alexzheng.servletDemo.dao.HelloDao;
import com.alexzheng.servletDemo.dao.impl.HelloDaoImpl;

/**
 * @Author Alex Zheng
 * @Date 2021/2/23 20:43
 * @Annotation 静态工厂类
 */
public class BeanFactory {
    public static HelloDao getDao(){
        return new HelloDaoImpl();
    }
}

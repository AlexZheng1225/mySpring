package com.alexzheng.servletDemo.factory;

import com.alexzheng.servletDemo.dao.HelloDao;
import com.alexzheng.servletDemo.dao.impl.HelloDaoImpl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * @Author Alex Zheng
 * @Date 2021/2/23 20:43
 * @Annotation 静态工厂类
 */
public class BeanFactory {

    private static Properties properties;

    static {
        properties = new Properties();
        //使用反射[类加载器]读取配置文件
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getDao(){
        String value = properties.getProperty("HelloDao");
//        String value1 = "com.alexzheng.servletDemo.dao.impl.HelloDaoImpl";
//        System.out.println(value);
        //反射机制创建对象
        //根据配置文件动态读取Dao
        try {
            Class clazz = Class.forName(value);
//            Class clazz = Class.forName(value);
            Object instance = clazz.getConstructor().newInstance();
            return instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.alexzheng.servletDemo.factory;

import com.alexzheng.servletDemo.dao.HelloDao;
import com.alexzheng.servletDemo.dao.impl.HelloDaoImpl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author Alex Zheng
 * @Date 2021/2/23 20:43
 * @Annotation 静态工厂类
 */
public class BeanFactory {

    private static Properties properties;

    //设置一个cache
    private static Map<String,Object> cache = new HashMap<>();

    static {
        properties = new Properties();
        //使用反射[类加载器]读取配置文件
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getDao(String beanName){

        //先判断缓存中是否存在Bean
        if (!cache.containsKey(beanName)){
            synchronized (BeanFactory.class){
                //double check
                if (!cache.containsKey(beanName)){
                    String value = properties.getProperty("HelloDao");
                    //反射机制创建对象
                    //根据配置文件动态读取Dao
                    try {
                        Class clazz = Class.forName(value);
                        Object instance = clazz.getConstructor().newInstance();
                        cache.put(beanName,instance);
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
                }
            }
        }
        return cache.get(beanName);
    }
}

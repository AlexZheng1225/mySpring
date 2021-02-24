package com.alexzheng.myspring.test;

import com.alexzheng.myspring.MyAnnotationConfigApplicationContext;

/**
 * @Author Alex Zheng
 * @Date 2021/2/24 8:31
 * @Annotation
 */
public class Test {
    public static void main(String[] args) {
        MyAnnotationConfigApplicationContext applicationContext = new MyAnnotationConfigApplicationContext("com.alexzheng.myspring.entity");
        System.out.println(applicationContext.getBean("account"));
    }
}

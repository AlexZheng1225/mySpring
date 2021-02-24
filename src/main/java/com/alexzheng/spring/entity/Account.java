//package com.alexzheng.spring.entity;
//
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * @Author Alex Zheng
// * @Date 2021/2/3 21:22
// * @Annotation
// */
//@Data
//@Component
//public class Account {
//
//    @Value("1")
//    private Integer id;
//
//    @Value("Alex")
//    private String name;
//
//    @Value("23")
//    private Integer age;
//
//    //这么写可以把Order的值赋值过来 @Autowired [byType] 或者 @Resource
//    @Autowired //Autowired默认byType 故名字不同没关系
//    @Qualifier("order") //通过名字装载的话使用Qualifier
//    private Order myOrder;
//
//}

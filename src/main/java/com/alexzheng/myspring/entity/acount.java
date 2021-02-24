package com.alexzheng.myspring.entity;

import com.alexzheng.myspring.annotation.Component;
import com.alexzheng.myspring.annotation.Value;

/**
 * @Author Alex Zheng
 * @Date 2021/2/24 8:32
 * @Annotation
 */
@Component
public class acount {

    @Value("1")
    private Integer id;

    @Value("Alex")
    private String name;

    @Value("23")
    private Integer age;
}

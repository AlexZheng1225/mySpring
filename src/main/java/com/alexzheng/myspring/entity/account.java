package com.alexzheng.myspring.entity;

import com.alexzheng.myspring.annotation.Autowired;
import com.alexzheng.myspring.annotation.Component;
import com.alexzheng.myspring.annotation.Qualifier;
import com.alexzheng.myspring.annotation.Value;
import lombok.Data;

/**
 * @Author Alex Zheng
 * @Date 2021/2/24 8:32
 * @Annotation
 */
@Data
@Component
public class account {

    @Value("1")
    private Integer id;

    @Value("Alex")
    private String name;

    @Value("23")
    private Integer age;

    @Autowired
    @Qualifier("myOrder")
    private Order order;
}

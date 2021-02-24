package com.alexzheng.myspring.entity;

import com.alexzheng.myspring.annotation.Component;
import com.alexzheng.myspring.annotation.Value;
import lombok.Data;

/**
 * @Author Alex Zheng
 * @Date 2021/2/24 8:52
 * @Annotation
 */
@Data
@Component("myOrder")
public class Order {

    @Value("xxxxxxx")
    private String orderId;

    @Value("1000.36")
    private Double price;

}

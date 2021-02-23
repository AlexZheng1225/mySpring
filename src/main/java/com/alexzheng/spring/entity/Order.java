package com.alexzheng.spring.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author Alex Zheng
 * @Date 2021/2/3 21:31
 * @Annotation
 */
@Data
@Component("order")
public class Order {

    @Value("zc11225")
    private String orderId;

    @Value("1000.0")
    private Float proce;

}

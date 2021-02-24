package com.alexzheng.myspring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Alex Zheng
 * @Date 2021/2/24 11:11
 * @Annotation
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
    //不需要和其他注解一样写String了，因为Autowired注解不需要赋值
}

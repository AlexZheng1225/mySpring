package com.alexzheng.myspring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Alex Zheng
 * @Date 2021/2/24 8:45
 * @Annotation
 */
@Target(ElementType.FIELD) //给成员属性加
@Retention(RetentionPolicy.RUNTIME) //运行时生效
public @interface Value {
    String value();
}

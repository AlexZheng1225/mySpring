package com.alexzheng.myspring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Alex Zheng
 * @Date 2021/2/24 8:42
 * @Annotation 自定义注解
 */
@Target(ElementType.TYPE) //代表类注解
@Retention(RetentionPolicy.RUNTIME) //运行时生效
public @interface Component {
    String value() default "";
}

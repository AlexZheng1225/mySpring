package com.alexzheng.myspring;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Alex Zheng
 * @Date 2021/2/24 8:22
 * @Annotation
 */
@Data
@AllArgsConstructor
public class BeanDefinition {

    private String beanName;

    private Class beanClass;

}

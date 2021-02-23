package com.alexzheng.myspring;

import java.util.Set;

/**
 * @Author Alex Zheng
 * @Date 2021/2/3 22:02
 * @Annotation
 */
public class MyAnnotationConfigApplicationContext {

    public MyAnnotationConfigApplicationContext(String pack) {
        //遍历包，找到目标类（原材料）
        Set<BeanDefinition> beanDefinitions = findBeanDefinitions(pack);
    }

    public Set<BeanDefinition> findBeanDefinitions(String pack){
        //1.获取包下的所有类
        //2.遍历这些类，找到添加注解的类
        //3.将这些类封装成BeanDefinition，装载到集合中
        
        return null;
    }

}

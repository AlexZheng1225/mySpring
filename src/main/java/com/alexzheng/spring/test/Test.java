package com.alexzheng.spring.test;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Alex Zheng
 * @Date 2021/2/3 21:23
 * @Annotation
 */
public class Test {
    public static void main(String[] args) {
        //加载IOC容器-ApplicationContext 除了ApplicationContext还有BeanFactory
        //使用注解不能使用 new ClassPathXmlApplicationContext();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.alexzheng.spring.entity");
        //获取类信息
        System.out.println(applicationContext.getBean("account"));//要写小写类名
        //获取IOC中所有的Bean个数
        System.out.println(applicationContext.getBeanDefinitionCount());
        //返回String类型的数组,获取所有bean的名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames(); //获取所有的bean的名字
        for (String beanDefinitionName:beanDefinitionNames){
            System.out.println(beanDefinitionName);
            System.out.println(applicationContext.getBean(beanDefinitionName));
        }
    }
}

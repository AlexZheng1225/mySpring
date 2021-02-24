package com.alexzheng.myspring;

import com.alexzheng.myspring.annotation.Component;
import com.alexzheng.myspring.annotation.Value;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author Alex Zheng
 * @Date 2021/2/3 22:02
 * @Annotation
 */
public class MyAnnotationConfigApplicationContext {

    private Map<String,Object> ioc = new HashMap<>();

    public MyAnnotationConfigApplicationContext(String pack) {
        //遍历包，找到目标类（原材料）
        Set<BeanDefinition> beanDefinitions = findBeanDefinitions(pack);
        //根据原材料创建Bean
        createObject(beanDefinitions);

    }

    /**
     * 通过beanName获取对象
     * @param beanName
     * @return
     */
    public Object getBean(String beanName){
        return ioc.get(beanName);
    }

    /**
     * 根据原材料创建BeanDefinition
     * @param beanDefinitions
     */
    private void createObject(Set<BeanDefinition> beanDefinitions){
        Iterator<BeanDefinition> iterator = beanDefinitions.iterator();
        while (iterator.hasNext()){
            BeanDefinition beanDefinition = iterator.next();
            //先拿到class 才能创建对象
            Class clazz = beanDefinition.getBeanClass();
            String beanName = beanDefinition.getBeanName();
            try {
                //获取对象
                Object object = clazz.getConstructor().newInstance();
                //先完成属性的赋值
                //获取类中的所有成员属性
                Field[] declaredFields = clazz.getDeclaredFields();
                for(Field declaredField : declaredFields){
                    //判断属性有无添加@value注解
                    Value annotation = declaredField.getAnnotation(Value.class);
                    //则有注解
                    if (annotation != null){
                        String value = annotation.value();
                        //获取成员变量名
                        String fileName = declaredField.getName();
                        //使用Set方法进行赋值，要拼出一个Set方法，例如setId
                        String methodName = "set" + fileName.substring(0,1).toUpperCase()+fileName.substring(1);
//                        System.out.println(methodName);
                        //传入两个参数，set方法名和变量类型
                        Method method = clazz.getMethod(methodName, declaredField.getType());
                        //数据类型转换 [将@Value注解中的String类型值转化为其变量所对应的值]
                        Object val = null;
                        //打印出所有变量类型名
//                        System.out.println(declaredField.getType().getName());
                        //使用switch
                        switch (declaredField.getType().getName()){
                            case "java.lang.Integer":
                                val = Integer.parseInt(value);
                                break;
                            case "java.lang.String":
                                val = value;
                                break;
                            case "java.lang.Float":
                                val = Float.parseFloat(value);
                                break;
                            case "java.lang.Double":
                                val = Double.parseDouble(value);
                                break;
                        }
                        //不要直接使用value，会发生变量类型不匹配的问题，使用已经调整过的val
//                        method.invoke(object,value);
                        method.invoke(object,val);
                    }
                }
                //再将对象存入缓存中
                ioc.put(beanName,object);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 返回一个集合，里面包含了传入包下的所有有注解的类
     * @param pack
     * @return
     */
    private Set<BeanDefinition> findBeanDefinitions(String pack){
        //1.获取包下的所有类
        Set<Class<?>> classes = MyTools.getClasses(pack);
        Iterator<Class<?>> iterator = classes.iterator();
        Set<BeanDefinition> beanDefinitions = new HashSet<>();
        while (iterator.hasNext()){
            //2.遍历这些类，找到添加注解的类
            Class<?> clazz = iterator.next();
            Component componentAnnotation = clazz.getAnnotation(Component.class); //查询是否带有注解
            if (componentAnnotation != null){
//                System.out.println(clazz+"添加了Component注解");
                //获取Component的值
                String beanName = componentAnnotation.value();
                //beanName为空时
                if ("".equals(beanName)){
                    //获取类名-首字母小节
//                    System.out.println(clazz.getPackage().getName()+"."); //com.alexzheng.myspring.entity.
//                    System.out.println(clazz.getName().replace(clazz.getPackage().getName()+".","")); //com.alexzheng.myspring.entity.acount
                    //使用替换的方式拿到类名
                    String className = clazz.getName().replace(clazz.getPackage().getName() + ".", "");
                    //获取beanName
                    beanName = className.substring(0, 1).toLowerCase() + className.substring(1);
                }
                //3.将这些类封装成BeanDefinition，装载到集合中
                beanDefinitions.add(new BeanDefinition(beanName,clazz));
//                System.out.println(beanName);
            }
        }
        return beanDefinitions;
    }

}

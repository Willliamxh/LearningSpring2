package com.ba03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Willam_xh
 * @create 2021-10-12 16:13
 */


@Component("myStudent")
public class Student {
    /**
     * @Value:简单类型的属性赋值
     *      属性：value是String类型的，表示简单类型的属性值
     *      位置： 1.在属性定义上面，无需set方法，推荐使用
     *           2.在set方法的上面
     *
     */
    @Value(value = "张飞")
    private String name;
    @Value(value = "29")
    private Integer age;

    /**
     * 引用类型
     * @Autowired：spring框架提供注解，实现引用类型的赋值
     * spring中通过注解给引用类型赋值，使用的是自动注入原理，支持byName，byType
     * @Autowired：默认使用的是byType的自动注入
     *
     *  位置：1）在属性定义的上面，无需set方法，推荐使用
     *       2）在set方法的上面（感觉和value一样）
     *
     */
    @Autowired
    private School school;//1.注解实现school 2.去配置文件实现school

    public Student() {
        System.out.println("student 无参数构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    @Value("30")
    public void setAge(Integer age) {
        System.out.println("调用了student的set方法");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}

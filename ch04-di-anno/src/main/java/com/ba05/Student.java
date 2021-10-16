package com.ba05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Willam_xh
 * @create 2021-10-12 16:13
 */


@Component("myStudent")
public class Student {
    @Value(value = "李四")
    private String name;
    @Value(value = "29")
    private Integer age;

    /**
     * 引用类型
     * @Autowired：spring框架提供注解，实现引用类型的赋值
     * spring中通过注解给引用类型赋值，使用的是自动注入原理，支持byName，byType
     * @Autowired：默认使用的是byType的自动注入
     *
     *  属性：required，一个boolean类型，默认是true
     *      required=true 表示引用类型赋值失败，程序报错，并终止执行 （一般用真 这样的话能定位到问题）
     *      required=false 引用类型如果赋值失败，程序正常执行，引用类型是个null
     *
     *
     *  位置：1）在属性定义的上面，无需set方法，推荐使用
     *       2）在set方法的上面（感觉和value一样）
     *
     * 如果要使用byname的方式。需要做的是：
     * 1.加上Autowired
     * 2.在属性上面加入@Qualifier(value="bean的id"):表示使用指定名称的bean完成赋值
     *
     */
    @Autowired
    @Qualifier("mySchool")
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

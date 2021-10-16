package com.ba07;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Willam_xh
 * @create 2021-10-12 16:13
 */


@Component("myStudent")
public class Student {
    @Value(value = "李四07")
    private String name;
    @Value(value = "29")
    private Integer age;

    /**
     * 引用类型
     * @Resources:  来自jdk中的注解，Spring框架提供了对这个注解的功能支持，可以使用它给引用类型赋值
     *              使用的也是自动注入的原理，支持byName，byType，默认是byName
     * 使用位置：
     *  1.在属性定义上面，无需set方法，推荐使用
     *  2.在set方法的上面
     *
     * @Resources 只是用byName的方式，那需要增加一个属性 name
     * name的值是bean的id （名称）
     */
    //只是用byName
    @Resource(name = "mySchool")
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

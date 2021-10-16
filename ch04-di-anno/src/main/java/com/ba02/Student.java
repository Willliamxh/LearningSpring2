package com.ba02;

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
    @Value("${myname}")
    private String name;
    @Value(value = "29")
    private Integer age;

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
        System.out.println("调用了set方法");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

package com.ba01;

import org.springframework.stereotype.Component;

/**
 * @author Willam_xh
 * @create 2021-10-12 16:13
 */

/**
 * @Component 是用来创建对象的，等同于bean的功能
 *  属性：value 就是对象的名称，也就是bean的id值。
 *       value的值是唯一的，创建的对象在整个spring容器中就一个
 *  位置：在这个类的上面
 *
 *  @Component(value = "myStudent")等同于
 *  <bean id=“myStudent” class="com.ba01.Student"/>
 *      1.使用value属性 指定对象的名称
 *          @Component(value = "myStudent")、
 *      2.省略value属性（这个公司用的最多）
 *          @Component("myStudent")
 *      3.我不指定对象的名称，由spring提供默认名称:类名的首字母小写。
 *          @Component
 *
 * spring中的和@component功能一致，创建对象的注解还有：
 * 1.@Responsitory(用在持久层类的上面的)：放在dao的实现类上面，
 *                                  表示创建dao对象，dao对象是能访问数据库的。（访问数据库的）
 * 2.@Responsitory(用在业务层类上面)：放在service的实现类上面，创建service对象，service对象是做业务处理的，
 *                              可以有事务等功能的。（做业务逻辑处理）
 * 3.@Controller(用在控制器的上面)：放在控制器类的上方，创建控制器对象的，
 *                              控制器对象能够接受用户提交的参数，显示请求的处理结果。（用于展示）
 * 以上三个注解的使用语法和@Component一样 都能创建对象，但是这个三个注解还有额外的功能。
 * @Responsitory，@Responsitory，@Controller 是给我们的项目对象分层的。除了创建对象的功能，还有角色声明的功能
 *
 * @component:通用注解，不在三层的类就用这个注解，没有特殊意义
 * @Controller:springmvc的注解，具有请求转发，重定向等功能
 * @Service:业务逻辑层注解，没有特殊功能，只是表示此为业务逻辑层
 * @Repository:dao层注解，具有将数据库操作抛出的原生异常翻译转化为spring的持久层异常的功能
 *
 * 那我什么时候用component呢？
 *  当这个类，不是dao，不是service，不是Controller的时候，就component吧。
 *
 *
 *
 *
 */
@Component("myStudent")
public class Student {
    private String name;
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

    public void setAge(Integer age) {
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

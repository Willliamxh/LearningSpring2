package com.bjp.ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * @author Willam_xh
 * @create 2021-10-14 18:12
 * 定义切面类
 */

/**
 * @Aspect: 是aspectj框架最后都能注解、
 *         作用：表示当前类是切面类
 *         切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
 *         位置：在类定义上面
 */
@Aspect
public class MyAspect {
    /**
     * 定义方法，方法是实现切面功能的。
     * 方法定义要求：
     * 1.公共方法public
     * 2.方法没有返回值
     * 3.方法名称自定义
     * 4.方法是有参数的，参数推荐是Object，参数名称自定义。
     */

    /**
     * @AfterReturning :后置通知
     *      属性:1.value 切入点表达式 就是那个execution
     *          2.returning 自定义的变量，表示目标方法的返回值。
     *          自定义的变量名必须和通知方法的形参名称一样。
     *      位置:在方法定义的上面
     * 特点：
     *  1。在目标方法后执行的。
     *  2。能够获取到目标方法的返回值，可以根据这个返回值做不同的处理的功能
     *      Object res=doOther()
     *  3。可以修改这个返回值
     *
     *  后置通知的执行：
     *  Object res=doOther();  //先执行目标方法
     *  myAfterReturning(rse); //后执行切面方法
     *  sout"rse" 字符串是不会变的
     *
     *
     */
    @AfterReturning(value="execution(* *..SomeServiceImpl.doOther(..))",
            returning = "res")
    public void myAfterReturning(Object res){
        //Object res 是我们的目标方法执行后的返回值，我们可以根据返回值做一些对应的处理
        System.out.println("后置通知：是在目标方法执行之后执行的，返回值是="+res);
        if(res.equals("abcd")){
            //做一些功能
        }else{
            //做一些别的功能
        }

        //如果我们改了对应的res 那会影响到结果嘛？
        if(res!=null){
            res="hello aspectj!";
        }
    }

    @AfterReturning(value="execution(* *..SomeServiceImpl.doOther2(..))",
            returning = "res")
    public void myAfterReturning2(Object res){
        //Object res 是我们的目标方法执行后的返回值，我们可以根据返回值做一些对应的处理
        System.out.println("后置通知：是在目标方法执行之后执行的，返回值是="+res);

        //修改目标方法的返回值 看看是否会影响最后方法的调用结果
        //如果我们修改了res的内容、属性值等，是否会影响最后的调用结果呢？
        //其实这边就是一个值传递机制
       ((Student) res).setAge(25);
        ((Student) res).setName("xuhan");



    }






}

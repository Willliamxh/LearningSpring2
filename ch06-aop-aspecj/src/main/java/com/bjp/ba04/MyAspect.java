package com.bjp.ba04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

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
     * 异常通知方法的定义格式
     * 方法定义要求：
     * 1.公共方法public
     * 2.方法没有返回值
     * 3.方法名称自定义
     * 4.方法有一个参数Exception 如果还有 那就是joinPoint
     */
    /**
     * @AfterThrowing:异常通知
     *      属性：
     *          1.value 切入点表达式
     *          2.throwing 自定义的变量，表示目标方法抛出的异常对象。
     *          变量名称必须和方法的参数名一样
     * 特点：
     *      1.目标方法抛出异常时执行的。
     *      2.可以作为异常的监控程序 ，监控目标方法在执行的时候是不是有异常
     *          如果有异常，可以发送邮件短信 进行通知。
     *
     * 执行就是：
     * 发生异常的时候走afterThrowing
     * try{
     *      SomeServiceImpl.doSecond
     * }catch{
     *      afterThrowing();
     * }
     */

    @AfterThrowing(value = "execution(* *..SomeServiceImpl.doSecond(..))",
            throwing="ex")
    public void afterThrowing(Exception ex){
        System.out.println("异常通知：方法发生异常时，执行："+ex.getMessage());
        //发送短信，邮件，通知开发人员
    }





}

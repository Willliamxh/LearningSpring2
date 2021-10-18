package com.bjp.ba05;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
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
     * 定义方法，方法是实现切面功能的。
     * 方法定义要求：
     * 1.公共方法public
     * 2.方法没有返回值
     * 3.方法名称自定义
     * 4.方法没有参数的，如果有 就是joinPoint
     */
    /**
     * @After：最终通知
     *    属性：value 切入点表达式
     *    位置：在方法的上面
     * 特点：
     *    1.总是会执行
     *    2.在目标方法后执行的。
     *
     * try{
     *     SomeServiceImpl.doThird(..)
     * }catch{
     *
     * }finally{
     *     myAfter()
     * }
     *
     *
     */
    @After(value = "execution(* *..SomeServiceImpl.doThird(..))")
    public void myAfter(){
        System.out.println("执行最终通知，总是会被执行的代码");
        //一般是用来做资源清除工作的
    }




}

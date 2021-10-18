package com.bjp.ba03;

import com.bjp.ba02.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import javax.annotation.PreDestroy;
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
     * 环绕通知方法的定义格式
     * 1.public
     * 2.必须要有一个返回值，推荐使用Object
     * 3.方法名称自定义
     * 4.方法有参数，固定的参数 ProceedingJoinPoint
     *
     * @Around：环绕通知
     *  属性：value 切入点表达式
     *  位置：在方法的定义的上面
     *
     * 特点：
     *  1.它是功能最强的通知
     *  2.在目标方法的前和后都能增强功能
     *  3.控制目标方法是否被调用执行
     *  4.修改原来哦目标方法的执行结果。影响最后的调用结果
     *
     *
     * 环绕通知 等同于jdk的动态代理，InvocationHandler那个接口
     *
     * 参数：ProceedingJoinPoint 等同于 InvocationHandler的那个Method
     *      作用：执行目标方法
     * 返回值：就是目标方法的执行结果，可以被修改。
     *
     * 环绕通知：经常做事务，在目标方法之前开启事务，执行目标方法。在目标方法之后提交事务。
     *
     */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        String name = null;
        //获取第一个参数值
        Object args[]=pjp.getArgs();
        if(args!=null && args.length>1){
            Object arg=args[0];
            name= (String) arg;
        }


        //实现环绕通知的功能
        Object result=null;
        System.out.println("环绕通知：在目标方法之前，输出时间："+new Date());
        //1.目标方法的调用
        if("xuhan".equals(name)){
            //符合条件,调用目标方法
            result=pjp.proceed();//method.invoke(); Object result=doFirst();
        }

        //2.在目标方法前或者后加入功能
        System.out.println("环绕通知：在目标方法之后，提交事务");

        //修改目标方法的执行结果，影响方法最后的调用结果
        if(result!=null){
            result="环绕通知修能修改原本的结果并返回";
        }

        //返回目标方法的执行结果
        return result;



    }






}

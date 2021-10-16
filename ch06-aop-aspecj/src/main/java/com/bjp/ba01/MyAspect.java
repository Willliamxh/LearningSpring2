package com.bjp.ba01;

import org.aspectj.lang.JoinPoint;
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
     * 4.方法可以有参数，也可以没有参数。
     *   如果有参数，参数不是自定义的，有几个参数类型可以使用
     */

    /**
     * @Before:前置通知注解
     *  属性：value，是切入点表达式，表示切面的功能执行位置（target的方法位置）。就是在那里执行我们这个切面
     *  位置：在方法的上面
     * 特点：
     *  1.在目标方法之前先执行的
     *  2.不会改变目标方法的执行结果
     *  3.不会影响目标方法的执行
     *
     */
    // //方法执行之前               访问范围 返回值 包名        实现类          方法     形参
    // @Before(value = "execution(public void com.bjp.ba01.SomeServiceImpl.doSome(String,Integer))")
    // public void myBefore(){
    // //    这里解释你切面要执行的功能代码
    //     System.out.println("前置通知，切面功能：在目标方法执行之前输出执行时间："+new Date());
    // }

    //方法执行之前               访问范围 返回值 包名        实现类          方法     形参
    // @Before(value = "execution( void com.bjp.ba01.SomeServiceImpl.doSome(String,Integer))")
    // public void myBefore(){
    //     //    这里解释你切面要执行的功能代码
    //     System.out.println("1省略了访问范围=========前置通知，切面功能：在目标方法执行之前输出执行时间："+new Date());
    // }

    // //方法执行之前               访问范围 返回值 包名        实现类          方法     形参
    // @Before(value = "execution( void *..SomeServiceImpl.doSome(String,Integer))")
    // public void myBefore(){
    //     //    这里解释你切面要执行的功能代码
    //     System.out.println("2把包名省略为*.. =====前置通知，切面功能：在目标方法执行之前输出执行时间："+new Date());
    // }

    // //方法执行之前               访问范围 返回值 包名        实现类          方法     形参
    // @Before(value = "execution(* *..SomeServiceImpl.do*(..))")
    // public void myBefore(){
    //     //    这里解释你切面要执行的功能代码
    //     System.out.println("3访问范围和参数全部省略,do开头的所有方法=========前置通知，切面功能：在目标方法执行之前输出执行时间："+new Date());
    // }

    // //方法执行之前               访问范围 返回值 包名        实现类          方法     形参
    // @Before(value = "execution(* do*(..))")
    // public void myBefore2(){
    //     //    这里解释你切面要执行的功能代码
    //     System.out.println("4加了两个通知 do开头的所有方法=========前置通知，切面功能：在目标方法执行之前输出执行时间："+new Date());
    // }


    //如果参数没有写完整的话，配置文件中的aspectj-autoproxy会扫不到对应的代理类
    // @Before(value = "execution( void *..SomeServiceImpl.doSome(String,Integer))")
    // public void myBefore2(){
    // //    这里解释你切面要执行的功能代码
    // System.out.println("2把包名省略为*.. =====前置通知，切面功能：在目标方法执行之前输出执行时间："+new Date());
    // }

    /**
     *指定通知方法中的参数：JointPoint
     * JointPoint代表的是业务方法 ，也就是要加入切面功能的业务方法(也就是doSome方法)
     *      作用是：可以在通知方法中获取方法执行时的信息，例如 方法名称、方法实参
     *      如果你的切面功能中需要用到方法的信息，就加入JointPoint
     *      这个JointPoint参数的值是由框架赋予的，必须是第一个位置的参数
     */
    @Before(value = "execution( void *..SomeServiceImpl.doSome(String,Integer))")
    public void myBefore(JoinPoint joinPoint){
        //获取方法的完整定义
        System.out.println("方法的签名(定义)="+joinPoint.getSignature());
        System.out.println("方法的名称="+joinPoint.getSignature().getName());
        //获取方法的实参
        System.out.println("方法的实参=");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("参数="+arg);
        }


        //    这里解释你切面要执行的功能代码
        System.out.println("2把包名省略为*.. =====前置通知，切面功能：在目标方法执行之前输出执行时间："+new Date());
    }



}

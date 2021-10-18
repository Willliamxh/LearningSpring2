package com.bjp.ba08;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

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
     * 问题的发现：我们发现我们的目标类* *..SomeServiceImpl.doThird(..)
     * 被复用了很多次。所以 我们想减少这个复用 就用JointPoint的注解
     */
    @After(value = "myPt()")
    public void myAfter(){
        System.out.println("执行最终通知，总是会被执行的代码");
        //一般是用来做资源清除工作的
    }

    @Before(value = "execution(* *..SomeServiceImpl.doThird(..))")
    public void myBefore(){
        System.out.println("执行前置通知");
        //一般是用来做资源清除工作的
    }

    /**
     * @Pointcut:定义和管理切入点 如果我们的项目中有多个切入点表达式是重复的 可以复用的
     *          可以使用@pointcut
     *   属性：value 切入点表达式
     *   位置：在自定义方法上面
     *   特点：当使用@pointcut定义在一个方法上面，此时这个方法的名称就是切入点表达式的别名
     *   其它的通知中，value属性就可以使用这个方法名称，代替切入点的表达式了
     */
    @Pointcut(value = "execution(* *..SomeServiceImpl.doThird(..))")
    public void myPt(){
        //无需代码 这个myPt就代表上面那个表达式了

    }




}

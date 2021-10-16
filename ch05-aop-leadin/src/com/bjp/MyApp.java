package com.bjp;

import com.bjp.handler.MyInvocationHandler;
import com.bjp.service.SomeService;
import com.bjp.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Willam_xh
 * @create 2021-10-13 14:23
 */
public class MyApp {
    public static void main(String[] args) {
    // //    调用doSome doOther 原始方式
    //     SomeService someService=new SomeServiceImpl();
    //     someService.doSome();
    //     System.out.println("=========================");
    //     someService.doOther();

    //    使用jdk的proxy创建代理对象
    //     创建目标对象
        SomeService target=new SomeServiceImpl();

        //创建InvocationHandler对象
        InvocationHandler handler=new MyInvocationHandler(target);

        //使用proxy创建代理
        SomeService proxyInstance= (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//这个是反射的classLoader
                target.getClass().getInterfaces(),//这个是被代理类实现的接口 new Class[]{SomeService.class}
                handler);//这个是自定义的handler

        // //通过代理执行方法，会调用handler中的invoke方法
        proxyInstance.doSome();
        System.out.println("===========================");
        proxyInstance.doOther();

        //许晗自己的测试
        // Class<?>[] interfaces = target.getClass().getInterfaces();
        // for (Class<?> anInterface : interfaces) {
        //     System.out.println(anInterface.getName());
        // }
        // //new Class[]{SomeService.class}
    }
}

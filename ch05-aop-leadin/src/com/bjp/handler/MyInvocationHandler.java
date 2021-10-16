package com.bjp.handler;

import com.bjp.service.SomeService;
import com.bjp.utils.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Willam_xh
 * @create 2021-10-13 14:46
 */
public class MyInvocationHandler implements InvocationHandler {
    //目标对象（被代理对象）
    private Object target;//这个是我们要扩展功能的类 也就是SomeServiceImpl类

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    //                 proxyInstance.     doSome         ();
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过代理对象调用方法的时候 会调用invoke()
        Object res=null;
        System.out.println("执行了invoke方法");
        System.out.println("method:"+method.getName());

        //执行方法之前记录日志
        ServiceTools.doLog();

        //执行被代理类的方法，通过method类实现
        res=method.invoke(target,args);//someServiceImpl.doOther，doSome

        //执行方法之后执行事务
        ServiceTools.doTrans();

        return res;
    }
}

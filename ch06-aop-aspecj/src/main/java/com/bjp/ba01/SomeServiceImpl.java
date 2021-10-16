package com.bjp.ba01;

/**
 * @author Willam_xh
 * @create 2021-10-14 17:15
 * 这个是目标类，也就是被代理类
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        //给doSome方法增加一个功能，在doSome之前，输出方法执行时间
        System.out.println("===========目标方法doSome=========");
    }
}



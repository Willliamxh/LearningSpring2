package com.bjp.ba01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Willam_xh
 * @create 2021-10-14 18:55
 */

public class MyTest01 {
    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService proxy= (SomeService) context.getBean("someService");
        //通过代理的对象执行方法，实现目标方法执行时，才增强了功能

        // proxy:com.sun.proxy.$Proxy8:默认使用的是jdk的动态代理
        System.out.println("proxy:"+proxy.getClass().getName());

        proxy.doSome("lisi",25);
    }
}

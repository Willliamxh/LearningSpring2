package com.bjp.ba03;

import com.bjp.ba02.Student;
import com.bjp.ba03.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Willam_xh
 * @create 2021-10-14 18:55
 */

public class MyTest03 {
    @Test
    public void test02(){
        String config="applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService proxy= (SomeService) context.getBean("someService");
        //通过代理的对象执行方法，实现目标方法执行时，才增强了功能

        String res = proxy.doFirst("xuhan", 25);
        //其实环绕通知就是把这个函数调用 改成了myAround() 这个函数的调用。
        System.out.println("最终的调用结果为====="+res);



    }
}

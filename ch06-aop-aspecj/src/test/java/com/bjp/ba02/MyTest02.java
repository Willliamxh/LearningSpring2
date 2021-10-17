package com.bjp.ba02;

import com.bjp.ba02.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Willam_xh
 * @create 2021-10-14 18:55
 */

public class MyTest02 {
    @Test
    public void test02(){
        String config="applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService proxy= (SomeService) context.getBean("someService");
        //通过代理的对象执行方法，实现目标方法执行时，才增强了功能

        String str = proxy.doOther("王五", 28);

        System.out.println("str的返回值为："+str);

        Student student = proxy.doOther2("王五", 28);
        System.out.println("Student的返回值为："+student);

    }
}

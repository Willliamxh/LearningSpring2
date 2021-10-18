package com.bjp.ba07;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Willam_xh
 * @create 2021-10-14 18:55
 */

public class MyTest06 {
    @Test
    public void test02(){

        String config="applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeServiceImpl proxy= (SomeServiceImpl) context.getBean("someService");
        //通过代理的对象执行方法，实现目标方法执行时，才增强了功能

        /**
         * 目标类没有借口的时候，使用的是cglib的动态代理，Spring框架会自动应用cglib
         * proxy:com.bjp.ba07.SomeServiceImpl$$EnhancerBySpringCGLIB$$c8c1e7aa
         */
        System.out.println("proxy:"+proxy.getClass().getName());

        proxy.doThird();


    }
}

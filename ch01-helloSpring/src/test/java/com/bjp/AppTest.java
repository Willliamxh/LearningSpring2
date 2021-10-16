package com.bjp;

import static org.junit.Assert.assertTrue;

import com.bjp.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    /**
     * 测试1 主动的方式来创建对象
     */
    @Test
    public void test1(){
        SomeService someService = new SomeServiceImpl();
        someService.doSome();
    }

    /**
     * 测试Spring的使用容器来创建对象
     * 我是没有主动去new这个对象的
     *
     * spring默认创建对象的时间 是创建spring的容器（cpx）的时候，它会创建spring里面所有的对象。默认调用无参的构造方法。
     * （那怎么说明是多个对象呢？ 在xml中加一个bean对象进去 看执行了多少次的构造方法）
     */
    @Test
    public void test2(){
        //1.spring配置文件的名称
        String config="beans.xml";
        //2.创建表示Spring容器的对象 ApplicationContext
        //ApplicationContext 表示Spring容器 我们能够通过这个容器去获取对象
        //ClassPathXmlApplicationContext:表示从类路径中加载spring的配置文件
        //是在执行这句话的时候 把所有的对象给创建出来的 （那怎么说明是多个对象呢？ 在xml中加一个bean对象进去 看执行了多少次的构造方法）
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);

        //从容器中获得某个对象，然后调用对应的方法
        //getBean("配置文件中bean的id值")
        SomeService someService = (SomeService)applicationContext.getBean("someService");

        //使用spring的对象 调用方法
        someService.doSome();

    }

    /**
     * 获取spring容器中java的对象信息
     *
     */
    @Test
    public void test01(){
        String config="beans.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);

        //使用spring提供的方法 获取容器中定义的对象的数量 反射得到的
        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        //每个对象的定义的名称
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
    }


    /**
     * 获取一个非自定义类的对象
     */
    @Test
    public void test04(){
        String config="beans.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);

        Date myDate = (Date)applicationContext.getBean("myDate");
        System.out.println("myDate:"+myDate);

    }
}

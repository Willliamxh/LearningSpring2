package com.bjp;

import com.bjp.service.BuyGoodService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Willam_xh
 * @Date 2021-10-21 16:07
 */
public class AppTest01 {
    /**
     * 正常的事务调用
     */
    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容其中获取的Service
        BuyGoodService buyService = (BuyGoodService)ctx.getBean("buyService");
        System.out.println(buyService.getClass().getName());
        //调用方法
        // buyService.buy(1001,2);
    }


    /**
     * 事务出现异常的情况1：购买了id没有的产品
     * 这会导致只有部分的sql执行了：sale部分添加了一条完全不存在的记录
     */
    @Test
    public void test02(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容其中获取的Service
        BuyGoodService buyService = (BuyGoodService)ctx.getBean("buyService");

        //调用方法
        buyService.buy(1009,2);
    }

    /**
     * 事务出现异常的情况2：商品库存不足
     * 这会导致只有部分的sql执行了：sale部分又添加了一条完全不存在的记录
     */
    @Test
    public void test03(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容其中获取的Service
        BuyGoodService buyService = (BuyGoodService)ctx.getBean("buyService");

        //调用方法
        buyService.buy(1001,200);
    }

    /**
     * 所以 我们需要通过AOP去增加事务的功能
     */


    /**
     * 加上事务之后的正常调用
     */
    @Test
    public void test04(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容其中获取的Service
        BuyGoodService buyService = (BuyGoodService)ctx.getBean("buyService");

        //JDK动态代理对象
        System.out.println(buyService.getClass().getName());
        //在ch08中是 com.bjp.service.impl.BuyGoodServiceImpl
        //调用方法
        buyService.buy(1001,2);
    }

    /**
     * 加上事务之后的异常调用1
     * 可以看到我们的数据并没有收到影响
     */
    @Test
    public void test05(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容其中获取的Service
        BuyGoodService buyService = (BuyGoodService)ctx.getBean("buyService");

        //JDK动态代理对象
        System.out.println(buyService.getClass().getName());
        //在ch08中是 com.bjp.service.impl.BuyGoodServiceImpl
        //调用方法
        buyService.buy(1005,2);
    }

    /**
     * 加上事务之后的异常调用2
     * 可以看到我们的数据还是没有收到影响
     */
    @Test
    public void test06(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容其中获取的Service
        BuyGoodService buyService = (BuyGoodService)ctx.getBean("buyService");

        //JDK动态代理对象
        System.out.println(buyService.getClass().getName());
        //在ch08中是 com.bjp.service.impl.BuyGoodServiceImpl
        //调用方法
        buyService.buy(1001,200);
    }

    /**
     * 怎么证明事务起作用呢？ 就是事务正常走下去的时候，我们已经添加了一条语句
     * 然后当异常发生的时候，事务会把添加的这条语句给撤销掉。
     * 那我们再添加一条记录看看。
     *
     * 可以看到sales是直接变成了7
     * 说明 5 6 是被回滚了
     */
    @Test
    public void test07(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容其中获取的Service
        BuyGoodService buyService = (BuyGoodService)ctx.getBean("buyService");

        //JDK动态代理对象
        System.out.println(buyService.getClass().getName());
        //在ch08中是 com.bjp.service.impl.BuyGoodServiceImpl
        //调用方法
        buyService.buy(1001,1);
    }






}

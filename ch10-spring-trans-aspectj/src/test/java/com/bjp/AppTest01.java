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


}

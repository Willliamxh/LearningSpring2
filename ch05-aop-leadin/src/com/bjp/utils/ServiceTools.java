package com.bjp.utils;

import java.util.Date;

/**
 * @author Willam_xh
 * @create 2021-10-13 14:31
 */
public class ServiceTools {
    public static void doLog(){
        System.out.println("方法执行时间"+new Date());
    }

    public static void doTrans(){
        System.out.println("非业务方法，方法执行之后提交事务");
    }
}

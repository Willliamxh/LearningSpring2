package com.bjp.service.impl;

import com.bjp.service.SomeService;

/**
 * @author Willam_xh
 * @create 2021-10-13 14:22
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行业务方法 doSome");
    }

    @Override
    public void doOther() {
        System.out.println("执行业务方法 doOther");

    }
}

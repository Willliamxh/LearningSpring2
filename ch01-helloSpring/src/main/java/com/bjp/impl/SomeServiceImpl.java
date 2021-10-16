package com.bjp.impl;

import com.bjp.SomeService;

public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl() {
        System.out.println("无参数构造方法");
    }

    @Override
    public void doSome() {
        System.out.println("执行了someServiceImpl" +
                "的doSome方法");
    }
}

package com.bjp.ba04;

import com.bjp.ba02.Student;

/**
 * @author Willam_xh
 * @create 2021-10-14 17:15
 * 这个是目标类，也就是被代理类
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        //给doSome方法增加一个功能，在doSome之前，输出方法执行时间
        System.out.println("===========目标方法doSome=========");
    }

    /**
     * 
     * @param name
     * @param age
     * @return
     * 在这个方法的过程最后模拟一个提交事务的切面 也就是后置通知
     */
    @Override
    public String doOther(String name, Integer age) {
        System.out.println("===========目标方法doOther=========");
        return "abcd";
    }

    @Override
    public Student doOther2(String name, Integer age) {
        Student student=new Student();
        student.setName("lisi");
        student.setAge(20);
        student.setEmail("123@qq.com");
        return student;
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("========业务方法doFirst 我加一个环绕通知=======");

        return "doFirst的一个返回值";
    }

    @Override
    public void doSecond() {
        //异常通知：方法发生异常时，执行：/ by zero
        System.out.println("异常通知 doSecond"+(10/0));
    }
}



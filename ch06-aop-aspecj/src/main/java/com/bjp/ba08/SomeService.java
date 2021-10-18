package com.bjp.ba08;

import com.bjp.ba02.Student;

/**
 * @author Willam_xh
 * @create 2021-10-14 17:15
 */
public interface SomeService {
    void doSome(String name,Integer age);
    String doOther(String name,Integer age);

    Student doOther2(String name, Integer age);

    String doFirst(String name,Integer age);

    void doThird();
}

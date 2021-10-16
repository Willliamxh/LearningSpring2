package com.bjp;

import com.bjp.ba02.Student;
import com.bjp.ba02.School;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class MyTest02 {
    @Test
    public void test01()
    {
        Student student=new Student();
        student.setAge(10);
        student.setName("lisi");

        School school = new School();
        school.setAddress("bj");
        school.setName("xuhan");

        student.setSchool(school);
        System.out.println(student);


    }

    @Test
    public void test02(){
        String config="ba02/applicationContext.xml";
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(config);

        //从容器中获得student对象
        Student myStudent = (Student) classPathXmlApplicationContext.getBean("myStudent");
        System.out.println(myStudent);



    }

}

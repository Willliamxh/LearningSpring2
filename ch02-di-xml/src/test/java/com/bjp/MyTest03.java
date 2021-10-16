package com.bjp;

import com.bjp.ba03.School;
import com.bjp.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {
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
        String config="ba03/applicationContext.xml";
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(config);

        //从容器中获得student对象
        Student myStudent = (Student) classPathXmlApplicationContext.getBean("myStudent2");
        System.out.println(myStudent);



    }

}

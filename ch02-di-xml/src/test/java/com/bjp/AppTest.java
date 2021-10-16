package com.bjp;

import static org.junit.Assert.assertTrue;


import com.bjp.ba01.Student;
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
        String a=new String("a")+new String("b");
    }

    @Test
    public void test01(){
        String config="ba01/applicationContext.xml";
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(config);

        //从容器中获得student对象
        Student myStudent = (Student) classPathXmlApplicationContext.getBean("myStudent");
        System.out.println(myStudent);

        Date mydate= (Date) classPathXmlApplicationContext.getBean("myDate");
        System.out.println(mydate);



    }




}

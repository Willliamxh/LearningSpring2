package com.bjp;

import com.bjp.dao.StudentDao;
import com.bjp.domain.Student;
import com.bjp.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.ws.Service;
import java.util.List;

/**
 * @author Willam_xh
 * @create 2021-10-19 9:51
 */
public class myTest {
    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("容器中的名称："+beanDefinitionName+"||"+ctx.getBean(beanDefinitionName));
        }


    }

    @Test
    public void testDaoInsert(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        /*获取spring容器中的dao对象*/
        StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");

        Student student=new Student();
        student.setId(8);
        student.setName("许晗");
        student.setAge(25);
        student.setEmail("1232@qq.com");

        int nums=studentDao.insertStudent(student);
        System.out.println("nums="+nums);


        // List<Student> studentList = studentDao.selectStudents();
        // for (int i = 0; i < studentList.size(); i++) {
        //     System.out.println(studentList.get(i));
        // }
    }

    @Test
    public void testServiceInsert(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        /*获取spring容器中的dao对象*/
        StudentService studentService= (StudentService) ctx.getBean("studentService");

        Student student=new Student();
        student.setId(9);
        student.setName("许晗2");
        student.setAge(26);
        student.setEmail("12@qq.com");

        /*spring和mybatis整合在一起使用，事务是自动提交的。无需执行sqlSession.commit*/
        int nums = studentService.addStudent(student);
        System.out.println("nums: "+nums);


    }


}

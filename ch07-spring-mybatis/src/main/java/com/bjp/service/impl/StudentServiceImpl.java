package com.bjp.service.impl;

import com.bjp.dao.StudentDao;
import com.bjp.domain.Student;
import com.bjp.service.StudentService;

import java.util.List;

/**
 * @author Willam_xh
 * @create 2021-10-18 19:55
 */
public class StudentServiceImpl implements StudentService {

    //引用类型
    private StudentDao studentDao;

    //使用set注入 赋值
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        int nums=studentDao.insertStudent(student);
        return 0;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> studentList=studentDao.selectStudents();
        return studentList;
    }
}

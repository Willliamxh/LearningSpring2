package com.bjp.service;

import com.bjp.domain.Student;

import java.util.List;

/**
 * @author Willam_xh
 * @create 2021-10-18 19:52
 */
public interface StudentService {
    int addStudent(Student student);
    List<Student> queryStudents();
}

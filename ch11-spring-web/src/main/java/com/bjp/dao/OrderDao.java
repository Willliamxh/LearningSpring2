package com.bjp.dao;

import com.bjp.domain.Student;

import java.util.List;

/**
 * @author Willam_xh
 * @create 2021-10-18 18:50
 */
public interface OrderDao {
    int insertStudent(Student student);

    List<Student> selectStudents();
}

package com.bjp.dao;

import com.bjp.domain.Student;

import java.util.List;

/**
 * @author Willam_xh
 * @create 2021-10-18 18:50
 *
 * insert：   插入n条记录，返回影响行数n。（n>=1，n为0时实际为插入失败）
 *
 * update：更新n条记录，返回影响行数n。（n>=0）
 *
 * delete： 删除n条记录，返回影响行数n。（n>=0）
 */
public interface StudentDao {
    int insertStudent(Student student);

    List<Student> selectStudents();
}

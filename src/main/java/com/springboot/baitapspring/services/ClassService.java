package com.springboot.baitapspring.services;

import com.springboot.baitapspring.model.entity.Class;
import com.springboot.baitapspring.model.entity.Student;

import java.util.List;

public interface ClassService {
    void saveClass(Class clazz);

    void updateClass(Class clazz);

    void deleteClass(long id);

    Class findClass(long id);

    List<Student> findAllStudents(long id);

    List<Class> getAllClasses(); // lấy tất cả các classs trong database
    //List<Class> findStudentById(long id);


}

package com.springboot.baitapspring.services;

import com.springboot.baitapspring.model.entity.Class;
import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.model.in.ClassRequest;
import com.springboot.baitapspring.model.out.ClassDto;

import java.util.List;

public interface ClassService {
    void saveClass(ClassRequest classRequest);

    void updateClass(ClassRequest classRequest);

    void deleteClass(long id);

    ClassDto findClass(long id);

    List<Student> findAllStudents(long id);

    List<Class> getAllClasses(); // lấy tất cả các classs trong database
    //List<Class> findStudentById(long id);


}

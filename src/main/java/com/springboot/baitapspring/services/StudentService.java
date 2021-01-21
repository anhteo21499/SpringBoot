package com.springboot.baitapspring.services;

import com.springboot.baitapspring.model.entity.Class;
import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.model.respon.StudentAddressResponse;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);

    void updateStudent(Student studentMap);

    void deleteStudent(long id);

    List<Student> findStudentByID(long id);

    List<Student> getAllStudents();

    List<StudentAddressResponse> getAddressAndCount();
}

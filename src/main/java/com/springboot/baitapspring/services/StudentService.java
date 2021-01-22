package com.springboot.baitapspring.services;

import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.model.in.StudentRequest;
import com.springboot.baitapspring.model.out.StudentAddressResponse;
import com.springboot.baitapspring.model.out.StudentDto;

import java.util.List;

public interface StudentService {
    void saveStudent(StudentRequest studentRequest);

    void updateStudent(StudentRequest studentRequest);

    void deleteStudent(long id);

    StudentDto findStudentByID(long id);

    List<Student> getAllStudents();

 //   List<StudentAddressResponse> getAddressAndCount();

   // List<Student> findAddressName(String address , String name);
}

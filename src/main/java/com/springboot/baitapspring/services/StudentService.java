package com.springboot.baitapspring.services;

import com.springboot.baitapspring.model.in.StudentRequest;

public interface StudentService {
    void saveStudent(StudentRequest studentRequest);

    void updateStudent(StudentRequest studentRequest);

    void deleteStudent(long id);

    boolean findStudentByID(long id);

 //   List<Student> getAllStudents();

 //   List<StudentAddressResponse> getAddressAndCount();

   // List<Student> findAddressName(String address , String name);
}

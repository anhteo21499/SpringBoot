package com.springboot.baitapspring.services.mapper;

import com.springboot.baitapspring.model.entity.Student;

public class StudentMapper {
    public static Student mapStudent(Student student , Student studentMap){
        student.setAddress(studentMap.getAddress());
        student.setBirthday(studentMap.getBirthday());
        student.setName(studentMap.getName());
        student.setPhone(studentMap.getPhone());
        return student;
    }
}

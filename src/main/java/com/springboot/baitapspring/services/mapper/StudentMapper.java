package com.springboot.baitapspring.services.mapper;

import com.springboot.baitapspring.model.entity.Class;
import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.model.in.StudentRequest;
import com.springboot.baitapspring.model.out.StudentDto;

public class StudentMapper {


    public static StudentDto toStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setAddress(student.getAddress());
        studentDto.setBirthday(student.getBirthday());
        studentDto.setName(student.getName());
        studentDto.setPhone(student.getPhone());
        studentDto.setClazz(student.getClazz());
        return studentDto;
    }

    public static Student toStudentUpdate(Student student, StudentRequest studentRequest) {
        //Student student = new Student();
        //   student.setId(studentRequest.getId());
        student.setAddress(studentRequest.getAddress());
        student.setBirthday(studentRequest.getBirthday());
        student.setName(studentRequest.getName());
        student.setPhone(studentRequest.getPhone());
        return student;
    }

//    public static Student toStudentSave(StudentRequest studentRequest) {
//        Student student = new Student();
//        //  student.setId(studentRequest.getId());
//        student.setAddress(studentRequest.getAddress());
//        student.setBirthday(studentRequest.getBirthday());
//        student.setName(studentRequest.getName());
//        student.setPhone(studentRequest.getPhone());
//        student.setClazz(studentRequest.getClasses());
//        return student;
//    }


    public static Student toStudentEntity(StudentRequest studentIn) {
        Student studentEntity = new Student();
        studentEntity.setName(studentIn.getName());
        studentEntity.setBirthday(studentIn.getBirthday());
        studentEntity.setAddress(studentIn.getAddress());
        studentEntity.setPhone(studentIn.getPhone());
        studentEntity.setClazz(studentIn.getClazz());
        return studentEntity;
    }
//    public static Class toClass(StudentRequest studentRequest){
//        Class classes = new Class();
//        classes.setId(studentRequest.getClasses().getId());
//        return classes;
//    }
}

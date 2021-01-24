package com.springboot.baitapspring.services.impl;

import com.springboot.baitapspring.exception.DuplicateRecordException;
import com.springboot.baitapspring.exception.Exceptions;
import com.springboot.baitapspring.exception.NotFoundException;
import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.model.in.StudentRequest;
import com.springboot.baitapspring.repositories.StudentRepository;
import com.springboot.baitapspring.services.StudentService;
import com.springboot.baitapspring.services.mapper.StudentMapper;
import com.springboot.baitapspring.services.validators.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(StudentRequest studentRequest) {
        StudentRequest studentRequestValidate = StudentValidator.validateObjectSave(studentRequest);
        checkPhoneExist(studentRequest);
        Student student = StudentMapper.toStudentEntity(studentRequestValidate);
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(StudentRequest studentRequest) {
        boolean check = false;
        checkPhoneExist(studentRequest);
        StudentRequest studentValidate = StudentValidator.validateObjectSave(studentRequest);
        Student students = studentRepository.getStudentById(studentRequest.getId());
        if (students == null) {
            throw new Exceptions("no exit student to update ");
        }
        StudentMapper.toStudentUpdate(students, studentRequest);
        studentRepository.save(students);
    }

    @Override
    public void deleteStudent(long id) {
        if (!findStudentByID(id)) {
            throw new NotFoundException("No student found");
        }
        studentRepository.deleteById(id);
    }

    public void checkPhoneExist(StudentRequest studentRequest) {
       boolean check = studentRepository.getStudentByPhone(studentRequest.getPhone()) != null;
       if(check){
           throw new DuplicateRecordException("Phone already exists in the system");
       }
    }

    @Override
    public boolean findStudentByID(long id) {
        return studentRepository.getStudentById(id) == null;
    }

//    @Override
//    public List<StudentAddressResponse> getAddressAndCount() {
//        // đếm địa chỉ
//        return studentRepository.getAllAddressTotal();
//    }
}

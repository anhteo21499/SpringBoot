package com.springboot.baitapspring.services.impl;

import com.springboot.baitapspring.exception.DuplicateRecordException;
import com.springboot.baitapspring.exception.NotFoundException;
import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.model.in.ClassRequest;
import com.springboot.baitapspring.model.in.StudentRequest;
import com.springboot.baitapspring.model.out.StudentAddressResponse;
import com.springboot.baitapspring.model.out.StudentDto;
import com.springboot.baitapspring.repositories.StudentRepository;
import com.springboot.baitapspring.services.StudentService;
import com.springboot.baitapspring.services.mapper.ClassMapper;
import com.springboot.baitapspring.services.mapper.StudentMapper;
import com.springboot.baitapspring.services.validators.ClassValidator;
import com.springboot.baitapspring.services.validators.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(StudentRequest studentRequest) {
        boolean checkClassExists = checkPhoneExist(studentRequest.getName());
        if (!checkClassExists) {
            throw new DuplicateRecordException("Phone name already exists in the system");
        }
        if (checkClassExists) {
            StudentRequest studentRequestValidate = StudentValidator.validateObjectSave(studentRequest);
            studentRepository.save(StudentMapper.toStudentEntity(studentRequestValidate));
        }

    }

    @Override
    public void updateStudent(StudentRequest studentRequest) {
        boolean check = false;
        boolean checkClassExist = checkPhoneExist(studentRequest.getPhone());
        List<Student> studentList = getAllStudents();
        if (checkClassExist) {
            for (Student sv : studentList) {
                if (sv.getId() == studentRequest.getId()) {
                    Student findStudent = studentRepository.findById(studentRequest.getId()).orElse(null);
                    StudentMapper.toStudentUpdate(findStudent, studentRequest);
                    studentRepository.save(findStudent);
                    check = true;
                    break;
                }
            }
        } else {
            throw new DuplicateRecordException("Phone already exists in the system");
        }
        if (!check) {
            throw new NotFoundException("No studnet found");
        }

//        Student student = studentRepository.findById(id).orElse(null);
//        studentRepository.save(StudentMapper.mapStudent(student, studentMap));

    }

    @Override
    public void deleteStudent(long id) {
        boolean check = false;
        List<Student> list = getAllStudents();
        for (Student sv : list) {
            if (sv.getId() == id) {
                Student student = studentRepository.findById(id).orElse(null);
                studentRepository.delete(student);
                check = true;
                break;
            }
        }

        if (!check) {
            throw new NotFoundException("No student found");
        }
//        Student students = studentRepository.findById(id).orElse(null);
//        studentRepository.delete(students);
    }

    public boolean checkPhoneExist(String phone) {
        boolean check = true;
        List<Student> list = getAllStudents();
  for (Student sv : list) {
            if (sv.getPhone().equals(phone)) {
                check = false;
                break;
            }
        }
        return check;
    }

    @Override
    public StudentDto findStudentByID(long id) {
        return StudentMapper.toStudentDto(studentRepository.findById(id).orElse(null));
    }

    @Override// lấy ra tất cả các student trong database
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudent();
    }

//    @Override
//    public List<StudentAddressResponse> getAddressAndCount() {
//        // đếm địa chỉ
//        return studentRepository.getAllAddressTotal();
//    }

//    @Override
//    public List<Student> findAddressName(String address, String name) {
//        return studentRepository.findStudentByAddressAndName(address, name);
//    }

}

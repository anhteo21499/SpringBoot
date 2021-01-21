package com.springboot.baitapspring.services.impl;

import com.springboot.baitapspring.exception.DuplicateRecordException;
import com.springboot.baitapspring.exception.NotFoundException;
import com.springboot.baitapspring.model.entity.Class;
import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.model.respon.StudentAddressResponse;
import com.springboot.baitapspring.repositories.StudentRepository;
import com.springboot.baitapspring.services.StudentService;
import com.springboot.baitapspring.services.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void saveStudent(Student student) {
//        boolean checkClassExists = checkStudent(student.getName());
//        if (!checkClassExists) {
//            throw new DuplicateRecordException("Class name already exists in the system");
//        }
//        if (checkClassExists) {
//            studentRepository.save(student);
//        }
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student studentMap) {
        boolean check = false;
        List<Student> studentList = getAllStudents();
         {
            for (Student sv : studentList) {
                if (sv.getId() == studentMap.getId()) {
                    Student findStudent = studentRepository.findById(studentMap.getId()).orElse(null);
                    StudentMapper.mapStudent(findStudent,studentMap);
                    studentRepository.save(findStudent);
                    check = true;
                    break;
                }
            }
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
                studentRepository.delete(sv);
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

    public boolean checkStudent(String className) {
        boolean check = true;
        List<Student> list = getAllStudents();
        for (Student sv : list) {
            if (sv.getName().equals(className)) {
                check = false;
                break;
            }
        }
        return check;
    }

    @Override
    public List<Student> findStudentByID(long id) {
        return studentRepository.findStudentById(id);
    }
    @Override// lấy ra tất cả các class trong database
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudent();
    }

    @Override
    public List<StudentAddressResponse> getAddressAndCount() {
        // đếm địa chỉ
        return studentRepository.getAllAddressTotal();
    }

}

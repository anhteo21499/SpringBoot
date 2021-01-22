package com.springboot.baitapspring.services.impl;

import com.springboot.baitapspring.exception.DuplicateRecordException;
import com.springboot.baitapspring.exception.NotFoundException;
import com.springboot.baitapspring.model.entity.Class;
import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.model.in.ClassRequest;
import com.springboot.baitapspring.model.out.ClassDto;
import com.springboot.baitapspring.repositories.ClassRepository;
import com.springboot.baitapspring.repositories.StudentRepository;
import com.springboot.baitapspring.services.ClassService;
import com.springboot.baitapspring.services.mapper.ClassMapper;
import com.springboot.baitapspring.services.validators.ClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    //private List<Class> classList = new ArrayList<>();
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveClass(ClassRequest classRequest) {
        boolean checkClassExists = checkClassExit(classRequest.getName());
        if (!checkClassExists) {
            throw new DuplicateRecordException("Class name already exists in the system");
        }
        if (checkClassExists) {
            ClassRequest classRequests = ClassValidator.validateObjectSave(classRequest);
            classRepository.save(ClassMapper.toClassSave(classRequests));
        }
    }

    @Override
    public void updateClass(ClassRequest classRequest) {
        boolean check = false;
        boolean checkClassExist = checkClassExit(classRequest.getName());
        List<Class> list = getAllClasses();
        if (checkClassExist) {
            for (Class clazzs : list) {
                if (clazzs.getId() == classRequest.getId()) {
                    Class findClass = classRepository.findById(classRequest.getId()).orElse(null);
                    ClassMapper.toClassUpdate(findClass,classRequest);
//                    findClass.setName(classRequest.getName());
                    classRepository.save(findClass);
                    check = true;
                    break;
                }
            }
        } else {
            throw new DuplicateRecordException("Class name already exists in the system");
        }
        if (!check) {
            throw new NotFoundException("No class found");
        }
    }

    @Override
    public void deleteClass(long id) {
        boolean check = false;
        List<Class> listClass = getAllClasses();
        for (Class classes : listClass) {
            if (classes.getId() == id) {
                Class clazz = classRepository.findById(id).orElse(null);
                classRepository.delete(clazz);
                check = true;
                break;
            }
        }
        if (!check) {
            throw new NotFoundException("No class found");
        }
    }

    //kiểm tra tên lớp đã tồn tại chưa
    public boolean checkClassExit(String className) {
        boolean check = true;
        List<Class> list = getAllClasses();
        for (Class classes : list) {
            if (classes.getName().equals(className)) {
                check = false;
                break;
            }
        }
        return check;
    }



    @Override //lấy ra class theo id
    public ClassDto findClass(long id) {
        List<Class> list = getAllClasses();
        for (Class classes : list) {
            if (classes.getId() == id) {
                return ClassMapper.toClassDto(classRepository.findById(id).orElse(null));
            }
        }
        throw new NotFoundException("No class found");
    }

    @Override
    public List<Student> findAllStudents(long id) {
        // lấy ra danh sách sinh viên với điều kiện id của class
        List<Student> list = studentRepository.findStudent(id);
        return list;
    }


    @Override// lấy ra tất cả các class trong database
    public List<Class> getAllClasses() {
        return classRepository.getAllClass();
    }




//    @Override
//    public List<Class> findStudentById(long id) {
//       List<Class> list = classRepository.myCustomQuery2(id);
//        return list;
//    }
}

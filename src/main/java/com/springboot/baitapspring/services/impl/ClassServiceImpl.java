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
        ClassRequest classRequests = ClassValidator.validateObjectSave(classRequest);
        checkClassNameExit(classRequest);
        classRepository.save(ClassMapper.toClassSave(classRequests));
    }

    @Override
    public void updateClass(ClassRequest classRequest) {
        Class classes = getClassByID(classRequest.getId());
        if(classes == null){
            throw new NotFoundException("No class found");
        }
        checkClassNameExit(classRequest);
        ClassMapper.toClassUpdate(classes, classRequest);
        classRepository.save(classes);
    }

    @Override
    public void deleteClass(long id) {
        if (getClassByID(id) == null) {
            throw new NotFoundException("No class found");
        }
        classRepository.deleteById(id);
    }

    //kiểm tra tên lớp đã tồn tại chưa
    public void checkClassNameExit(ClassRequest classRequest) {
        boolean checkClassNem = classRepository.getClassByName(classRequest.getName()) != null;
        if (checkClassNem) {
            throw new DuplicateRecordException("Class name already exists in the system");
        }
    }

    public Class getClassByID(long id) {
        return classRepository.getClassById(id) ;
    }

    @Override //lấy ra class theo id
    public ClassDto findClass(long id) {
        Class classes = classRepository.getClassById(id);
        if (classes == null) {
            throw new NotFoundException("No class found");
        }
        return ClassMapper.toClassDto(classes);
    }

}

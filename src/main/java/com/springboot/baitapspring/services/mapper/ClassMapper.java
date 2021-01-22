package com.springboot.baitapspring.services.mapper;

import com.springboot.baitapspring.model.entity.Class;
import com.springboot.baitapspring.model.in.ClassRequest;import com.springboot.baitapspring.model.out.ClassDto;

public class ClassMapper {
    public static ClassDto toClassDto(Class classes){
        ClassDto classDto = new ClassDto();
        classDto.setId(classes.getId());
        classDto.setName(classes.getName());
        return classDto;
    }

    public static Class toClassUpdate(Class classes ,ClassRequest classRequest){
      //  classes = new Class();
        classes.setName(classRequest.getName());
        return classes;
    }

    public static Class toClassSave( ClassRequest classRequest){
        Class classes = new Class();
        classes.setName(classRequest.getName());
        return classes;
    }
}

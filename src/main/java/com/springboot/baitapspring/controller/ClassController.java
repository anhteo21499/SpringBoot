package com.springboot.baitapspring.controller;

import com.springboot.baitapspring.model.entity.Class;
import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Class clazz){
        classService.saveClass(clazz);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable long id){
        classService.deleteClass(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateClass(@RequestBody Class clazz){
       classService.updateClass(clazz);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}") //lấy class theo id
    public ResponseEntity<?> findClazz(@PathVariable long id){
        Class clazzs = classService.findClass(id);
        return ResponseEntity.ok(clazzs);
    }

    @GetMapping("/findallstudent/{id}")
    public ResponseEntity<?> findAllStudent(@PathVariable long id){
        //lấy danh sách học sinh theo sinh viên
        List<Student> list = classService.findAllStudents(id);
        return ResponseEntity.ok(list);
     }

}

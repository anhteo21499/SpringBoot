package com.springboot.baitapspring.controller;

import com.springboot.baitapspring.model.entity.Class;
import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.model.in.ClassRequest;
import com.springboot.baitapspring.model.out.ClassDto;
import com.springboot.baitapspring.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ClassService classService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClassRequest classRequest){
        classService.saveClass(classRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable long id){
        classService.deleteClass(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> updateClass(@RequestBody ClassRequest classRequest){
       classService.updateClass(classRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}") //lấy class theo id
    public ResponseEntity<?> findClazz(@PathVariable long id){
        ClassDto classDto = classService.findClass(id);
        return ResponseEntity.ok(classDto);
    }

    @GetMapping("/students-id/{id}")
    public ResponseEntity<?> findAllStudent(@PathVariable long id){
        //lấy danh sách học sinh theo sinh viên
        List<Student> list = classService.findAllStudents(id);
        return ResponseEntity.ok(list);
     }

}

package com.springboot.baitapspring.controller;

import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.model.respon.StudentAddressResponse;
import com.springboot.baitapspring.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudenController {
    @Autowired
    private StudentService studentService;

//    @GetMapping("/{id}")
//    public ResponseEntity<?> findById(@PathVariable long id){
//        List<Student> lists = studentService.findAllStudent(id);
//        return ResponseEntity.ok(lists);
//    }
    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> saveStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
     @PutMapping("/update")
     public ResponseEntity<?> updateStudent(@RequestBody Student student ){
         studentService.updateStudent(student);
         return ResponseEntity.ok().build();
     }

     @GetMapping("/find/{id}")
     public ResponseEntity<?> findStudentByID(@PathVariable long id){
        List<Student> list = studentService.findStudentByID(id);
         return ResponseEntity.ok(list);
     }

     @GetMapping("/getaddress")
    public ResponseEntity<List<StudentAddressResponse>> getAddressTotal(){
        return ResponseEntity.ok(studentService.getAddressAndCount());
     }
}

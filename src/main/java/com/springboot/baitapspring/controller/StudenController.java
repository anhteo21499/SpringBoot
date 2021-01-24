package com.springboot.baitapspring.controller;

import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.model.in.StudentRequest;
import com.springboot.baitapspring.model.out.StudentAddressResponse;
import com.springboot.baitapspring.model.out.StudentDto;
import com.springboot.baitapspring.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudenController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequest studentRequest){
        studentService.saveStudent(studentRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
     @PutMapping
     public ResponseEntity<?> updateStudent(@RequestBody StudentRequest studentRequest ){
         studentService.updateStudent(studentRequest);
         return ResponseEntity.ok().build();
     }

//     @GetMapping("/{id}")
//     public ResponseEntity<?> findStudentByID(@PathVariable long id){
//        StudentDto studentDto = studentService.findStudentByID(id);
//         return ResponseEntity.ok(studentDto);
//     }

//     @GetMapping("/readaddressandtotal")
//    public ResponseEntity<List<StudentAddressResponse>> getAddressTotal(){
//        return ResponseEntity.ok(studentService.getAddressAndCount());
//     }
//
//     @GetMapping("/getaddressandname")
//     public ResponseEntity<?> findAddressName(@PathVariable(value = "address", required = false) String address,
//                                  @PathVariable(value = "name",required = false) String name) {
//         List<Student> list = studentService.findAddressName(address,name);
//         return ResponseEntity.ok(list);
 //    }
}

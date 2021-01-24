package com.springboot.baitapspring.repositories;

import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.model.out.StudentAddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select s.* from student s inner join class c on s.student_id = c.id where c.id = ?1", nativeQuery = true)
    List<Student> findStudent(long id);

    @Query(value = "select s from Student s where s.id = ?1 ")
    List<Student> findStudentById(long id);

//    @Query("select s from Student s")
//    List<Student> getAllStudent();

    Student getStudentByPhone(String phone);

    Student getStudentById(long id);

//    @Query(value = "select new com.springboot.baitapspring.model.out.StudentAddressResponse( s.address , count(s.id) ) from Student s group by s.address")
//    List<StudentAddressResponse> getAllAddressTotal();

    List<Student> findStudentByAddressAndName(String address, String name);
//        @Query(value = "select * from student s  where s.student_id = ?1",nativeQuery = true)
//    List<Student> findStudent(long id);
}

package com.springboot.baitapspring.repositories;

import com.springboot.baitapspring.model.entity.Class;
import com.springboot.baitapspring.model.entity.Student;
import com.springboot.baitapspring.model.respon.StudentAddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select s.* from student s inner join class c on s.student_id = c.id where c.id = ?1", nativeQuery = true)
    List<Student> findStudent(long id);

    @Query(value = "select s from Student s where s.id = ?1 ")
    List<Student> findStudentById(long id);

    @Query("select s from Student s")
    List<Student> getAllStudent();

    @Query(value = "select new com.springboot.baitapspring.model.respon.StudentAddressResponse( s.address , count(s.id) ) from Student s group by s.address")
    List<StudentAddressResponse> getAllAddressTotal();
//        @Query(value = "select * from student s  where s.student_id = ?1",nativeQuery = true)
//    List<Student> findStudent(long id);
}

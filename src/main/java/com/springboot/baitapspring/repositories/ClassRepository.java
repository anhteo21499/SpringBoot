package com.springboot.baitapspring.repositories;

import com.springboot.baitapspring.model.entity.Class;
import com.springboot.baitapspring.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    @Query("select c from Class c")
    List<Class> getAllClass();

//    @Query(value = "select * from class where id=?1", nativeQuery = true)
//    List<Class> myCustomQuery2(long id);


//    @Query(value = "select * from product where id=?1", nativeQuery = true)
//    Student myCustomQuery2(long id);
}

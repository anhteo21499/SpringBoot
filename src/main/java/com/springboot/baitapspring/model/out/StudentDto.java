package com.springboot.baitapspring.model.out;

import com.springboot.baitapspring.model.entity.Class;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private long id;

    private String name;

    private LocalDate birthday;

    private String address;

    private String phone;
    private Class clazz;


}

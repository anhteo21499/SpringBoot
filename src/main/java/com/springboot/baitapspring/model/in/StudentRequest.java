package com.springboot.baitapspring.model.in;


import com.springboot.baitapspring.model.entity.Class;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    private long id;

    private String name;

    private LocalDate birthday;

    private String address;

    private String phone;

    private Class clazz;


}

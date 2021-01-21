package com.springboot.baitapspring.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {
    @Id   //column @tự động map với cột trên databases , nullable =false không co phép null.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private LocalDate birthday;
    @Column
    private String address;
    @Column
    private String phone;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Class clazz;

}

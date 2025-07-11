package com.springjap.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    private int studetnId;
    private String studentName;

    @OneToOne
    private Laptop laptop;
}



package com.springjap.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "laptops")
public class Laptop {
    
    @Id
    private int laptopId;
    private String modelNumber;

    @OneToOne
    private Student student;
}

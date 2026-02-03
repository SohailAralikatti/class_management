package com.example.class_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.class_management.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {

}

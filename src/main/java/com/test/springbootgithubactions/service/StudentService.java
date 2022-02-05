package com.test.springbootgithubactions.service;

import com.test.springbootgithubactions.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
     Student save(Student student);
     List<Student> findAll();
     Optional<Student> findById(Integer id);
     Student update(Student student);
     boolean delete(Integer id);
}

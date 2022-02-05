package com.test.springbootgithubactions.service;

import com.test.springbootgithubactions.model.Student;
import com.test.springbootgithubactions.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public boolean delete(Integer id) {
        return findById(id).isPresent() ? true : false;
    }
}

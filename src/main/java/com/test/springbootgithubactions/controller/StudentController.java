package com.test.springbootgithubactions.controller;

import com.test.springbootgithubactions.model.Student;
import com.test.springbootgithubactions.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/students")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @PostMapping("/")
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Integer id){
        return studentService.findById(id).map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student,@PathVariable int id){
        return studentService.findById(id).map(savedStudent->{
            savedStudent.setName(student.getName());
            savedStudent.setSubject(student.getSubject());
            var updateStudent = studentService.update(savedStudent);
            return new ResponseEntity<>(updateStudent, HttpStatus.OK);
        }).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        if(studentService.delete(id)){
            return new ResponseEntity<>("Record Has been successfully deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Record Not Found", HttpStatus.NOT_FOUND);
        }
    }

}

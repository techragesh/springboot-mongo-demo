package com.techragesh.sprinbootmongodemo.controller;

import com.techragesh.sprinbootmongodemo.model.Students;
import com.techragesh.sprinbootmongodemo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;


    @GetMapping("/all")
    public List<Students> getAllStudents(){
        return studentsService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Students> getStudentById(@PathVariable String id) {
        return studentsService.getStudentById(Long.parseLong(id));
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteStudentById(@PathVariable String id){
        return studentsService.deleteStudentById(Long.parseLong(id));
    }

    @PostMapping("/create")
    public Students createStudent(@RequestBody Students students){
        return studentsService.saveStudent(students);
    }
}

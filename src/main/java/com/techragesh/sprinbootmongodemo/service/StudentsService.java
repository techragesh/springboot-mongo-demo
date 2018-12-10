package com.techragesh.sprinbootmongodemo.service;

import com.techragesh.sprinbootmongodemo.model.Students;

import java.util.List;
import java.util.Optional;

public interface StudentsService {

    Optional<Students> getStudentById(Long studentId);

    Students saveStudent(Students students);

    List<Students> getAllStudents();

    boolean deleteStudentById(Long studentId);
}

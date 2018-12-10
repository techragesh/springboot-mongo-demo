package com.techragesh.sprinbootmongodemo.service.impl;

import com.techragesh.sprinbootmongodemo.model.Students;
import com.techragesh.sprinbootmongodemo.repository.StudentsDao;
import com.techragesh.sprinbootmongodemo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsDao studentsDao;


    @Override
    public Optional<Students> getStudentById(Long studentId) {
        return studentsDao.findById(studentId);
    }

    @Override
    public Students saveStudent(Students students) {
        return studentsDao.save(students);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentsDao.findAll();
    }

    @Override
    public boolean deleteStudentById(Long studentId) {
        studentsDao.deleteById(studentId);
        return true;
    }
}

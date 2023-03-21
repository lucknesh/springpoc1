package com.luck.spring.service;

import com.luck.spring.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IStudentService {
    public void save(StudentEntity studentEntity) ;

    StudentEntity getStudentById(Long id);

    List<StudentEntity> getAllStudent();
}

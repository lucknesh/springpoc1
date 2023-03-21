package com.luck.spring.controller;

import com.luck.spring.entity.StudentEntity;
import com.luck.spring.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {

    @Autowired
    private IStudentService iStudentService;


    @PostMapping("/saveStudent")
    public ResponseEntity<?> saveEmployee(@RequestBody StudentEntity studentEntity) {
        iStudentService.save(studentEntity);
         return new ResponseEntity<>(iStudentService.getStudentById(studentEntity.getId()), HttpStatus.CREATED);

    }


    @GetMapping("/students")
    public ResponseEntity<?> getAllStudent() {
        return new ResponseEntity<>(iStudentService. getAllStudent(), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> saveEmployee(@PathVariable Long id) {

        return new ResponseEntity<>(iStudentService.getStudentById(id),HttpStatus.OK);

    }
}

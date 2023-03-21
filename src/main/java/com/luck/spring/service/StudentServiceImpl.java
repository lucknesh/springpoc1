package com.luck.spring.service;

import com.luck.spring.entity.StudentEntity;
import com.luck.spring.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepo studentRepo;

    public void save(StudentEntity studentEntity) {
        studentRepo.save(studentEntity);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public StudentEntity getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    public ResponseEntity<StudentEntity> getStudent(Long id) {
        return new ResponseEntity(studentRepo.findById(id).get(), HttpStatus.OK);
    }

    /**
     * @return
     */
    @Override
    public List<StudentEntity> getAllStudent() {
        Collection<StudentEntity> studentsColls = studentRepo.findAll();
        List<StudentEntity> repose = new ArrayList<>();
        for (StudentEntity student : studentsColls) {
            student.add(linkTo(methodOn(StudentServiceImpl.class).getStudent(student.getId())).withSelfRel());
            repose.add(student);
        }
        return repose;
    }

}

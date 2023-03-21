package com.luck.spring.repo;

import com.luck.spring.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface StudentRepo  extends JpaRepository<StudentEntity, Long> {
}

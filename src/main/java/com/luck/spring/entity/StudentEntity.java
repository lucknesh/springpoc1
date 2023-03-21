package com.luck.spring.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "Student")
public class StudentEntity extends RepresentationModel<StudentEntity> {
    @Id
    @GeneratedValue
    private Long id;
    private String studentName;
    private String section;
    private String standard;
    private double totalMark;

    @JsonCreator
    public StudentEntity(@JsonProperty("id") Long id, @JsonProperty("studentName") String studentName, @JsonProperty("section") String section,
                         @JsonProperty("standard") String standard, @JsonProperty("totalMark") double totalMark) {
        this.id = id;
        this.studentName = studentName;
        this.section = section;
        this.standard = standard;
        this.totalMark = totalMark;

    }
}

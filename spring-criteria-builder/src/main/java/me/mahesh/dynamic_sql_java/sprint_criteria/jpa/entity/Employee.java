package me.mahesh.dynamic_sql_java.sprint_criteria.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Employee {
    @Id @Column(name = "emp_no")
    int id;
    String name;
    char gender;
    byte age;
    LocalDate hireDate;
}

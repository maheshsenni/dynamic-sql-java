package me.mahesh.dynamic_sql_java.sprint_criteria.jpa.repository;

import me.mahesh.dynamic_sql_java.sprint_criteria.jpa.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findAll();
    Employee findById(int id);
}

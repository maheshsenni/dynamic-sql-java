package me.mahesh.dynamic_sql_java.sprint_criteria;

import lombok.extern.slf4j.Slf4j;
import me.mahesh.dynamic_sql_java.sprint_criteria.jpa.entity.Employee;
import me.mahesh.dynamic_sql_java.sprint_criteria.jpa.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@Slf4j
public class DynamicSqlSpringApp {

    public static void main(String[] args) {
        SpringApplication.run(DynamicSqlSpringApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository repository, EntityManager em) {
        return (args) -> {
            List<Employee> employees = repository.findAll();
            log.info("Found following employees:");
            log.info("--------------------------");
            printEmployees(employees);
            log.info("--------------------------");

            // Criteria builder
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
            Root<Employee> employeeRoot = cq.from(Employee.class);
            Predicate genderPredicate = cb.equal(employeeRoot.get("gender"), 'F');
            Predicate agePredicate = cb.greaterThan(employeeRoot.get("age"), 30);
            Predicate hireDatePredicate = cb.lessThan(employeeRoot.get("hireDate"),
                    LocalDate.of(2020, 1, 1));
            cq.where(genderPredicate, agePredicate, hireDatePredicate);
            TypedQuery<Employee> query = em.createQuery(cq);
            List<Employee> selectedEmployees = query.getResultList();
            log.info("Employees matching criteria:");
            log.info("--------------------------");
            printEmployees(selectedEmployees);
            log.info("--------------------------");
        };
    }

    private void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            log.info("Emp.no: {} Name: {} Age: {} Hire date: {}",
                    employee.getId(), employee.getName(), employee.getAge(), employee.getHireDate());
        }
    }
}

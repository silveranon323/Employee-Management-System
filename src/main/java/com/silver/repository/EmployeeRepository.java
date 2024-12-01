package com.silver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.silver.entity.Employee;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // JPQL Query to find employees with salary greater than or equal to 10000
    @Query("SELECT e FROM Employee e WHERE e.salary >= 10000")
    List<Employee> findEmployeesWithSalaryGreaterThanEqual10000();
}

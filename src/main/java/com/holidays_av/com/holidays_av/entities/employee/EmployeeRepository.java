package com.holidays_av.com.holidays_av.entities.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByName(String name);
}

package com.holidays_av.com.holidays_av.department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByName(String name);
}

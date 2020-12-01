package com.holidays_av.com.holidays_av.Company;

import com.holidays_av.com.holidays_av.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company findByName(String name);

}

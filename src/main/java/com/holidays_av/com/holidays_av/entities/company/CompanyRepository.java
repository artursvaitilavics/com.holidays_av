package com.holidays_av.com.holidays_av.entities.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company findByName(String name);


}

package com.holidays_av.repository;

import com.holidays_av.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {

}

package com.holidays_av.service;

import com.holidays_av.model.Holiday;
import com.holidays_av.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HolidayService {

    private final HolidayRepository holidayRepository;

    @Autowired
    public HolidayService(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    public Holiday save(Holiday holiday) {
        return holidayRepository.save(holiday);
    }
}

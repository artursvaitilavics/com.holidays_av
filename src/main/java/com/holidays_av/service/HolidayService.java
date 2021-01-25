package com.holidays_av.service;

import com.holidays_av.exception.ExceptionService;
import com.holidays_av.exception.utils.ExceptionCode;
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

    public Holiday findById(Long id) {
        return holidayRepository.findById(id)
                .orElseThrow(
                        () -> new ExceptionService(
                                "Holiday with id: " + id + " doesn't exist...",
                                ExceptionCode.CODE_3.name()));
    }
}

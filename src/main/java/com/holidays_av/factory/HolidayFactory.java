package com.holidays_av.factory;

import com.holidays_av.model.Employee;
import com.holidays_av.model.Holiday;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class HolidayFactory {

    public Holiday createHoliday(LocalDate startTime, LocalDate endTime, Employee employee){
        Holiday holiday = new Holiday();
        holiday.setStartDate(startTime);
        holiday.setEndDate(endTime);
        holiday.setEmployee(employee);
        return holiday;
    }
}

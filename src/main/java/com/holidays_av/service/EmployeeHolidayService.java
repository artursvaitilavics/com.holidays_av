package com.holidays_av.service;

import com.holidays_av.model.Employee;
import com.holidays_av.model.Holiday;
import com.holidays_av.service.utils.CountDays;
import com.holidays_av.validator.HolidayValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeeHolidayService {

    private final EmployeeService employeeService;
    private final HolidayService holidayService;
    private final HolidayValidator holidayValidator;

    @Autowired
    public EmployeeHolidayService(EmployeeService employeeService,
                                  HolidayService holidayService,
                                  HolidayValidator holidayValidator) {
        this.employeeService = employeeService;
        this.holidayService = holidayService;
        this.holidayValidator = holidayValidator;
    }

    public Integer saveHoliday(Long employeeId, LocalDate startTime, LocalDate endTime) {
        if(holidayValidator.isValid(employeeId, startTime, endTime)){


            Employee employee = employeeService.findById(employeeId);

            CountDays countDays = new CountDays();
            Integer days = countDays.days(startTime, endTime);
            Integer newDays = employee.getDayLeft() - days;

            employee.setDayLeft(newDays);
            employeeService.update(employee);

            Holiday holiday = new Holiday();
            holiday.setStartDate(startTime);
            holiday.setEndDate(endTime);
            holiday.setEmployee(employee);

            holidayService.save(holiday);
            return days;
        }


        return 0;
    }
}

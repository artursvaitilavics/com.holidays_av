package com.holidays_av.service;

import com.holidays_av.model.Employee;
import com.holidays_av.model.Holiday;
import com.holidays_av.service.utils.CountDays;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeeHolidayService {

    private final EmployeeService employeeService;
    private final HolidayService holidayService;

    public EmployeeHolidayService(EmployeeService employeeService, HolidayService holidayService) {
        this.employeeService = employeeService;
        this.holidayService = holidayService;
    }

    public Integer saveHoliday(Long employeeId, LocalDate startTime, LocalDate endTime) {
        Employee employee = employeeService.findById(employeeId);

        CountDays countDays = new CountDays();
        Integer days = countDays.days(startTime, endTime);

        employee.setDayLeft(employee.getDayLeft() - days);

        Holiday holiday = new Holiday();
        holiday.setStartDate(startTime);
        holiday.setEndDate(endTime);

        Holiday savedHoliday = holidayService.save(holiday);

        employee.getHoliday().add(savedHoliday);
        employeeService.save(employee);
        return days;
    }
}

package com.holidays_av.service;

import com.holidays_av.factory.HolidayFactory;
import com.holidays_av.model.Employee;
import com.holidays_av.model.Holiday;
import com.holidays_av.service.utils.CountDays;
import com.holidays_av.validator.HolidayValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;

@Service
public class EmployeeHolidayService {

    private final EmployeeService employeeService;
    private final HolidayService holidayService;
    private final HolidayValidator holidayValidator;
    private final CountDays countDays;
    private final HolidayFactory holidayFactory;

    @Autowired
    public EmployeeHolidayService(EmployeeService employeeService,
                                  HolidayService holidayService,
                                  HolidayValidator holidayValidator,
                                  CountDays countDays,
                                  HolidayFactory holidayFactory) {
        this.employeeService = employeeService;
        this.holidayService = holidayService;
        this.holidayValidator = holidayValidator;
        this.countDays = countDays;
        this.holidayFactory = holidayFactory;
    }

    public Integer saveHoliday(Long employeeId, LocalDate startTime, LocalDate endTime) throws IOException, URISyntaxException {
        if (holidayValidator.isValid(employeeId, startTime, endTime)) {


            Employee employee = employeeService.findById(employeeId);

            Integer days = countDays.days(startTime, endTime);
            Integer newDays = employee.getDayLeft() - days;

            employee.setDayLeft(newDays);
            employeeService.update(employee);

            Holiday holiday = holidayFactory.createHoliday(startTime, endTime, employee);


            holidayService.save(holiday);
            return days;
        }


        return 0;
    }
}

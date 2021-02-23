package com.holidays_av.validator;

import com.holidays_av.model.Employee;
import com.holidays_av.model.status.EmployeeStatus;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

    public boolean isEmployee(Employee employee) {
        if (employee.getStatus() != EmployeeStatus.EX_EMPLOYEE) {
            return true;
        } else {
            return false;
        }
    }
}

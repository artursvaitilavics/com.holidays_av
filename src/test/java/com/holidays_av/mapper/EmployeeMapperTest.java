package com.holidays_av.mapper;

import com.holidays_av.dto.EmployeeDto;
import com.holidays_av.model.Employee;
import com.holidays_av.model.status.EmployeeStatus;
import org.junit.Test;

import static org.aspectj.runtime.internal.Conversions.longValue;
import static org.junit.Assert.assertEquals;

public class EmployeeMapperTest {

    private EmployeeMapper employeeMapper = new EmployeeMapper();


    @Test
    public void toDto() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Bilbo");
        employee.setLastName("Baggins");
        employee.setEmail("Biblo.Baggins@middle-earth.com");
        employee.setDayLeft(25);
        employee.setStatus(EmployeeStatus.EMPLOYEE);

        EmployeeDto employeeDto = employeeMapper.toDto(employee);

        assertEquals(longValue(1), longValue(employeeDto.getId()));
        assertEquals("Bilbo", employeeDto.getName());
        assertEquals("Baggins", employeeDto.getLastName());
        assertEquals("Biblo.Baggins@middle-earth.com", employeeDto.getEmail());
        assertEquals("EMPLOYEE", employeeDto.getStatus());

    }

    @Test
    public void fromDto() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Frodo");
        employeeDto.setLastName("Baggins");
        employeeDto.setEmail("frodo.baggins@midle-earth.com");
        employeeDto.setStatus(EmployeeStatus.EMPLOYEE.name());

        Employee employee = employeeMapper.fromDto(employeeDto);

        assertEquals("Frodo", employee.getName());
        assertEquals("Baggins", employee.getLastName());
        assertEquals("frodo.baggins@midle-earth.com", employee.getEmail());
        assertEquals("EMPLOYEE", employee.getStatus().name());

    }
}
package com.holidays_av.service;

import com.holidays_av.model.Employee;
import com.holidays_av.model.status.EmployeeStatus;
import com.holidays_av.repository.EmployeeRepository;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.aspectj.runtime.internal.Conversions.longValue;
import static org.junit.Assert.assertEquals;

public class EmployeeServiceTest {

    public EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);

    public EmployeeService employeeService = new EmployeeService(employeeRepository);


    @Test
    public void save() {
        Employee employee = createEmployee(1L, "Bilbo", "Baggins");
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Employee savedEmployee = employeeService.save(employee);
        assertEquals(1L, longValue(savedEmployee.getId()));
        assertEquals("Bilbo", savedEmployee.getName());
        assertEquals("Baggins", savedEmployee.getLastName());
        assertEquals("Bilbo.Baggins@middle-earth.com", savedEmployee.getEmail());


    }

    @Test
    public void findById() {

        Employee employee001 = (createEmployee(1L, "Bilbo", "Baggins"));
        Employee employee002 = (createEmployee(2L, "Frodo", "Baggins"));
        Employee employee003 = (createEmployee(3L, "Pippin", "Took"));
        Employee employee004 = (createEmployee(4L, "Meriadoc", "Brandybuck"));

        Mockito.when(employeeRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(employee001));

        Employee employeeByID0001 = employeeService.findById(1L);


        assertEquals(1L, longValue(employeeByID0001.getId()));
        assertEquals("Bilbo", employeeByID0001.getName());
        assertEquals("Baggins", employeeByID0001.getLastName());
        assertEquals("Bilbo.Baggins@middle-earth.com", employeeByID0001.getEmail());

        Mockito.when(employeeRepository.findById(2L)).thenReturn(java.util.Optional.ofNullable(employee002));

        Employee employeeByID0002 = employeeService.findById(2L);

        assertEquals(2L, longValue(employeeByID0002.getId()));
        assertEquals("Frodo", employeeByID0002.getName());
        assertEquals("Baggins", employeeByID0002.getLastName());
        assertEquals("Frodo.Baggins@middle-earth.com", employeeByID0002.getEmail());

    }

    @Test
    public void findAll() {

        Employee employee001 = (createEmployee(1L, "Bilbo", "Baggins"));
        Employee employee002 = (createEmployee(2L, "Frodo", "Baggins"));
        Employee employee003 = (createEmployee(3L, "Pippin", "Took"));
        Employee employee004 = (createEmployee(4L, "Meriadoc", "Brandybuck"));

        List<Employee> employees = new ArrayList<>();

        employees.add(employee001);
        employees.add(employee002);
        employees.add(employee003);
        employees.add(employee004);

        Mockito.when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> employeeList = employeeService.findAll();

        assertEquals(4, employeeList.size());

        String resultName001 = "";
        String resultName002 = "";
        String resultName003 = "";
        String resultName004 = "";

        for (Employee employee : employeeList) {
            if (employee.getName().equals("Bilbo")) {
                resultName001 = employee.getName();
            }
            if (employee.getName().equals("Frodo")) {
                resultName002 = employee.getName();
            }
            if (employee.getName().equals("Pippin")) {
                resultName003 = employee.getName();
            }
            if (employee.getName().equals("Meriadoc")) {
                resultName004 = employee.getName();
            }
        }

        assertEquals("Bilbo", resultName001);
        assertEquals("Frodo", resultName002);
        assertEquals("Pippin", resultName003);
        assertEquals("Meriadoc", resultName004);
    }

    @Test
    public void update() {
        Employee employee = (createEmployee(1L, "Bilbo", "Baggins"));

        Mockito.when(employeeRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(employee));


        Employee employeeUpdateData = new Employee();
        employeeUpdateData.setName("Frodo");
        employeeUpdateData.setLastName("Baggins");

        Mockito.when(employeeRepository.save(employeeUpdateData)).thenReturn(employeeUpdateData);

        Employee updatedEmployee = employeeService.update(employeeUpdateData, 1L);

        assertEquals(1L, longValue(updatedEmployee.getId()));
        assertEquals("Frodo", updatedEmployee.getName());
    }

    @Test
    public void delete() {
        Employee employee = (createEmployee(1L, "Bilbo", "Baggins"));
        employee.setStatus(EmployeeStatus.EMPLOYEE);

        Mockito.when(employeeRepository.findById(1L)).thenReturn(java.util.Optional.of(employee));

        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

        Employee deletedEmployee = employeeService.delete(1L);

        assertEquals("Bilbo", deletedEmployee.getName());
        assertEquals("Baggins", deletedEmployee.getLastName());

        assertEquals(EmployeeStatus.EX_EMPLOYEE, deletedEmployee.getStatus());

    }



    public Employee createEmployee(Long id, String name, String lastName) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setEmail(name + "." + lastName + "@middle-earth.com");
        return employee;
    }
}
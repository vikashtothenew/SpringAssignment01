package com.assignment.restapi.service;

import com.assignment.restapi.Employee.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Component
public class EmployeeDAOService {
    private static List<Employee> employees = new ArrayList<>();
    private static int employeeCount=0;

    static {
        employees.add(new Employee(++employeeCount,"Vikash",22));
        employees.add(new Employee(++employeeCount,"Prakash",21));
    }

    public List<Employee> findAllEmployee(){
        return employees;
    }

    public Employee findOne(Integer id){
        Predicate<? super Employee> predicate = employees -> employees.getId().equals(id);
        return employees.stream().filter(predicate).findFirst().orElse(null);
    }

    public void updateEmployeeDetails( Employee updateEmployee,Employee employeeDetails){
        updateEmployee.setName(employeeDetails.getName());
        updateEmployee.setAge(employeeDetails.getAge());
        save(updateEmployee);
    }

    public void deleteById(Integer id){
        Predicate<? super Employee> predicate = employees -> employees.getId().equals(id);
        employees.removeIf(predicate);
    }

public Employee save(Employee employee){
        employee.setId(++employeeCount);
        employees.add(employee);
        return  employee;
}

}

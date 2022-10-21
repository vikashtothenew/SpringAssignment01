package com.assignment.restapi.controller;

import com.assignment.restapi.Employee.Employee;
import com.assignment.restapi.service.EmployeeDAOService;
import com.assignment.restapi.Employee.EmployeeNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeResources {
    private EmployeeDAOService service;

    public EmployeeResources(EmployeeDAOService service) {
        this.service = service;
    }
    //GET /employees
    @GetMapping("/employees")
    public List<Employee> retrieveAllEmployee(){
        return service.findAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee retrieveEmployee(@PathVariable Integer id){
        Employee employee = service.findOne(id);
        if (employee==null)
            throw new EmployeeNotFoundException("Employee ID is not Present "+id);
        return employee;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
        service.save((employee));
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        Employee updateEmployee = service.findOne(id);

         service.updateEmployeeDetails(updateEmployee, employee);
//
//        updateEmployee.setName(employee.getName());
//        updateEmployee.setAge(employee.getAge());
//        service.save(updateEmployee);
    }


    @DeleteMapping("employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        service.deleteById(id);

    }



}



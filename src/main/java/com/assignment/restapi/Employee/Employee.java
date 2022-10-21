package com.assignment.restapi.Employee;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class Employee {
    private Integer id;
    @Size(min = 3, max = 30, message = "Employee name must be between 3 and 30 characters")
    private String name;
    private Integer age;

    public Employee(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

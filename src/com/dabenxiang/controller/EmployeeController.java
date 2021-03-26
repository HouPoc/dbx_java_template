package com.dabenxiang.controller;

import com.dabenxiang.entity.Employee;
import com.dabenxiang.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public List<Employee> getEmployees() {
        log.info("EmployeeController.getEmployees");
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
}

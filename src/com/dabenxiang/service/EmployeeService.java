package com.dabenxiang.service;

import com.dabenxiang.entity.Employee;
import com.dabenxiang.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public  void setEmployeeRepository(EmployeeRepository eMployeeRepository) {
        this.repository = eMployeeRepository;
    }

    public Employee getEmployeeById(long employeeId) {
        Optional<Employee> employeeOptional= repository.findById(employeeId);
        return employeeOptional.orElse(null);
    }
    public List<Employee>  getEmployees() {
        log.info("EmployeeService.getEmployees");
        return (List<Employee>) repository.findAll();
    }


    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }
}

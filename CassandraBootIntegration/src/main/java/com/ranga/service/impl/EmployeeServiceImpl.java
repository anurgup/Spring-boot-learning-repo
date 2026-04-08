package com.ranga.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranga.dao.EmployeeDAO;
import com.ranga.entity.Employee;
import com.ranga.service.EmployeeService;

/**
 * Service Impl class for Employee to perform CRUD operation.
 * @author Ranga Reddy
 * @version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl() {
        super();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDAO.createEmployee(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee patchEmployee(int id, Map<String, Object> updates) {
        Employee existing = employeeDAO.getEmployee(id);
        if (existing == null) {
            return null;
        }
        if (updates.containsKey("name")) {
            existing.setName((String) updates.get("name"));
        }
        if (updates.containsKey("age")) {
            existing.setAge((Integer) updates.get("age"));
        }
        if (updates.containsKey("salary")) {
            Object salaryObj = updates.get("salary");
            if (salaryObj instanceof Number) {
                existing.setSalary(((Number) salaryObj).floatValue());
            }
        }
        return employeeDAO.updateEmployee(existing);
    }
}

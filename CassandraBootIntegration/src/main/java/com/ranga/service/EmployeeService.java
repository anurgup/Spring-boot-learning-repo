package com.ranga.service;

import java.util.List;
import java.util.Map;

import com.ranga.entity.Employee;

/**
 * Service interface for Employee to perform CRUD operation.
 * @author Ranga Reddy
 * @version 1.0
 */
public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public Employee getEmployee(int id);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(int id);
    public List<Employee> getAllEmployees();
    public Employee patchEmployee(int id, Map<String, Object> updates);
}

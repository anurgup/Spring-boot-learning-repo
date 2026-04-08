package com.ranga.service;

/**
 * Created by anurag on 05/03/19.
 */
import java.util.List;
import java.util.Map;

import com.ranga.entity.Employee;

/**
 * Service interface for Employee to perform CRUD operation.
 * @author Ranga Reddy
 * @version 1.0
 */
public interface EmployeeService {
    /**
     * Used to Create the Employee Information
     * @param employee
     * @return {@link Employee}
     */
    public Employee createEmployee(Employee employee);

    /**
     * Getting the Employee Information using Id
     * @param id
     * @return {@link Employee}
     */
    public Employee getEmployee(int id);

    /**
     * Used to Update the Employee Information
     * @param employee
     * @return {@link Employee}
     */
    public Employee updateEmployee(Employee employee);

    /**
     * Deleting the Employee Information using Id (soft delete)
     * @param id
     */
    public void deleteEmployee(int id);

    /**
     * Getting the All Employees information (only active)
     * @return
     */
    public List<Employee> getAllEmployees();

    /**
     * Partially update Employee information
     * @param id
     * @param updates
     * @return {@link Employee}
     */
    public Employee patchEmployee(int id, Map<String, Object> updates);
}

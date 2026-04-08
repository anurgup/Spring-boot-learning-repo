package com.ranga.dao.impl;

/**
 * Created by anurag on 05/03/19.
 */
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ranga.dao.EmployeeDAO;
import com.ranga.entity.Employee;
import com.ranga.util.MyCassandraTemplate;

/**
 * DAOImpl class for Employee to perform CRUD operation.
 * @author Ranga Reddy
 * @version 1.0
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private MyCassandraTemplate myCassandraTemplate;

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setIsActive(1);
        return myCassandraTemplate.create(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = myCassandraTemplate.findById(id, Employee.class);
        if (employee != null && employee.getIsActive() == 0) {
            return null;
        }
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return myCassandraTemplate.update(employee, Employee.class);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = myCassandraTemplate.findById(id, Employee.class);
        if (employee != null) {
            employee.setIsActive(0);
            myCassandraTemplate.update(employee, Employee.class);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = myCassandraTemplate.findAll(Employee.class);
        return allEmployees.stream()
                .filter(emp -> emp.getIsActive() == 1)
                .collect(Collectors.toList());
    }
}

package com.ranga.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ranga.entity.Employee;
import com.ranga.service.EmployeeService;

/**
 * @author Ranga Reddy
 * @version 1.0
 * @since Aug 20, 2015
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController() {
        System.out.println("EmployeeController()");
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    ResponseEntity<?> create(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> error = new HashMap<>();
            String errorMessage = bindingResult.getFieldError("name") != null
                    ? bindingResult.getFieldError("name").getDefaultMessage()
                    : "Validation error";
            error.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        if (employee.getName() != null) {
            String normalizedName = employee.getName().toLowerCase();
            if (!normalizedName.matches("^[a-z\\s]+$")) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "Name must contain only alphabets and spaces, no numbers or special characters allowed");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            }
        }
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    List<Employee> findAll() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    Employee findById(@PathVariable("id") int id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    Employee update(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PATCH)
    ResponseEntity<?> patch(@PathVariable("id") int id, @RequestBody Map<String, Object> updates) {
        if (updates.containsKey("age")) {
            int age = (Integer) updates.get("age");
            if (age < 21) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "Age cannot be less than 21 years");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            }
        }
        if (updates.containsKey("name")) {
            String name = (String) updates.get("name");
            if (name != null) {
                String normalizedName = name.toLowerCase();
                if (!normalizedName.matches("^[a-z\\s]+$")) {
                    Map<String, String> error = new HashMap<>();
                    error.put("error", "Name must contain only alphabets and spaces, no numbers or special characters allowed");
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
                }
                updates.put("name", name);
            }
        }
        Employee patched = employeeService.patchEmployee(id, updates);
        if (patched == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(patched);
    }
}

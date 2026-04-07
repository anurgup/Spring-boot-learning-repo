package com.ranga.entity;

import javax.validation.constraints.Pattern;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * Employee entity class.
 *
 * @author Ranga Reddy
 * @version 1.0
 */
@Table("employee")
public class Employee {

    @PrimaryKey("id")
    private long id;

    @Column("name")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only alphabets and spaces, no numbers or special characters allowed")
    private String name;

    @Column
    private int age;

    @Column(value = "salary")
    private float salary;

    public Employee() {
        super();
    }

    public Employee(long id, String name, int age, float salary) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age
                + ", salary=" + salary + "]";
    }
}

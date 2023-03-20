package org.pcs.dao;

import org.pcs.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {
    private static int PEOPLE_COUNT;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Employee> index() {
        return jdbcTemplate.query("SELECT * FROM employee", new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee show(int id) {
        return jdbcTemplate.query("SELECT * FROM employee WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Employee.class))
                .stream().findAny().orElse(null);
    }

    public void save(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee VALUES(?, ?, ?, ?, DEFAULT, ?);", employee.getName(),
                employee.getSurname(), employee.getEmail(), employee.getPhone_number(), employee.getId(), employee.getProject_id());
        /*   jdbcTemplate.update("INSERT INTO employee (name, surname, email, phone_number, project_id) VALUES (?, ?, ?, ?, ?)", employee.getName(),
                employee.getSurname(), employee.getEmail(), employee.getPhone_number(), employee.getId(), employee.getProject_id());
    }*/
    }
    public void update(int id, Employee updatedEmployee) {
        jdbcTemplate.update("UPDATE employee SET name=?, surname=?, email=?, phone_number=?, project_id=? WHERE id=?", updatedEmployee.getName(),
                updatedEmployee.getSurname(), updatedEmployee.getEmail(), updatedEmployee.getPhone_number(), updatedEmployee.getProject_id(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM employee WHERE id=?", id);
    }
}

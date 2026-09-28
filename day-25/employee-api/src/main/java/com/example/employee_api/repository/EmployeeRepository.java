package com.example.employee_api.repository;

import com.example.employee_api.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREATE
    public Employee save(Employee employee) {

        String sql = """
                INSERT INTO employees (name, email, salary)
                VALUES (?, ?, ?)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {

            PreparedStatement ps = connection.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setDouble(3, employee.getSalary());

            return ps;

        }, keyHolder);

        Number key = keyHolder.getKey();

        if (key != null) {
            employee.setId(key.longValue());
        }

        return employee;
    }

    // READ ALL
    public List<Employee> findAll() {

        String sql = """
                SELECT id, name, email, salary
                FROM employees
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Employee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("salary")
                )
        );
    }

    // READ BY ID
    public Optional<Employee> findById(Long id) {

        String sql = """
                SELECT id, name, email, salary
                FROM employees
                WHERE id = ?
                """;

        List<Employee> employees = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Employee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("salary")
                ),
                id
        );

        return employees.stream().findFirst();
    }

    // UPDATE
    public boolean update(Long id, Employee employee) {

        String sql = """
                UPDATE employees
                SET name = ?, email = ?, salary = ?
                WHERE id = ?
                """;

        int rows = jdbcTemplate.update(
                sql,
                employee.getName(),
                employee.getEmail(),
                employee.getSalary(),
                id
        );

        return rows > 0;
    }

    // DELETE
    public boolean delete(Long id) {

        String sql = """
                DELETE FROM employees
                WHERE id = ?
                """;

        int rows = jdbcTemplate.update(sql, id);

        return rows > 0;
    }
}
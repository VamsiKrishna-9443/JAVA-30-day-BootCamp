package com.example.employee_api.service;

import com.example.employee_api.dto.EmployeeRequestDTO;
import com.example.employee_api.dto.EmployeeResponseDTO;
import com.example.employee_api.model.Employee;
import com.example.employee_api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // CREATE
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO request) {

        Employee employee = new Employee(null, request.getName(), request.getEmail(), request.getSalary());

        Employee savedEmployee = employeeRepository.save(employee);

        return convertToResponse(savedEmployee);
    }

    // READ ALL
    public List<EmployeeResponseDTO> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // READ BY ID
    public EmployeeResponseDTO getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .map(this::convertToResponse)
                .orElse(null);
    }

    // UPDATE
    public EmployeeResponseDTO updateEmployee(
            Long id,
            EmployeeRequestDTO request) {

        boolean updated = employeeRepository.update(
                id,
                new Employee(
                        id,
                        request.getName(),
                        request.getEmail(),
                        request.getSalary()
                )
        );

        if (!updated) {
            return null;
        }

        return getEmployeeById(id);
    }

    // DELETE
    public boolean deleteEmployee(Long id) {

        return employeeRepository.delete(id);
    }

    private EmployeeResponseDTO convertToResponse(Employee employee) {

        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getSalary()
        );
    }
}
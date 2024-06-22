package com.ptm.learning.ems.service.impl;

import com.ptm.learning.ems.Mapper.EmployeeMapper;
import com.ptm.learning.ems.dto.EmployeeDto;
import com.ptm.learning.ems.entity.Employee;
import com.ptm.learning.ems.exception.ResourceNotFoundException;
import com.ptm.learning.ems.repository.EmployeeRepository;
import com.ptm.learning.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);


        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {

        Employee employee=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List <Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist:" + employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj=employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist"));

        employeeRepository.deleteById(id);

    }
}

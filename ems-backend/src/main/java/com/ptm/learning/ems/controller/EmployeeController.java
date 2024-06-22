package com.ptm.learning.ems.controller;


import com.ptm.learning.ems.dto.EmployeeDto;
import com.ptm.learning.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor

public class EmployeeController {

    private EmployeeService employeeService;

    // Build Add Employee REST API

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee( @RequestBody EmployeeDto employeeDato) {
        EmployeeDto savedEmployee =employeeService.createEmployee(employeeDato);

        return new ResponseEntity <> (savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee REST API
     @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById( @PathVariable ("id") Long employeeId) {
        EmployeeDto employeeDto =employeeService.getEmployeeById(employeeId);

        return ResponseEntity.ok(employeeDto);
    }


    // Build get all employee list REST API
    @GetMapping

    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employee = employeeService.getAllEmployees();

        return ResponseEntity.ok(employee);
    }


    // Build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId , @RequestBody EmployeeDto updatedEmployee){

    EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
    return ResponseEntity.ok(employeeDto);
    }



    // Build delete employee REST API

    @DeleteMapping ("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted");
    }

}

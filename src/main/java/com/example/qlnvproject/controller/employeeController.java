package com.example.qlnvproject.controller;

import com.example.qlnvproject.dto.employeeDto;
import com.example.qlnvproject.model.Employee;
import com.example.qlnvproject.service.employeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("employee")
public class employeeController {
    @Autowired
    private employeeService employeeService;
    private ModelMapper modelMapper;

    public employeeController(employeeService employeeService, ModelMapper modelMapper){
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/insert")
    public ResponseEntity<employeeDto> insertEmployee(@RequestBody employeeDto empDTO){
        Employee empRequest = modelMapper.map(empDTO, Employee.class);
        Employee emp = employeeService.insertEmployee(empRequest);
        employeeDto empResponse = modelMapper.map(emp, employeeDto.class);
        return new ResponseEntity<employeeDto>(empResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<employeeDto> getEmployeeById(@PathVariable long id){
        Employee emp = employeeService.getEmployeeById(id);
        employeeDto empResponse =modelMapper.map(emp, employeeDto.class);
        return ResponseEntity.ok().body(empResponse);
    }

    @GetMapping("/getAll")
    public List<employeeDto> getAllEmployee(){
        return employeeService.getAllEmployee().stream().map(employee -> modelMapper.map(employee, employeeDto.class)).collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<employeeDto> updateEmployeeById(@PathVariable long id,  @RequestBody employeeDto empDTO){
        Employee empRequest = modelMapper.map(empDTO, Employee.class);
        Employee emp = employeeService.updateEmployee(id, empRequest);
        employeeDto empResponse = modelMapper.map(emp, employeeDto.class);

        return ResponseEntity.ok().body(empResponse);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable long id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }



}

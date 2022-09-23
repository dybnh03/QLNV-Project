package com.example.qlnvproject.service.impl;

import com.example.qlnvproject.model.Employee;
import com.example.qlnvproject.repository.employeeRepository;
import com.example.qlnvproject.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeServiceImpl implements employeeService {
    @Autowired

    private employeeRepository employeeRepository;
    public employeeServiceImpl(employeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee insertEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(long id, Employee employeeInput){
    Employee emp = employeeRepository.findById(id).orElse(null);
    emp.setId(employeeInput.getId());
    emp.setUsername(employeeInput.getUsername());
    emp.setFullname(employeeInput.getFullname());
    emp.setEmail(employeeInput.getEmail());
    emp.setPass(employeeInput.getPass());
    emp.setBirthday(employeeInput.getBirthday());
    emp.setDegree(employeeInput.getDegree());
    emp.setSpecialize(employeeInput.getSpecialize());
    return employeeRepository.save(employeeInput);
    }

    @Override
    public void deleteEmployeeById(long id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        assert employee != null;
        employeeRepository.deleteById(employee.getId());
    }

}

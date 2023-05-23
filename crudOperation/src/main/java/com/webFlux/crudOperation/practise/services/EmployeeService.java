package com.webFlux.crudOperation.practise.services;

import com.webFlux.crudOperation.practise.dto.EmployeeDto;
import com.webFlux.crudOperation.practise.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    public Mono<EmployeeDto>  saveEmployee(EmployeeDto employeeDto);

    public Mono<EmployeeDto> getEmployeeById(String empId);

    Flux<EmployeeDto> getAllEmployees();
    Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String empId);
    Mono<Void> deleteEmployee(String empId);

}

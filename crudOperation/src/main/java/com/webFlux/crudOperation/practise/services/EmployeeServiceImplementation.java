package com.webFlux.crudOperation.practise.services;

import com.webFlux.crudOperation.practise.dto.EmployeeDto;
import com.webFlux.crudOperation.practise.entity.Employee;
import com.webFlux.crudOperation.practise.mapper.EmployeeMapper;
import com.webFlux.crudOperation.practise.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@AllArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmplyee(employeeDto);
        Mono<Employee> employeeMono = employeeRepository.save((employee));
        return  employeeMono.map(employeeEntity-> EmployeeMapper.mapToEmplyeeDto(employeeEntity));
    }


    @Override
    public Mono<EmployeeDto> getEmployeeById(String empId) {
        Mono<Employee> empById = employeeRepository.findById(empId);
        return empById.map(empEntity->EmployeeMapper.mapToEmplyeeDto(empEntity));
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {
        Flux<Employee> employeeFlux = employeeRepository.findAll();
        return employeeFlux
                .map((employee) -> EmployeeMapper.mapToEmplyeeDto(employee))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String empId) {
        Mono<Employee> employeeMono = employeeRepository.findById(empId);
        return employeeMono.flatMap((existingEmployee) -> {
            existingEmployee.setName(employeeDto.getName());
            return employeeRepository.save(existingEmployee);
        }).map(employee -> EmployeeMapper.mapToEmplyeeDto(employee));

    }

    @Override
    public Mono<Void> deleteEmployee(String empId) {
        return employeeRepository.deleteById(empId);
    }
}

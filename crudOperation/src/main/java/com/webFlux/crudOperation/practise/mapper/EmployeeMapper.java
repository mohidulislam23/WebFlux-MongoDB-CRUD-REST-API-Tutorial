package com.webFlux.crudOperation.practise.mapper;

import com.webFlux.crudOperation.practise.dto.EmployeeDto;
import com.webFlux.crudOperation.practise.entity.Employee;

public class EmployeeMapper {
    public static Employee mapToEmplyee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getName()
        );
    }
    public static EmployeeDto mapToEmplyeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getName()
        );
    }


}

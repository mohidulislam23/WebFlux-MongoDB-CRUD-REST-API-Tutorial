package com.webFlux.crudOperation.practise.repository;

import com.webFlux.crudOperation.practise.entity.Employee;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String >{

}



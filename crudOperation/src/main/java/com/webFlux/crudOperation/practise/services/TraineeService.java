package com.webFlux.crudOperation.practise.services;

import com.webFlux.crudOperation.practise.dto.EmployeeDto;
import com.webFlux.crudOperation.practise.dto.TraineeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TraineeService {
    public Mono<TraineeDto> saveTrainee(TraineeDto traineeDto);

    public Mono<TraineeDto> getTraineeById(String traineeId);

    Flux<TraineeDto> getAllTrainees();
    Mono<TraineeDto> updateEmployee(TraineeDto traineeDto, String traineeId);
    Mono<Void> deleteTrainee(String traineeId);
}

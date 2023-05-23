package com.webFlux.crudOperation.practise.controller;

import com.webFlux.crudOperation.practise.dto.EmployeeDto;
import com.webFlux.crudOperation.practise.services.TraineeService;
import com.webFlux.crudOperation.practise.dto.TraineeDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("operation/trainee")
@AllArgsConstructor
public class TraineeController {
    private TraineeService traineeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TraineeDto> saveRequestedTrainee(@RequestBody TraineeDto traineeDto){
        return traineeService.saveTrainee(traineeDto);
    }

    @GetMapping("{id}")
    public Mono<TraineeDto> getRequestedTrainee(@PathVariable("id") String traineeId){
        return traineeService.getTraineeById(traineeId);
    }

    @GetMapping("/all")
    public Flux<TraineeDto> getAllTrainee(){
        return traineeService.getAllTrainees();
    }

    @PutMapping("{id}")
    public Mono<TraineeDto> updateTrainee(@RequestBody TraineeDto traineeDto, @PathVariable("id") String traineeId){
        return traineeService.updateEmployee(traineeDto, traineeId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTrainee(@PathVariable("id") String traineeId){
        return traineeService.deleteTrainee(traineeId);
    }



}

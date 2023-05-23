package com.webFlux.crudOperation.practise.services;

import com.webFlux.crudOperation.practise.dto.TraineeDto;
import com.webFlux.crudOperation.practise.entity.Employee;
import com.webFlux.crudOperation.practise.entity.Trainee;
import com.webFlux.crudOperation.practise.mapper.EmployeeMapper;
import com.webFlux.crudOperation.practise.mapper.TraineeMapper;
import com.webFlux.crudOperation.practise.repository.TraineeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class TraineeServiceImplementation implements TraineeService{

    private final TraineeRepository traineeRepository;

    @Override
    public Mono<TraineeDto> saveTrainee(TraineeDto traineeDto) {
        Trainee trainee = TraineeMapper.mapToTrainee(traineeDto);
        Mono<Trainee> traineeMono = traineeRepository.save(trainee);
        return traineeMono.map(trainee1 -> TraineeMapper.mapToTraineeDto(trainee1));
    }

    @Override
    public Mono<TraineeDto> getTraineeById(String traineeId) {
        Mono<Trainee> traineById = traineeRepository.findById(traineeId);
        return traineById.map(traineeEntity-> TraineeMapper.mapToTraineeDto(traineeEntity));

    }

    @Override
    public Flux<TraineeDto> getAllTrainees() {
        Flux<Trainee> traineeFlux = traineeRepository.findAll();
        return traineeFlux
                .map((trainee) -> TraineeMapper.mapToTraineeDto(trainee))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<TraineeDto> updateEmployee(TraineeDto traineeDto, String traineeId) {
        Mono<Trainee> traineeMono = traineeRepository.findById(traineeId);
        return traineeMono.flatMap((existingTrainee) -> {
            existingTrainee.setName(traineeDto.getName());
            existingTrainee.setBloodGroup(traineeDto.getBloodGroup());
            existingTrainee.setDomain(traineeDto.getDomain());

            return traineeRepository.save(existingTrainee);
        }).map(trainee -> TraineeMapper.mapToTraineeDto(trainee));
    }

    @Override
    public Mono<Void> deleteTrainee(String traineeId) {
        return traineeRepository.deleteById(traineeId);
    }
}

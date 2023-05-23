package com.webFlux.crudOperation.practise.mapper;



import com.webFlux.crudOperation.practise.dto.TraineeDto;
import com.webFlux.crudOperation.practise.entity.Trainee;

public class TraineeMapper {
    public static Trainee mapToTrainee(TraineeDto traineeDto){
        return new Trainee(
                traineeDto.getId(),
                traineeDto.getName(),
                traineeDto.getBloodGroup(),
                traineeDto.getDomain()
        );
    }
    public static TraineeDto mapToTraineeDto(Trainee trainee){
        return new TraineeDto(
                trainee.getId(),
                trainee.getName(),
                trainee.getBloodGroup(),
                trainee.getDomain()
        );
    }
}

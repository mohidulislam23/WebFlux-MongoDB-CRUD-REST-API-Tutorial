package com.webFlux.crudOperation.practise.repository;

import com.webFlux.crudOperation.practise.entity.Trainee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TraineeRepository extends ReactiveCrudRepository<Trainee, String > {
}

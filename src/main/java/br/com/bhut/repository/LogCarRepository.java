package br.com.bhut.repository;

import br.com.bhut.model.LogCar;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogCarRepository extends MongoRepository<LogCar, Integer> {
}

package me.velfinvelasquez.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.velfinvelasquez.models.Tarea;

public interface TaskRepository extends MongoRepository<Tarea, String>{

}

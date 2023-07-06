package me.velfinvelasquez.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Tarea {
	@Id
	private String id;
	private String nombre;
	private Boolean completed;
}

package com.proceso.matricula.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="pais")
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPais;
	private String iso;
	private String nombre;
}

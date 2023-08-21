package com.proceso.matricula.models.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proceso.matricula.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{

}

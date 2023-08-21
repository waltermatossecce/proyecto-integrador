package com.proceso.matricula.service;




import com.proceso.matricula.models.Alumno;

public interface AlumnoService {

	public Iterable<Alumno>findAll();
	public Alumno findById(int idAlumno);
	public Alumno save(Alumno alumno);
	public void deleteById(int idAlumno);
}

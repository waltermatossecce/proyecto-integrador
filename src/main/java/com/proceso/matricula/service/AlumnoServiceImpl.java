package com.proceso.matricula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proceso.matricula.models.Alumno;
import com.proceso.matricula.models.repositorio.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAll() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findById(int idAlumno) {
		// TODO Auto-generated method stub
		return alumnoRepository.findById(idAlumno).orElse(null);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(alumno);
	}

	@Override
	@Transactional
	public void deleteById(int idAlumno) {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(idAlumno);
	}

}

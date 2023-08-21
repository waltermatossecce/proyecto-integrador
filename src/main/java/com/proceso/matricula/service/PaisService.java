package com.proceso.matricula.service;

import java.util.List;
import java.util.Optional;

import com.proceso.matricula.models.Pais;

public interface PaisService {

	public List<Pais>listaPais();
	public Pais save(Pais pais);
	public Optional<Pais>findById(int idPais);
	public void deleteById(int idPais);
}

package com.proceso.matricula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proceso.matricula.models.Pais;
import com.proceso.matricula.models.repositorio.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService{

	
	@Autowired
	private PaisRepository paisRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Pais> listaPais() {
		// TODO Auto-generated method stub
		return paisRepository.findAll();
	}

	@Override
	@Transactional
	public Pais save(Pais pais) {
		// TODO Auto-generated method stub
		return paisRepository.save(pais);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pais> findById(int idPais) {
		// TODO Auto-generated method stub
		return paisRepository.findById(idPais);
	}

	@Override
	@Transactional
	public void deleteById(int idPais) {
		// TODO Auto-generated method stub
		paisRepository.deleteById(idPais);
	}

}

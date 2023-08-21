package com.proceso.matricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proceso.matricula.models.DataCatalogo;
import com.proceso.matricula.models.repositorio.DataCatalogoRepository;

@Service
public class DataCatalogoServiceImpl implements DataCatalogoService {

	@Autowired
	private DataCatalogoRepository catalogoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<DataCatalogo> listaDataCatalogo() {
		// TODO Auto-generated method stub
		return catalogoRepository.findAll();
	}
	

}

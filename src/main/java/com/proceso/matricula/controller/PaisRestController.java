package com.proceso.matricula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proceso.matricula.models.Pais;
import com.proceso.matricula.service.PaisService;


@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PaisRestController {

	
	@Autowired
	private PaisService paisService;
	
	@GetMapping("/pais")
	public ResponseEntity<List<Pais>>index(){
		List<Pais>pais=paisService.listaPais();
		if(pais.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(pais);
	}
	@PostMapping("/pais")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pais>create(@RequestBody Pais pais){
		Pais nuevoPais=paisService.save(pais);
		return ResponseEntity.ok(nuevoPais);
	}
}

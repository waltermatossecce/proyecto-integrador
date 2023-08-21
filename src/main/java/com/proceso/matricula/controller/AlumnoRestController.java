package com.proceso.matricula.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proceso.matricula.models.Alumno;
import com.proceso.matricula.service.AlumnoService;


@RestController
@RequestMapping("/api/alumno")
public class AlumnoRestController {

	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping
	public ResponseEntity<List<Alumno>>index(){
		List<Alumno>lista=(List<Alumno>) alumnoService.findAll();
		return ResponseEntity.ok(lista);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Alumno>show(@PathVariable int id){
		Alumno alumno=alumnoService.findById(id);
		if(alumno==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(alumno);
	
	}
	
	@PostMapping
	public ResponseEntity<Alumno>create(@RequestBody Alumno alumno){
		alumno.setFechaRegistro(new Date());
		alumno.setFechaActualizacion(new Date());
		alumno.setEstado(1);
		
		Alumno objAlumno=alumnoService.save(alumno);
		Map<String, Object>salida=new HashMap<>();
		if (objAlumno==null) {
			salida.put("mensaje", "Error en el registro");
		}else {
			salida.put("mensaje","Se registro correctamente con el ID ==>" + objAlumno.getIdAlumno());
		}
		return ResponseEntity.ok(objAlumno);
	}

	@PutMapping("/actualizaAlumno/{id}")
	public ResponseEntity<Map<String, Object>>actualizaAlumno(@RequestBody Alumno alumno,@PathVariable int id){
	
		Map<String, Object>resultado=new HashMap<>();
		try {
			Alumno alumnodb=alumnoService.findById(id);
			alumnodb.setNombre(alumno.getNombre());
			alumnodb.setApellido(alumno.getApellido());
			alumnodb.setTelefono(alumno.getTelefono());
			alumnodb.setDni(alumno.getDni());
			alumnodb.setCorreo(alumno.getCorreo());
			alumnodb.setEstado(alumno.getEstado());
			alumnodb.setPais(alumno.getPais());
			alumnodb.setModalidad(alumno.getModalidad());

			Alumno obj=alumnoService.save(alumnodb);
			if (obj==null) {
				resultado.put("mensaje", "Error en la actualizacion");
			}
			else {
				resultado.put("mensaje", "Se actualizo con el ID ==>" + obj.getIdAlumno());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resultado.put("mensaje", "Error al actualizar");
		}
		return ResponseEntity.ok(resultado);
	}

	
	
}

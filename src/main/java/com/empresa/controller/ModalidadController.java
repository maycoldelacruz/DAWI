package com.empresa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Modalidad;
import com.empresa.service.ModalidadService;

@RestController
@RequestMapping("/url/modalidad")
public class ModalidadController {

	@Autowired
	private ModalidadService service;
	
	
	@GetMapping
	public List<Modalidad> listaModalidad(){
		List<Modalidad> lstSalida = service.listaModalidad();
		return lstSalida;
	}
	
	@PostMapping
	public ResponseEntity<?>  insertaModalidad(@RequestBody Modalidad obj){
		List<String> lstSalida = new ArrayList<String>();
		
		obj.setEstado(1);
		obj.setFechaRegistro(new Date());
		obj.setFechaActualizacion(new Date());
		
		Modalidad objSalida = service.insertaModalidad(obj);
		if (objSalida == null) {
			lstSalida.add("Error en el registro");
		}else {
			lstSalida.add("se registra la modalidad con el id : " + objSalida.getIdModalidad());
		}
			
		return ResponseEntity.ok(lstSalida);
	}
}
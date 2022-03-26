package com.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.DTO.ProfesorRequestDTO;
import com.idat.DTO.ProfesorResponseDTO;
import com.idat.model.Profesor;
import com.idat.service.ProfesorServices;
@RestController
@RequestMapping("/profesor/v1")
public class ProfesorController {

	@Autowired
	private ProfesorServices service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<ProfesorResponseDTO>>listar(){
		
		return new ResponseEntity<List<ProfesorResponseDTO>>(service.Listar(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody ProfesorRequestDTO profesor){
		service.Guardar(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<ProfesorResponseDTO>ProfesorById(@PathVariable Integer id){
		ProfesorResponseDTO prof = service.ProfesorById(id);
		if(prof != null) {
			return new ResponseEntity<ProfesorResponseDTO>(prof, HttpStatus.OK);

		}
		return new ResponseEntity<ProfesorResponseDTO>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		ProfesorResponseDTO prof = service.ProfesorById(id);
		if(prof != null) {
			service.Eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody ProfesorRequestDTO profesor){
		ProfesorResponseDTO prof = service.ProfesorById(profesor.getIdRequest());
		if(prof != null) {
			service.Editar(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}

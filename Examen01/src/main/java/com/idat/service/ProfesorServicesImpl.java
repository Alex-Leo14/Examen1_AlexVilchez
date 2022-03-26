package com.idat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.DTO.ProfesorRequestDTO;
import com.idat.DTO.ProfesorResponseDTO;
import com.idat.model.Profesor;
import com.idat.repository.ProfesorRepository;

@Service
public class ProfesorServicesImpl implements ProfesorServices {

	

	@Autowired
	private ProfesorRepository repository;
	@Override
	public void Guardar(ProfesorRequestDTO p) {
		
		Profesor prof = new Profesor();
		prof.setIdProfesor(p.getIdRequest());
		prof.setProfesor(p.getNombreProfesor());
		
		repository.save(prof);
	}

	@Override
	public void Eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void Editar(ProfesorRequestDTO p) {
		Profesor prof = new Profesor();
		prof.setIdProfesor(p.getIdRequest());
		prof.setProfesor(p.getNombreProfesor());
		repository.saveAndFlush(prof);
	}

	@Override
	public List<ProfesorResponseDTO> Listar() {
		List<Profesor> prof = repository.findAll();
		
		List<ProfesorResponseDTO> dto = new ArrayList<ProfesorResponseDTO>();
		ProfesorResponseDTO profDto = null;
		
		
		for (Profesor profesor : prof) {
			profDto = new ProfesorResponseDTO();
			profDto.setIdResponse(profesor.getIdProfesor());
			profDto.setNombreProfesor(profesor.getProfesor());
	
			dto.add(profDto);
		}
		
		return dto;
	}

	@Override
	public ProfesorResponseDTO ProfesorById(Integer id) {
		Profesor profesor = repository.findById(id).orElse(null);
		ProfesorResponseDTO profDto = new ProfesorResponseDTO();
		
		profDto = new ProfesorResponseDTO();
		profDto.setIdResponse(profesor.getIdProfesor());
		profDto.setNombreProfesor(profesor.getProfesor());
		return profDto;
	}

}

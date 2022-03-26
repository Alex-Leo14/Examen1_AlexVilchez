package com.idat.service;

import java.util.List;

import com.idat.DTO.ProfesorRequestDTO;
import com.idat.DTO.ProfesorResponseDTO;

public interface ProfesorServices {

	public void Guardar(ProfesorRequestDTO p);
	public void Eliminar(Integer id);
	public void Editar(ProfesorRequestDTO p);
	public List<ProfesorResponseDTO> Listar();
	public ProfesorResponseDTO ProfesorById(Integer id);
	
}

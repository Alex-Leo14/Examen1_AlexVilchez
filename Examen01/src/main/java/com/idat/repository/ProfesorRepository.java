package com.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

	
}

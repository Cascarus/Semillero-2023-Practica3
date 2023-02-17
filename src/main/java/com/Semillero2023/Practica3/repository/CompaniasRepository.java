package com.Semillero2023.Practica3.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Semillero2023.Practica3.entity.Companias;

@Repository("CompaniasRepository")
public interface CompaniasRepository extends JpaRepository<Companias, Serializable>{
	
	public Companias findByNombreCompaniaLike(String nombre);
	
	public List<Companias> findByCodPostal(Integer codPostal);
}

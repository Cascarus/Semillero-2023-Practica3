package com.Semillero2023.Practica3.ws;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.Semillero2023.Practica3.dto.PeritoDto;
import com.Semillero2023.Practica3.entity.Peritos;
import com.Semillero2023.Practica3.repository.PeritosRepository;
import com.Semillero2023.Practica3.repository.SiniestrosRepository;
import com.Semillero2023.Practica3.wsInt.PeritosServiceInt;

@Component
public class PeritosService implements PeritosServiceInt{

	@Autowired
	PeritosRepository peritosRepository;
	
	@Autowired
	SiniestrosRepository siniestrosRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public String test() {
		return "Todo bien desde Peritos Service";
	}

	@Override
	public List<Peritos> verTodo() {
		return peritosRepository.findAll();
	}

	@Override
	public Peritos addPeritos(PeritoDto peritoDto) {
		Peritos nuevo = modelMapper.map(peritoDto, Peritos.class);
		return peritosRepository.save(nuevo);
	}

	@Override
	public Peritos modificarPeritos(PeritoDto peritoDto) {
		return addPeritos(peritoDto);
	}

	@Override
	public ResponseEntity<String> deletePeritos(Integer id) {
		Optional<Peritos> perito = peritosRepository.findById(id);
		
		if(perito.isPresent()) {
			siniestrosRepository.deleteAll(perito.get().getSiniestros());
			peritosRepository.delete(perito.get());
			return new ResponseEntity<>("El perito se ha eliminado exitosamente",  HttpStatus.OK);
		}
		
		return new ResponseEntity<>("El perito no existe",  HttpStatus.NOT_FOUND);
	}

	@Override
	public Peritos buscarPorTelefonoContacto(String telefono) {
		return peritosRepository.findByTelefonoContacto(telefono);
	}

	@Override
	public List<Peritos> buscarPorCodigoPostal(Integer postal) {
		return peritosRepository.findByCodPostal(postal);
	}

}

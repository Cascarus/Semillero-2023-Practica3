package com.Semillero2023.Practica3.wsInt;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Semillero2023.Practica3.dto.SiniestroDto;
import com.Semillero2023.Practica3.entity.Siniestros;

@CrossOrigin
@RestController
@RequestMapping("/siniestro")
public interface SiniestrosServicesInt {
	
	@GetMapping("/")
	public String test();
	
	@GetMapping("/verTodos")
	public List<Siniestros> verTodos();
	
	@PostMapping("/crearSiniestro")
	public Siniestros addSiniestro(@RequestBody SiniestroDto SiniestroDto);
	
	@PutMapping("/modificarSiniestro")
	public Siniestros modificarSiniestro(@RequestBody SiniestroDto SiniestroDto);
	
	@DeleteMapping("/eliminarSiniestro/{id}")
	public ResponseEntity<String> deleteSiniestro(@PathVariable("id") Integer id);
	
	@GetMapping("/buscarPorAceptado/{estado}")
	public Page<Siniestros> buscarPorAceptado(
			@PathVariable("estado") String estado,
			@RequestParam(name="page") Integer page,
			@RequestParam(name="size") Integer size);
	
}

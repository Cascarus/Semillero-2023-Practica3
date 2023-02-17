package com.Semillero2023.Practica3.wsInt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Semillero2023.Practica3.entity.Usuario;

@CrossOrigin
@RestController
@RequestMapping("/publico")
public interface UsuarioServicesInt {
	
	@PostMapping("/login")
	public ResponseEntity<?>loginUser(@RequestBody Usuario user);
}

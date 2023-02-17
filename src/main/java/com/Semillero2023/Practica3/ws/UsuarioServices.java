package com.Semillero2023.Practica3.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.Semillero2023.Practica3.config.JwtGeneratorInterface;
import com.Semillero2023.Practica3.repository.UsuarioRepository;
import com.Semillero2023.Practica3.entity.Usuario;
import com.Semillero2023.Practica3.wsInt.UsuarioServicesInt;

@Component
public class UsuarioServices implements UsuarioServicesInt{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	JwtGeneratorInterface jwtGenerator;
	
	@Override
	public ResponseEntity<?> loginUser(Usuario user) {
		try {
			if (user.getUsername() == null || user.getPassword() == null) {
				return new ResponseEntity<>("UserName or Password is Empty", HttpStatus.NOT_ACCEPTABLE);
			}
			Usuario userData = usuarioRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
			if (userData == null) {
				return new ResponseEntity<>("UserName or Password is Invalid", HttpStatus.NOT_ACCEPTABLE);
			}
			return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

}

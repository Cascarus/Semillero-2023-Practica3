package com.Semillero2023.Practica3.config;

import java.util.Map;

import com.Semillero2023.Practica3.entity.Usuario;

public interface JwtGeneratorInterface {
	Map<String, String> generateToken(Usuario user);
}

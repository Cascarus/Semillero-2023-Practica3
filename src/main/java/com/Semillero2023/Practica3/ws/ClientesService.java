package com.Semillero2023.Practica3.ws;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.Semillero2023.Practica3.dto.ClientesDto;
import com.Semillero2023.Practica3.entity.Clientes;
import com.Semillero2023.Practica3.repository.ClientesRepository;
import com.Semillero2023.Practica3.repository.SegurosRepository;
import com.Semillero2023.Practica3.wsInt.ClientesServiceInt;


@Component
public class ClientesService implements ClientesServiceInt{
	
	@Autowired
	ClientesRepository clientesRepository;
	
	
	@Autowired
	SegurosRepository segurosRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public String test() {
		return "Todo bien todo correcto desde clientes";
	}

	@Override
	public List<Clientes> verTodos() {
		return clientesRepository.findAll();
	}

	@Override
	public Clientes addCliente(ClientesDto cliente) {
		Clientes nuevo = modelMapper.map(cliente, Clientes.class);
		return clientesRepository.save(nuevo);
	}
	
	@Override
	public Clientes modificarCliente(ClientesDto clientedto) {
		
		return addCliente(clientedto);
		
	}

	@Override
	public ResponseEntity<String> deleteCliente(Integer dni) {
		Optional<Clientes> client = clientesRepository.findBydniCl(dni);
		
		if(client.isPresent()) {
			segurosRepository.deleteAll(client.get().getSeguros());
			clientesRepository.delete(client.get());
			return new ResponseEntity<>("El cliente se ha eliminado exitosamente",  HttpStatus.OK);
		}
		
		return new ResponseEntity<>("El cliente no existe",  HttpStatus.NOT_FOUND);
	}

	@Override
	public List<Clientes> BuscarPorNombre(String nombre) {
		return clientesRepository.findByNombreClStartingWith(nombre.replace("+", " "));
	}

	@Override
	public List<Clientes> BuscarPorCiudad(String ciudad) {
		return clientesRepository.findByCiudadLike(ciudad.replace("+", " "));
	}

	

}

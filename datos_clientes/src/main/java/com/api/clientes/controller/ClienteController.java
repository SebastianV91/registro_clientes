package com.api.clientes.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.clientes.dao.IClienteDao;
import com.api.clientes.model.Cliente;
import com.api.clientes.services.IClienteService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@PostMapping("/save")
	public ResponseEntity<?> create(@RequestBody Cliente cliente) {
		
		Cliente clienteNuevo = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
				
				clienteNuevo = clienteService.saveCliente(cliente);
				
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar el cliente en la base de datos");
			response.put("error", e.getMessage().concat(" ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Cliente creado con exito");
		response.put("cliente", clienteNuevo);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
}

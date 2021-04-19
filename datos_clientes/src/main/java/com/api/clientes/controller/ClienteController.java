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

import com.api.clientes.model.Cliente;
import com.api.clientes.services.IClienteService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	private Cliente cliente = new Cliente();
	private Long num_identificacion;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getNum_identificacion() {
		return num_identificacion;
	}

	public void setNum_identificacion(Long num_identificacion) {
		this.num_identificacion = num_identificacion;
	}

	@PostMapping("/save")
	public ResponseEntity<?> create(@RequestBody Cliente cliente) {
		
		Cliente clienteNuevo = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			if(num_identificacion != null && num_identificacion.equals(cliente.getNum_identificacion())) {
				
				response.put("mensaje", "Este numero de identificacion ya existe.");
				response.put("cliente", clienteNuevo);
				
			}else {
			
				clienteNuevo = clienteService.saveCliente(cliente);
				
				response.put("mensaje", "Cliente creado con exito");
				response.put("cliente", clienteNuevo);
			
			}
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar el cliente en la base de datos");
			response.put("error", e.getMessage().concat(" ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
}

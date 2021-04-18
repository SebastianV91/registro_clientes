package com.api.clientes.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.clientes.dao.IClienteDao;
import com.api.clientes.model.Cliente;
import com.api.clientes.services.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	public Cliente saveCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.save(cliente);
	}

}

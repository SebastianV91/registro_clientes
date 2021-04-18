package com.api.clientes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.clientes.model.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

}

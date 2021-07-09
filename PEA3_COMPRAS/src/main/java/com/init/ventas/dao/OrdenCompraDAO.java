package com.init.ventas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.ventas.entidad.OrdenCompra;

public interface OrdenCompraDAO extends JpaRepository<OrdenCompra, Integer>{

}

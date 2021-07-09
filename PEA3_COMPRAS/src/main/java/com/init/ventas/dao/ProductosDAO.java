package com.init.ventas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.ventas.entidad.Productos;

public interface ProductosDAO extends JpaRepository<Productos, Integer>{

}

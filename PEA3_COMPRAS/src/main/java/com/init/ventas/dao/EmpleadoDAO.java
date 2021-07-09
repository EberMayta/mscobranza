package com.init.ventas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.ventas.entidad.Empleado;

public interface EmpleadoDAO extends JpaRepository<Empleado,Integer> {

}

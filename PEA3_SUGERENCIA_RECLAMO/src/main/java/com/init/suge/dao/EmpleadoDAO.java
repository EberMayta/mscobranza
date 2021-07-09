package com.init.suge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.init.suge.entidad.Empleado;
public interface EmpleadoDAO  extends JpaRepository<Empleado, Integer>{

	
}

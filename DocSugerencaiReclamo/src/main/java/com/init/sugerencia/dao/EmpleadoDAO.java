package com.init.sugerencia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.init.sugerencia.entidad.Empleado;
public interface EmpleadoDAO  extends JpaRepository<Empleado, Integer>{

	
}

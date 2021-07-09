package com.init.sugerencia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.init.sugerencia.entidad.Proveedor;
public interface ProveedorDAO  extends JpaRepository<Proveedor, Integer> {

}

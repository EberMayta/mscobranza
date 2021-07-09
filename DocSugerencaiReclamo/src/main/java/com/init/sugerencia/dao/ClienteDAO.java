package com.init.sugerencia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.init.sugerencia.entidad.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Integer>{

}

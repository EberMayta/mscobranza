package com.init.suge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.init.suge.entidad.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Integer>{

}

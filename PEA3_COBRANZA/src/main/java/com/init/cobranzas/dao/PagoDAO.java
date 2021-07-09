package com.init.cobranzas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.cobranzas.entidad.Pagos;

public interface PagoDAO extends JpaRepository<Pagos, Integer> {

}

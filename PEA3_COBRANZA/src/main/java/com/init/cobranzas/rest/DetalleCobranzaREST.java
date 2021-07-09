package com.init.cobranzas.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.cobranzas.dao.DetalleCobranzaDAO;
import com.init.cobranzas.entidad.DetalleCobranza;


@RestController
@RequestMapping("/")
public class DetalleCobranzaREST {
	
	@Autowired
	private DetalleCobranzaDAO detalledao;
	
	@RequestMapping(value = "detallecobranza",method = RequestMethod.GET)
	public ResponseEntity<List<DetalleCobranza>> getDetalleCo()
	{
		List<DetalleCobranza> detallecobra = detalledao.findAll();
		
		return ResponseEntity.ok(detallecobra);
	}
	
	@RequestMapping(value = "detallecobranza/{detallecobranzaId}", method = RequestMethod.GET)
	public ResponseEntity<DetalleCobranza> getDetaCoById(@PathVariable("detallecobranzad") int detallecobranzaId)
	{
		Optional<DetalleCobranza> optionalCobranza= detalledao.findById(detallecobranzaId);
		
		if(optionalCobranza.isPresent()) 
		{
			return ResponseEntity.ok(optionalCobranza.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	@RequestMapping(value = "detallecobranza" , method = RequestMethod.POST)
	public ResponseEntity<DetalleCobranza> crearDetalle(@RequestBody DetalleCobranza detallecobranzas)
	{
		DetalleCobranza nuevoDetalleC = detalledao.save(detallecobranzas);
		
		return ResponseEntity.ok(nuevoDetalleC);
	}
	
	@DeleteMapping
	@RequestMapping(value = "detallecobranza/{detallecobranzaId}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarDetalle(@PathVariable("detallecobranzaId") Integer Id)
	{
		detalledao.deleteById(Id);
		
		return ResponseEntity.ok(null);
	}
	
	

	@PutMapping
	@RequestMapping(value = "detallecobranza" , method = RequestMethod.PUT)
	public ResponseEntity<DetalleCobranza> actualizarDetalleCompra(@RequestBody DetalleCobranza detallecobranzas)
	{
		Optional<DetalleCobranza> optionalDetalle= detalledao.findById(detallecobranzas.getId_dc());
		
		if(optionalDetalle.isPresent()) 
		{
			DetalleCobranza actualizaDetalle= optionalDetalle.get();
			actualizaDetalle.setID_Pago(detallecobranzas.getID_Pago());
			actualizaDetalle.setID_Deuda(detallecobranzas.getID_Deuda());
			actualizaDetalle.setDescripcion(detallecobranzas.getDescripcion());
			detalledao.save(actualizaDetalle);
			
			return ResponseEntity.ok(actualizaDetalle);
		} else {
			return ResponseEntity.noContent().build();
		}
		
		
	}

}

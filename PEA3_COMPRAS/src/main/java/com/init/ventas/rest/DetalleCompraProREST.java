package com.init.ventas.rest;

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

import com.init.ventas.entidad.DetalleCompraPro;
import com.init.ventas.dao.DetalleCompraProDAO;


@RestController
@RequestMapping("/")
public class DetalleCompraProREST {

	@Autowired
	private DetalleCompraProDAO   detallecompraDAO;
	
	
	@RequestMapping(value = "detallecomprapra",method = RequestMethod.GET)
	public ResponseEntity<List<DetalleCompraPro>> getDetalleCompraPro()
	{
		List<DetalleCompraPro> detallecompra = detallecompraDAO.findAll();
		
		return ResponseEntity.ok(detallecompra);
	}
	
	@RequestMapping(value = "detallecomprapra/{detallecomprapraId}", method = RequestMethod.GET)
	public ResponseEntity<DetalleCompraPro> getDetaComPeoById(@PathVariable("detallecomprapraId") int detallecomprapraId)
	{
		Optional<DetalleCompraPro> optionalDetalleCompra= detallecompraDAO.findById(detallecomprapraId);
		
		if(optionalDetalleCompra.isPresent()) 
		{
			return ResponseEntity.ok(optionalDetalleCompra.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	@RequestMapping(value = "detallecomprapra" , method = RequestMethod.POST)
	public ResponseEntity<DetalleCompraPro> crearDetalleCompraP(@RequestBody DetalleCompraPro detallecompraP)
	{
		DetalleCompraPro nuevoDetalleCP = detallecompraDAO.save(detallecompraP);
		
		return ResponseEntity.ok(nuevoDetalleCP);
	}
	
	@DeleteMapping
	@RequestMapping(value = "detallecomprapra/{detallecomprapraId}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarDetalleCompraP(@PathVariable("detallecomprapraId") Integer Id)
	{
		detallecompraDAO.deleteById(Id);
		
		return ResponseEntity.ok(null);
	}
	
	

	@PutMapping
	@RequestMapping(value = "detallecomprapra" , method = RequestMethod.PUT)
	public ResponseEntity<DetalleCompraPro> actualizarDetalleCompra(@RequestBody DetalleCompraPro detallecompraP)
	{
		Optional<DetalleCompraPro> optionalDetalleComPro = detallecompraDAO.findById(detallecompraP.getIdDetalle());
		
		if(optionalDetalleComPro.isPresent()) 
		{
			DetalleCompraPro actualizaDetalleComPro= optionalDetalleComPro.get();
			actualizaDetalleComPro.setIdOrdenC(detallecompraP.getIdOrdenC());
			actualizaDetalleComPro.setIdProducto(detallecompraP.getIdProducto());
			actualizaDetalleComPro.setDescripcion(detallecompraP.getDescripcion());
			detallecompraDAO.save(actualizaDetalleComPro);
			
			return ResponseEntity.ok(actualizaDetalleComPro);
		} else {
			return ResponseEntity.noContent().build();
		}
		
		
	}
}

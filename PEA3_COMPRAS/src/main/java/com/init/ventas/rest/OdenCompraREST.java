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

import com.init.ventas.entidad.OrdenCompra;
import com.init.ventas.dao.OrdenCompraDAO;

@RestController
@RequestMapping("/")
public class OdenCompraREST {

	@Autowired
	private OrdenCompraDAO ordencompraDAO;
	
	@RequestMapping(value="ordencompra", method = RequestMethod.GET)
	public ResponseEntity<List<OrdenCompra>> getOrdenCompra()
	{
		List<OrdenCompra> ordencompra = ordencompraDAO.findAll();
		
		return ResponseEntity.ok(ordencompra);
	}
	
	@RequestMapping(value = "ordencompra/{ordencompraId}", method = RequestMethod.GET)
	public ResponseEntity<OrdenCompra> getOrdenCompraById(@PathVariable("ordencompraId") int ordencompraId)
	{
		Optional<OrdenCompra> optionalOrdenCompra= ordencompraDAO.findById(ordencompraId);
		
		if(optionalOrdenCompra.isPresent()) 
		{
			return ResponseEntity.ok(optionalOrdenCompra.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	@RequestMapping(value = "ordencompra" , method = RequestMethod.POST)
	public ResponseEntity<OrdenCompra> crearOrdenCompra(@RequestBody OrdenCompra ordencompra)
	{
		OrdenCompra nuevoOrdenCompra= ordencompraDAO.save(ordencompra);
		
		return ResponseEntity.ok(nuevoOrdenCompra);
	}
	
	@DeleteMapping
	@RequestMapping(value = "ordencompra/{ordencompraId}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarOdenCompra(@PathVariable("ordencompraId") Integer Id)
	{
		ordencompraDAO.deleteById(Id);
		
		return ResponseEntity.ok(null);
	}
	
	

	@PutMapping
	@RequestMapping(value = "ordencompra" , method = RequestMethod.PUT)
	public ResponseEntity<OrdenCompra> actualizarOrdenCompra(@RequestBody OrdenCompra ordencompra)
	{
		
		Optional<OrdenCompra> optionalOrdenCompra= ordencompraDAO.findById(ordencompra.getIdOrdenC());
		
		if(optionalOrdenCompra.isPresent()) 
		{
			OrdenCompra actualizaOrdencoCompra= optionalOrdenCompra.get();
			actualizaOrdencoCompra.setIdProveedor(ordencompra.getIdProveedor());
			actualizaOrdencoCompra.setIdEmpleado(ordencompra.getIdEmpleado());
			actualizaOrdencoCompra.setDescripcionOC(ordencompra.getDescripcionOC());
			actualizaOrdencoCompra.setFehcaDescrip(ordencompra.getFehcaDescrip());
			ordencompraDAO.save(actualizaOrdencoCompra);
			
			return ResponseEntity.ok(actualizaOrdencoCompra);
		} else {
			return ResponseEntity.noContent().build();
		}
		
		
	}
}

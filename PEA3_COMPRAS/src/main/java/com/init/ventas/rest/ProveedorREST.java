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

import com.init.ventas.entidad.Proveedor;
import com.init.ventas.dao.ProveedorDAO;

@RestController
@RequestMapping("/")
public class ProveedorREST {

	@Autowired
	private ProveedorDAO proveedorDAO;

	@RequestMapping(value = "proveedor" , method = RequestMethod.GET)
	public ResponseEntity<List<Proveedor>> getProveedor()
	{
		
		List<Proveedor> proveedor =  proveedorDAO.findAll();
		
		return ResponseEntity.ok(proveedor);
		//return null;
	}
	
	@RequestMapping(value = "proveedor/{proveedorId}", method = RequestMethod.GET)
	public ResponseEntity<Proveedor> getProveedorById(@PathVariable("proveedorId") int proveedorId)
	{
		Optional<Proveedor> optionalProveedor = proveedorDAO.findById(proveedorId);
		
		if(optionalProveedor.isPresent()) 
		{
			return ResponseEntity.ok(optionalProveedor.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	@RequestMapping(value = "proveedor" , method = RequestMethod.POST)
	public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor proveedor)
	{
		Proveedor nuevoProveedor = proveedorDAO.save(proveedor);
		
		return ResponseEntity.ok(nuevoProveedor);
	}
	
	@DeleteMapping
	@RequestMapping(value = "proveedor/{proveedorId}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarProveedor(@PathVariable("proveedorId") Integer Id)
	{
		proveedorDAO.deleteById(Id);
		
		return ResponseEntity.ok(null);
	}
	
	

	@PutMapping
	@RequestMapping(value = "proveedor" , method = RequestMethod.PUT)
	public ResponseEntity<Proveedor> actualizarProveedor(@RequestBody Proveedor proveedor)
	{
	
		Optional<Proveedor> optionalProveedor = proveedorDAO.findById(proveedor.getIdProveedor());
		
		if(optionalProveedor.isPresent()) 
		{
			Proveedor actualizaProveedor = optionalProveedor.get();
			actualizaProveedor.setNombre(proveedor.getNombre());
			actualizaProveedor.setApellido(proveedor.getApellido());
			actualizaProveedor.setDireccion(proveedor.getDireccion());
			actualizaProveedor.setCelular(proveedor.getCelular());
			proveedorDAO.save(actualizaProveedor);
			
			return ResponseEntity.ok(actualizaProveedor);
		} else {
			return ResponseEntity.noContent().build();
		}
		
		
	}
}

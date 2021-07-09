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

import com.init.ventas.entidad.Productos;
import com.init.ventas.dao.ProductosDAO;

@RestController
@RequestMapping("/")
public class ProductosREST {

	@Autowired
	private ProductosDAO productosDAO;
	
	@RequestMapping(value = "productos" , method = RequestMethod.GET)
	public ResponseEntity<List<Productos>> getProductos()
	{
		//Devuelve una lista de productos o clientes 
		List<Productos> productos =  productosDAO.findAll();
		
		return ResponseEntity.ok(productos);
		//return null;
	}
	
	@RequestMapping(value = "productos/{productosId}", method = RequestMethod.GET)
	public ResponseEntity<Productos> getProductoById(@PathVariable("productosId") int productoId)
	{
		Optional<Productos> optionalProducto = productosDAO.findById(productoId);
		
		if(optionalProducto.isPresent()) 
		{
			return ResponseEntity.ok(optionalProducto.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	@RequestMapping(value = "productos" , method = RequestMethod.POST)
	public ResponseEntity<Productos> crearProductos(@RequestBody Productos productos)
	{
		Productos nuevoProductos = productosDAO.save(productos);
		
		return ResponseEntity.ok(nuevoProductos);
	}
	
	@DeleteMapping
	@RequestMapping(value = "productos/{productosId}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarProducto(@PathVariable("productosId") Integer Id)
	{
		productosDAO.deleteById(Id);
		
		return ResponseEntity.ok(null);
	}
	
	

	@PutMapping
	@RequestMapping(value = "productos" , method = RequestMethod.PUT)
	public ResponseEntity<Productos> actualizarProducto(@RequestBody Productos productos)
	{
		//Devuelve un cliente
		//optional verfica si el objero contiene algun valor null
		Optional<Productos> optionalProducto = productosDAO.findById(productos.getIdProducto());
		
		if(optionalProducto.isPresent()) 
		{
			Productos actualizaProducto = optionalProducto.get();
			actualizaProducto.setNombreP(productos.getNombreP());
			actualizaProducto.setDescripcionP(productos.getDescripcionP());
			actualizaProducto.setPrecioPxU(productos.getPrecioPxU());
			actualizaProducto.setCantidad(productos.getCantidad());
			productosDAO.save(actualizaProducto);
			
			return ResponseEntity.ok(actualizaProducto);
		} else {
			return ResponseEntity.noContent().build();
		}
		
		
	}
}

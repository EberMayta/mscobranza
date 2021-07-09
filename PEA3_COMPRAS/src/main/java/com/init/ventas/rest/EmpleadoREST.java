package com.init.ventas.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.ventas.dao.EmpleadoDAO;
import com.init.ventas.entidad.Empleado;



@RestController
@RequestMapping("/")
public class EmpleadoREST {
	
	@Autowired
	private EmpleadoDAO empleadoDAO;

	@RequestMapping(value = "empleado" , method = RequestMethod.GET)
	public ResponseEntity<List<Empleado>> getEmpleado()
	{
		//Devuelve una lista de productos o clientes 
		List<Empleado> empleado =  empleadoDAO.findAll();
		
		return ResponseEntity.ok(empleado);
		//return null;
	}
	
	@RequestMapping(value = "empleado/{empleadoId}", method = RequestMethod.GET)
	public ResponseEntity<Empleado> getEmpleadoById(@PathVariable("empleadoId") int empleadoId)
	{
		Optional<Empleado> optionalEmpleado = empleadoDAO.findById(empleadoId);
		
		if(optionalEmpleado.isPresent()) 
		{
			return ResponseEntity.ok(optionalEmpleado.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	@RequestMapping(value = "empleado" , method = RequestMethod.POST)
	public ResponseEntity<Empleado> crearEmpleado (@RequestBody Empleado empleado)
	{
		Empleado nuevoEmpleado = empleadoDAO.save(empleado);
		
		return ResponseEntity.ok(nuevoEmpleado);
	}
	
	@DeleteMapping
	@RequestMapping(value = "empleado/{empleadoId}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarEmpleado(@PathVariable("empleadoId") Integer Id)
	{
		empleadoDAO.deleteById(Id);
		
		return ResponseEntity.ok(null);
	}
	
	

	@PutMapping
	@RequestMapping(value = "empleado" , method = RequestMethod.PUT)
	public ResponseEntity<Empleado> actualizarEmpleado(@RequestBody Empleado empleado)
	{
		//Devuelve un cliente
		//optional verfica si el objero contiene algun valor null
		Optional<Empleado> optionalEmpleado= empleadoDAO.findById(empleado.getIdEmpleado());
		
		if(optionalEmpleado.isPresent()) 
		{
			Empleado actualizaEmpleado= optionalEmpleado.get();
			actualizaEmpleado.setNombre(empleado.getNombre());
			actualizaEmpleado.setApellido(empleado.getApellido());
			actualizaEmpleado.setDireccion(empleado.getDireccion());
			actualizaEmpleado.setCargo(empleado.getCargo());
			empleadoDAO.save(actualizaEmpleado);
			
			return ResponseEntity.ok(actualizaEmpleado);
		} else {
			return ResponseEntity.noContent().build();
		}
		
		
	}
}

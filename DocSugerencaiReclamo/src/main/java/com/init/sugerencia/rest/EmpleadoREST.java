package com.init.sugerencia.rest;

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


import com.init.sugerencia.dao.EmpleadoDAO;
import com.init.sugerencia.entidad.Empleado;


@RestController
@RequestMapping("/")
public class EmpleadoREST {
	
	@Autowired
	private EmpleadoDAO EmpleadoDAO;

	@RequestMapping(value = "empleado" , method = RequestMethod.GET)
	public ResponseEntity<List<Empleado>> getEmpleado()
	{
	 
		List<Empleado> empleado =  EmpleadoDAO.findAll();
		
		return ResponseEntity.ok(empleado);
	
	}
	@RequestMapping(value = "empleado/{empleadoId}", method = RequestMethod.GET)
	public ResponseEntity<Empleado> getEmpleadoById(@PathVariable("empleadoId") int empleadoId)
	{
		Optional<Empleado> optionalEmpleado = EmpleadoDAO.findById(empleadoId);
		
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
		Empleado nuevoEmpleado = EmpleadoDAO.save(empleado);
		
		return ResponseEntity.ok(nuevoEmpleado);
	}
	
	@DeleteMapping
	@RequestMapping(value = "empleado/{empleadoId}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarEmpleado(@PathVariable("empleadoId") Integer Id)
	{
		EmpleadoDAO.deleteById(Id);
		
		return ResponseEntity.ok(null);
	}
	
	

	@PutMapping
	@RequestMapping(value = "empleado" , method = RequestMethod.PUT)
	public ResponseEntity<Empleado> actualizarEmpleado(@RequestBody Empleado empleado)
	{
	
		Optional<Empleado> optionalEmpleado= EmpleadoDAO.findById(empleado.getId_empleado());
		
		if(optionalEmpleado.isPresent()) 
		{
			Empleado actualizaEmpleado= optionalEmpleado.get();
			actualizaEmpleado.setNombre(empleado.getNombre());
			actualizaEmpleado.setApellido(empleado.getApellido());
			actualizaEmpleado.setDireccion(empleado.getDireccion());
			actualizaEmpleado.setCargo(empleado.getCargo());
			EmpleadoDAO.save(actualizaEmpleado);
			
			return ResponseEntity.ok(actualizaEmpleado);
		} else {
			return ResponseEntity.noContent().build();
		}
		
		
	}
	
	
}

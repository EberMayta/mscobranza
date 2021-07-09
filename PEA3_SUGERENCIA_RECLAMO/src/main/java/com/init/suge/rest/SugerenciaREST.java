package com.init.suge.rest;

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

import com.init.suge.dao.SugerenciaDAO;
import com.init.suge.entidad.Sugerencia;

@RestController
@RequestMapping("/")
public class SugerenciaREST {

	@Autowired
	public SugerenciaDAO sugerenciaDao;
	
	@RequestMapping(value = "sugerencia",method = RequestMethod.GET)
	public ResponseEntity<java.util.List<Sugerencia>> getSugerencia(){
			
		java.util.List<Sugerencia> sugerencia = sugerenciaDao.findAll();
		
		return ResponseEntity.ok(sugerencia);
	}
	
	@RequestMapping(value = "sugerencia/{sugerenciaId}", method = RequestMethod.GET)
	public ResponseEntity<Sugerencia> getSugerenciaById(@PathVariable("sugerenciaId") int sugerenciaId)
	{
		Optional<Sugerencia> optionalSugerencia= sugerenciaDao.findById(sugerenciaId);
		
		if(optionalSugerencia.isPresent()) 
		{
			return ResponseEntity.ok(optionalSugerencia.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	
	@PostMapping
	@RequestMapping(value = "sugerencia" , method = RequestMethod.POST)
	public ResponseEntity<Sugerencia> crearSugerencia(@RequestBody Sugerencia sugerencia)
	{
		Sugerencia nuevoSugerencia = sugerenciaDao.save(sugerencia);
		
		return ResponseEntity.ok(nuevoSugerencia);
	}
	
	
	
	@DeleteMapping
	@RequestMapping(value = "sugerencia/{sugerenciaId}" , method = RequestMethod.DELETE)
	public ResponseEntity<Sugerencia> eliminarSugerenica(@PathVariable("sugerenciaId") Integer Id)
	{
		sugerenciaDao.deleteById(Id);
		
		return ResponseEntity.ok(null);
	}
	
	

	@PutMapping
	@RequestMapping(value = "sugerencia" , method = RequestMethod.PUT)
	public ResponseEntity<Sugerencia> actualizarSugerencia(@RequestBody Sugerencia sugerencia)
	{
		
		Optional<Sugerencia> optionalSugerencia= sugerenciaDao.findById(sugerencia.getId_SP());
		
		if(optionalSugerencia.isPresent()) 
		{
			Sugerencia actualizaSugerencia= optionalSugerencia.get();
			actualizaSugerencia.setId_empleado(sugerencia.getId_empleado());
			actualizaSugerencia.setId_cliente(sugerencia.getId_cliente());
			actualizaSugerencia.setId_proveedor(sugerencia.getId_proveedor());
			actualizaSugerencia.setReclamo(sugerencia.getReclamo());
			actualizaSugerencia.setFechaReclamo(sugerencia.getFechaReclamo());
			sugerenciaDao.save(actualizaSugerencia);
			
			return ResponseEntity.ok(actualizaSugerencia);
		} else {
			return ResponseEntity.noContent().build();
		}
		
		
	}
 

}

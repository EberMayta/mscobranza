package com.init.cobranzas.rest;

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

import com.init.cobranzas.dao.DeudaDAO;
import com.init.cobranzas.entidad.Deudas;


@RestController
@RequestMapping("/")
public class DeudasREST {
	
	
	 @Autowired
		private DeudaDAO deudaDao;
		 
		 @RequestMapping(value = "deudas",method = RequestMethod.GET)
			public ResponseEntity<List<Deudas>> getDeudas()
			{
				List<Deudas> deudas= deudaDao.findAll();
				
				return ResponseEntity.ok(deudas);
			}
			
			@RequestMapping(value = "deudas/{deudasId}", method = RequestMethod.GET)
			public ResponseEntity<Deudas> getPagosById(@PathVariable("deudasId") int deudasId)
			{
				Optional<Deudas> optionalDeudas= deudaDao.findById(deudasId);
				
				if(optionalDeudas.isPresent()) 
				{
					return ResponseEntity.ok(optionalDeudas.get());
				} else {
					return ResponseEntity.noContent().build();
				}
			}
			
			@PostMapping
			@RequestMapping(value = "deudas" , method = RequestMethod.POST)
			public ResponseEntity<Deudas> crearDeudas(@RequestBody Deudas deudas)
			{
				Deudas nuevaDeuda = deudaDao.save(deudas);
				
				return ResponseEntity.ok(nuevaDeuda);
			}
			
			@DeleteMapping
			@RequestMapping(value = "deudas/{deudasId}" , method = RequestMethod.DELETE)
			public ResponseEntity<Void> eliminarDeudas(@PathVariable("deudasId") Integer Id)
			{
				deudaDao.deleteById(Id);
				
				return ResponseEntity.ok(null);
			}
			
			

			@PutMapping
			@RequestMapping(value = "deudas" , method = RequestMethod.PUT)
			public ResponseEntity<Deudas> actualizarDeudas(@RequestBody Deudas deudas)
			{
				Optional<Deudas> optionalDeudas= deudaDao.findById(deudas.getID_Deuda());
				
				if(optionalDeudas.isPresent()) 
				{
					Deudas actualizaDeudas= optionalDeudas.get();
					actualizaDeudas.setDescripDeuda(deudas.getDescripDeuda());
					actualizaDeudas.setNomCliente(deudas.getNomCliente());
					actualizaDeudas.setMonDeuda(deudas.getMonDeuda());
					actualizaDeudas.setFecDeuda(deudas.getFecDeuda());
					deudaDao.save(actualizaDeudas);
					
					return ResponseEntity.ok(actualizaDeudas);
				} else {
					return ResponseEntity.noContent().build();
				}
				
				
			}

}

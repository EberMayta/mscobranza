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

import com.init.cobranzas.dao.PagoDAO;
import com.init.cobranzas.entidad.Pagos;


@RestController
@RequestMapping("/")
public class PagosREST {

	 @Autowired
	private PagoDAO pagodao;
	 
	 @RequestMapping(value = "pagos",method = RequestMethod.GET)
		public ResponseEntity<List<Pagos>> getPagos()
		{
			List<Pagos> detallepagos = pagodao.findAll();
			
			return ResponseEntity.ok(detallepagos);
		}
		
		@RequestMapping(value = "pagos/{pagosId}", method = RequestMethod.GET)
		public ResponseEntity<Pagos> getPagosById(@PathVariable("pagosId") int pagosId)
		{
			Optional<Pagos> optionalPagos= pagodao.findById(pagosId);
			
			if(optionalPagos.isPresent()) 
			{
				return ResponseEntity.ok(optionalPagos.get());
			} else {
				return ResponseEntity.noContent().build();
			}
		}
		
		@PostMapping
		@RequestMapping(value = "pagos" , method = RequestMethod.POST)
		public ResponseEntity<Pagos> crearDetalleCompraP(@RequestBody Pagos pagos)
		{
			Pagos nuevoPago = pagodao.save(pagos);
			
			return ResponseEntity.ok(nuevoPago);
		}
		
		@DeleteMapping
		@RequestMapping(value = "pagos/{pagosId}" , method = RequestMethod.DELETE)
		public ResponseEntity<Void> eliminarPagos(@PathVariable("pagosId") Integer Id)
		{
			pagodao.deleteById(Id);
			
			return ResponseEntity.ok(null);
		}
		
		

		@PutMapping
		@RequestMapping(value = "pagos" , method = RequestMethod.PUT)
		public ResponseEntity<Pagos> actualizarPagos(@RequestBody Pagos pagos)
		{
			Optional<Pagos> optionalPagos = pagodao.findById(pagos.getID_Pago());
			
			if(optionalPagos.isPresent()) 
			{
				Pagos actualizaPagos= optionalPagos.get();
				actualizaPagos.setNomCliente(pagos.getNomCliente());
				actualizaPagos.setDniCliente(pagos.getDniCliente());
				actualizaPagos.setMonPago(pagos.getMonPago());
				actualizaPagos.setFecPago(pagos.getFecPago());
				pagodao.save(actualizaPagos);
				
				return ResponseEntity.ok(actualizaPagos);
			} else {
				return ResponseEntity.noContent().build();
			}
			
			
		}
}

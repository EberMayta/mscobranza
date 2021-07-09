package com.init.suge.rest;

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

import com.init.suge.dao.ClienteDAO;
import com.init.suge.entidad.Cliente;



@RestController
@RequestMapping("/")
public class ClienteREST {

	@Autowired
	private ClienteDAO ClienteDAO;

	@RequestMapping(value = "cliente" , method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> getCliente()
	{
	 
		List<Cliente> cliente =  ClienteDAO.findAll();
		
		return ResponseEntity.ok(cliente);
	
	}
	
	@RequestMapping(value = "cliente/{clienteId}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> getClienteById(@PathVariable("clienteId") int clienteId)
	{
		Optional<Cliente> optionalCliente = ClienteDAO.findById(clienteId);
		
		if(optionalCliente.isPresent()) 
		{
			return ResponseEntity.ok(optionalCliente.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	@RequestMapping(value = "cliente" , method = RequestMethod.POST)
	public ResponseEntity<Cliente> crearCliente (@RequestBody Cliente cliente)
	{
		Cliente nuevoCliente = ClienteDAO.save(cliente);
		
		return ResponseEntity.ok(nuevoCliente);
	}
	
	@DeleteMapping
	@RequestMapping(value = "cliente/{clienteId}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarCliente(@PathVariable("clienteId") Integer Id)
	{
		ClienteDAO.deleteById(Id);
			
		return ResponseEntity.ok(null);
	}
	
	

	@PutMapping
	@RequestMapping(value = "cliente" , method = RequestMethod.PUT)
	public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente)
	{
	
		Optional<Cliente> optionalCliente= ClienteDAO.findById(cliente.getId_cliente());
		
		if(optionalCliente.isPresent()) 
		{
			Cliente actualizarCliente= optionalCliente.get();
			actualizarCliente.setNombre(cliente.getNombre());
			actualizarCliente.setApellidos(cliente.getApellidos());
			actualizarCliente.setSexo(cliente.getSexo());
			actualizarCliente.setFecha_Nac(cliente.getFecha_Nac());
			actualizarCliente.setDireccion(cliente.getDireccion());
			actualizarCliente.setTelefono(cliente.getTelefono());
			ClienteDAO.save(actualizarCliente);
			
			return ResponseEntity.ok(actualizarCliente);
		} else {
			return ResponseEntity.noContent().build();
		}
		
		
	}
}

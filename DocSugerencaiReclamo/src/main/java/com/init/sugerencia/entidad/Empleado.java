package com.init.sugerencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.models.auth.In;

@Entity
@Table(name="Empleado")
public class Empleado {

	@Id
	@Column(name="id_empleado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_empleado; 
	private String Nombre;
	private String Apellido;
	private String Direccion;
	private String Cargo;
	
	
	
	public Integer getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}
	
	

}

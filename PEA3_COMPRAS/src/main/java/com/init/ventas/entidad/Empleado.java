package com.init.ventas.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Empleado")
public class Empleado {
	
	@Id
	@Column(name="IdEmpleado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdEmpleado; 
	private String Nombre;
	private String Apellido;
	private String Direccion;
	private String Cargo;
	
	
	public int getIdEmpleado() {
		return IdEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		IdEmpleado = idEmpleado;
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

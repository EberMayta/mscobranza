	package com.init.ventas.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Proveedor")
public class Proveedor {
	
	@Id
	@Column(name="IdProveedor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int IdProveedor;
	
	@Column(name="Nombre", nullable=false, length = 100)
	private String Nombre;
	@Column(name="Apellido", nullable=false, length = 100)
	private String Apellido;
	@Column(name="Direccion", nullable=false, length = 100)
	private String Direccion;
	@Column(name="Celular", nullable=false, length = 100)
	private int Celular;
	

	public int getIdProveedor() {
		return IdProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		IdProveedor = idProveedor;
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
	public int getCelular() {
		return Celular;
	}
	public void setCelular(int celular) {
		Celular = celular;
	}
	
	
	
}

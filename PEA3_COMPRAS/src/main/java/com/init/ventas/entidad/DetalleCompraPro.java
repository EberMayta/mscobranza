package com.init.ventas.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DetalleCompraPro")
public class DetalleCompraPro {

	@Id
	@Column(name="IdDetalle")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdDetalle;
	
	@ManyToOne
	@JoinColumn(name = "IdOrdenC")
	private OrdenCompra IdOrdenC;
	
	@ManyToOne
	@JoinColumn(name = "IdProducto")
	private Productos IdProducto;
	private String Descripcion;
	


	public int getIdDetalle() {
		return IdDetalle;
	}
	public void setIdDetalle(int idDetalle) {
		IdDetalle = idDetalle;
	}
	public OrdenCompra getIdOrdenC() {
		return IdOrdenC;
	}
	public void setIdOrdenC(OrdenCompra idOrdenC) {
		IdOrdenC = idOrdenC;
	}
	public Productos getIdProducto() {
		return IdProducto;
	}
	public void setIdProducto(Productos idProducto) {
		IdProducto = idProducto;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
	
}

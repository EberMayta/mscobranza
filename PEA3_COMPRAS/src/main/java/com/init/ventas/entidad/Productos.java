package com.init.ventas.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Productos")
public class Productos {
	
	@Id
	@Column(name="IdProducto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private int IdProducto;
	private String NombreP;
	private String DescripcionP;
	private double PrecioPxU;
	private int cantidad;
	
	
	public int getIdProducto() {
		return IdProducto;
	}
	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}
	public String getNombreP() {
		return NombreP;
	}
	public void setNombreP(String nombreP) {
		NombreP = nombreP;
	}
	public String getDescripcionP() {
		return DescripcionP;
	}
	public void setDescripcionP(String descripcionP) {
		DescripcionP = descripcionP;
	}
	public double getPrecioPxU() {
		return PrecioPxU;
	}
	public void setPrecioPxU(double precioPxU) {
		PrecioPxU = precioPxU;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}	
	
	

}

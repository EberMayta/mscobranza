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
@Table(name="OrdenCompra")
public class OrdenCompra {
	
	@Id
	@Column(name="IdOrdenC")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdOrdenC;

	@ManyToOne
	@JoinColumn(name = "IdProveedor")
	private Proveedor IdProveedor;
	
	@ManyToOne
	@JoinColumn(name = "IdEmpleado")
	private Empleado IdEmpleado;
	
	private String DescripcionOC;
	private String fehcaDescrip;
	
	

	public int getIdOrdenC() {
		return IdOrdenC;
	}
	public void setIdOrdenC(int idOrdenC) {
		IdOrdenC = idOrdenC;
	}
	public Proveedor getIdProveedor() {
		return IdProveedor;
	}
	public void setIdProveedor(Proveedor idProveedor) {
		IdProveedor = idProveedor;
	}
	public Empleado getIdEmpleado() {
		return IdEmpleado;
	}
	public void setIdEmpleado(Empleado idEmpleado) {
		IdEmpleado = idEmpleado;
	}
	public String getDescripcionOC() {
		return DescripcionOC;
	}
	public void setDescripcionOC(String descripcionOC) {
		DescripcionOC = descripcionOC;
	}
	public String getFehcaDescrip() {
		return fehcaDescrip;
	}
	public void setFehcaDescrip(String fehcaDescrip) {
		this.fehcaDescrip = fehcaDescrip;
	}
	
	
}

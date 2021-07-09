package com.init.cobranzas.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Detalle_Cobranza")
public class DetalleCobranza {

	@Id
	@Column(name="id_dc")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id_dc;
	
	@ManyToOne
	@JoinColumn(name = "ID_Pago")
	private Pagos ID_Pago;
	
	@ManyToOne
	@JoinColumn(name = "ID_Deuda")
	private Deudas ID_Deuda;
	private String descripcion;
	public int getId_dc() {
		return id_dc;
	}
	public void setId_dc(int id_dc) {
		this.id_dc = id_dc;
	}
	public Pagos getID_Pago() {
		return ID_Pago;
	}
	public void setID_Pago(Pagos iD_Pago) {
		ID_Pago = iD_Pago;
	}
	public Deudas getID_Deuda() {
		return ID_Deuda;
	}
	public void setID_Deuda(Deudas iD_Deuda) {
		ID_Deuda = iD_Deuda;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
}

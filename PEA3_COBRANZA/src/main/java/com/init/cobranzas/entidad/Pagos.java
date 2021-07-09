package com.init.cobranzas.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Pago")
public class Pagos {
	
	@Id
	@Column(name="ID_Pago")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Pago;
	private String nomCliente;
	private Integer DniCliente;
	private Integer monPago;
	private String fecPago;
	

	public int getID_Pago() {
		return ID_Pago;
	}
	public void setID_Pago(int iD_Pago) {
		ID_Pago = iD_Pago;
	}
	public String getNomCliente() {
		return nomCliente;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public Integer getDniCliente() {
		return DniCliente;
	}
	public void setDniCliente(Integer dniCliente) {
		DniCliente = dniCliente;
	}
	public Integer getMonPago() {
		return monPago;
	}
	public void setMonPago(Integer monPago) {
		this.monPago = monPago;
	}
	public String getFecPago() {
		return fecPago;
	}
	public void setFecPago(String fecPago) {
		this.fecPago = fecPago;
	}
	

}

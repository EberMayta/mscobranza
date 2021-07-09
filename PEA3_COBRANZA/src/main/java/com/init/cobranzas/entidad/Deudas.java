package com.init.cobranzas.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Deuda")
public class Deudas {
	
	@Id
	@Column(name="ID_Deuda")
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private int ID_Deuda;
	private String descripDeuda;
	private String nomCliente;
	private Integer monDeuda;
	private String  fecDeuda;


	public int getID_Deuda() {
		return ID_Deuda;
	}

	public void setID_Deuda(int iD_Deuda) {
		ID_Deuda = iD_Deuda;
	}

	public String getDescripDeuda() {
		return descripDeuda;
	}

	public void setDescripDeuda(String descripDeuda) {
		this.descripDeuda = descripDeuda;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public Integer getMonDeuda() {
		return monDeuda;
	}

	public void setMonDeuda(Integer monDeuda) {
		this.monDeuda = monDeuda;
	}

	public String getFecDeuda() {
		return fecDeuda;
	}

	public void setFecDeuda(String fecDeuda) {
		this.fecDeuda = fecDeuda;
	}
	
}

package com.init.sugerencia.entidad;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Doc_Sugerencia_Reclamo")
public class Sugerencia {
	@Id
	@Column(name="Id_SP")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id_SP;

	
	@ManyToOne
	@JoinColumn(name = "id_empleado")
	private Empleado id_empleado;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private Proveedor id_proveedor;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente id_cliente;
	
	private String Reclamo;
	
	private String fechaReclamo;

	public int getId_SP() {
		return Id_SP;
	}

	public void setId_SP(Integer id_SP) {
		Id_SP = id_SP;
	}

	public Empleado getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Empleado id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Proveedor getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Proveedor id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public Cliente getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getReclamo() {
		return Reclamo;
	}

	public void setReclamo(String reclamo) {
		Reclamo = reclamo;
	}

	public String getFechaReclamo() {
		return fechaReclamo;
	}

	public void setFechaReclamo(String  fechaReclamo) {
		this.fechaReclamo = fechaReclamo;
	}
	
	
}

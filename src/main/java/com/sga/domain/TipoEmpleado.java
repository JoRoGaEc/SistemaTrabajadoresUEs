package com.sga.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipoempleado")
public class TipoEmpleado {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="codigo")
	private String codigo;
	

	//OJO CON SOLO QUE ESTE ESTE EN EAGER NO ELIMINA LOS EMPLEADOS, PODEMOS HACER UNA PRUEBA
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "tipoEmpleado",cascade = CascadeType.ALL)
	private List<Empleado> empleados;
	

	public TipoEmpleado() {
		super();
	}

	public TipoEmpleado(int id, String tipo, String codigo) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.codigo = codigo;
	}

	public TipoEmpleado(int id) {
		this.id = id;
	}
	
	public TipoEmpleado (String id) {
		this.id = Integer.parseInt(id);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return this.codigo;
	}
	
	
}

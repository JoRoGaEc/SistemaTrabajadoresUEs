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
@Table(name="tipopension")
public class TipoPension {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="codigo")
	private String codigo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPension" , fetch = FetchType.LAZY)
	private List<Pension> pensiones;


	//INICIO CONSTRUCTORES
	public TipoPension(int id) {
		super();
		this.id = id;
	}

	public TipoPension() {
		super();
	}
	//FIN CONSTRUCTORES	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Pension> getPensiones() {
		return pensiones;
	}

	public void setPensiones(List<Pension> pensiones) {
		this.pensiones = pensiones;
	}

	@Override
	public String toString() {
		return String.valueOf(this.id);
	}
	
}

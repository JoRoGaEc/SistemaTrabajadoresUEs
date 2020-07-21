package com.sga.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pension")
@NamedQuery(name="Pension.findAll", query="SELECT p FROM Pension p")
public class Pension {

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="monto")
	private int periodo;
	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "empleado_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_pension_empleado"))
	private Empleado empleado;
	
	
	@JoinColumn(name = "tipopension_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_pension_tipopension"))
	@ManyToOne(fetch = FetchType.LAZY)
	private TipoPension tipoPension;
	
	
	public Pension(Empleado empleado, TipoPension tipoPension) {
		this.empleado  = empleado;
		this.tipoPension =  tipoPension;
	}
	
	public Pension() {
		super();
	}


	public Pension(int id, int periodo, Empleado empleado, TipoPension tipoPension) {
		super();
		this.id = id;
		this.periodo = periodo;
		this.empleado = empleado;
		this.tipoPension = tipoPension;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public int getPeriodo() {
		return periodo;
	}



	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}



	public Empleado getEmpleado() {
		return empleado;
	}



	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}



	public TipoPension getTipoPension() {
		return tipoPension;
	}



	public void setTipoPension(TipoPension tipoPension) {
		this.tipoPension = tipoPension;
	}


	
	
}

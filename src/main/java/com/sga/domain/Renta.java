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
import javax.persistence.Table;

@Entity
@Table(name="renta")
public class Renta {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="monto")
	private float monto;
	
	@Column(name="mes")
	private String mes;
	
	@Column(name="anio")
	private String anio;
	
	
	@Column(name="tiene_historico")
	private boolean tieneHistorico;
	
	@Column(name="monto_previo")
	private float montoPrevio;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "empleado_id" , referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_renta_empleado"))
	private Empleado empleado;

	
	public Renta() {
		super();
	}
	public Renta(int id, float monto, String mes, String anio, boolean tieneHistorico, float montoPrevio,
			Empleado empleado) {
		super();
		this.id = id;
		this.monto = monto;
		this.mes = mes;
		this.anio = anio;
		this.tieneHistorico = tieneHistorico;
		this.montoPrevio = montoPrevio;
		this.empleado = empleado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public boolean isTieneHistorico() {
		return tieneHistorico;
	}
	public void setTieneHistorico(boolean tieneHistorico) {
		this.tieneHistorico = tieneHistorico;
	}
	public float getMontoPrevio() {
		return montoPrevio;
	}
	public void setMontoPrevio(float montoPrevio) {
		this.montoPrevio = montoPrevio;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	
	@Override
	public String toString() {
		return "Renta [id=" + id + ", monto=" + monto + ", mes=" + mes + ", anio=" + anio + ", tieneHistorico="
				+ tieneHistorico + ", montoPrevio=" + montoPrevio;
	}


	
	
	
}

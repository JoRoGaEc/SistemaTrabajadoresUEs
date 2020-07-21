package com.sga.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="porcentaje")
public class Porcentaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="porcsegurosocial")
	private float porcSeguroSocial;
	
	@Column(name="porcsegurovida")
	private float porcSeguroVida;
	
	@Column(name="porcbm")
	private float porcBM;
	
	

	public Porcentaje() {
		super();
	}



	public Porcentaje(int id, float porcSeguroSocial, float porcSeguroVida, float porcBM) {
		super();
		this.id = id;
		this.porcSeguroSocial = porcSeguroSocial;
		this.porcSeguroVida = porcSeguroVida;
		this.porcBM = porcBM;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public float getPorcSeguroSocial() {
		return porcSeguroSocial;
	}



	public void setPorcSeguroSocial(float porcSeguroSocial) {
		this.porcSeguroSocial = porcSeguroSocial;
	}



	public float getPorcSeguroVida() {
		return porcSeguroVida;
	}



	public void setPorcSeguroVida(float porcSeguroVida) {
		this.porcSeguroVida = porcSeguroVida;
	}



	public float getPorcBM() {
		return porcBM;
	}



	public void setPorcBM(float porcBM) {
		this.porcBM = porcBM;
	}



	@Override
	public String toString() {
		return "Porcentaje [id=" + id + ", porcSeguroSocial=" + porcSeguroSocial + ", porcSeguroVida=" + porcSeguroVida
				+ ", porcBM=" + porcBM + "]";
	}



   
	
	
	
	
}

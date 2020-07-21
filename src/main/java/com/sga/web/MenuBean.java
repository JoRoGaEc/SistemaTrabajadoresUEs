package com.sga.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("menuBean")
@RequestScoped
public class MenuBean {

	
	public String listadoEmpleados() {
		return "/empleados/listaEmpleados" + "?faces-redirect=true";
	}
	
	public String listaTipoEmpleados() {
		return "/tipoempleados/listaTipoEmpleados"+ "?faces-redirect=true";
	}
	
	public String listaTipoPensiones() {
		return "/tipopensiones/listaTipoPensiones"+ "?faces-redirect=true";
	}
	
	public String bonificacion() {
		
		return "/pagos/bonificacion"+ "?faces-redirect=true";
	}
	
	public String pagoAguinaldo() {
		return "/pagos/pagoAguinaldo"+ "?faces-redirect=true";
		
	}
	
	
	public String pagoEspecial() {
		return "/pagos/pagoEspecial"+ "?faces-redirect=true";
	}
	
	
	public String pagoNormal() {
		return "/pagos/pagoNormal"+ "?faces-redirect=true";
	}
}

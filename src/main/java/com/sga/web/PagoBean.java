package com.sga.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named("pagoBean")
@RequestScoped
public class PagoBean {

	private boolean empleadoSeleccionado ;
	private int idEmpSel;
	
	@PostConstruct
	public void inicializar() {
		PrimeFaces.current().executeScript("document.getElementById('_idPagoEmp2').style.display = 'none';");
		empleadoSeleccionado =  false;
	}

	public boolean isEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}

	public void setEmpleadoSeleccionado(boolean empleadoSeleccionado) {
		this.empleadoSeleccionado = empleadoSeleccionado;
	}
	
	public void onEmpleadoChange() {
		System.out.println("Esto imprime idEmpSel " + idEmpSel);
		if(idEmpSel!=0) {
			empleadoSeleccionado = true;
			PrimeFaces.current().executeScript("document.getElementById('_idPagoEmp2').style.display = 'block';");

		}else {
			empleadoSeleccionado = false;
			PrimeFaces.current().executeScript("document.getElementById('_idPagoEmp2').style.display = 'none';");
		}
	}

	public int getIdEmpSel() {
		return idEmpSel;
	}

	public void setIdEmpSel(int idEmpSel) {
		this.idEmpSel = idEmpSel;
	}

	
	
	
}

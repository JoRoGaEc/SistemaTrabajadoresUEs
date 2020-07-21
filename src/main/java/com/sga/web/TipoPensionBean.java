package com.sga.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import com.sga.domain.TipoPension;
import com.sga.services.TipoPensionService;

@Named("tipoPensionBean")
@RequestScoped
public class TipoPensionBean {

	@Inject
	private TipoPensionService tipoPensionService;
	
	private TipoPension tipoPensionSeleccionada;
	
	private List<TipoPension> tipoPensiones;

	public TipoPensionBean() {
		super();
	}

	@PostConstruct
	public void inicializar() {
		tipoPensiones  =  tipoPensionService.listarTipoPensiones();
		tipoPensionSeleccionada = new TipoPension();
		
	}
	
	//1. Editar
	public void editListener(RowEditEvent event) {
		this.tipoPensionSeleccionada =(TipoPension) event.getObject();
		this.tipoPensionService.actualizarTipoPension(this.tipoPensionSeleccionada);
		
	}
	
	//2. Para crear tipo de pension
	//2.1 Reiniciar el objeto de TipoPension
	public void reiniciarTipoPensionSeleccionada() {
		this.tipoPensionSeleccionada =  new TipoPension();
	}
	//2.2 Agregar registro
	public void agregarTipoPension() {
		this.tipoPensionService.insertarTipoPension(this.tipoPensionSeleccionada);
		this.tipoPensiones.add(this.tipoPensionSeleccionada);
		this.tipoPensionSeleccionada = null;
		
	}
	
	//3.Eliminar 
	public void eliminarTipoPension() {
		this.tipoPensionService.eliminarTipoPension(this.tipoPensionSeleccionada);
		this.tipoPensiones.remove(this.tipoPensionSeleccionada);
		this.tipoPensionSeleccionada = null;
	}

	
	
	//GETTERS AND SETTERS
	public TipoPension getTipoPensionSeleccionada() {
		return tipoPensionSeleccionada;
	}

	public void setTipoPensionSeleccionada(TipoPension tipoPensionSeleccionada) {
		this.tipoPensionSeleccionada = tipoPensionSeleccionada;
	}

	public List<TipoPension> getTipoPensiones() {
		return tipoPensiones;
	}

	public void setTipoPensiones(List<TipoPension> tipoPensiones) {
		this.tipoPensiones = tipoPensiones;
	}	
	
	
}

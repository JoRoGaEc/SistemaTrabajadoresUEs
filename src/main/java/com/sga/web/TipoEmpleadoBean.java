package com.sga.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import com.sga.domain.TipoEmpleado;
import com.sga.services.TipoEmpleadoService;

@Named("tipoEmpleadoBean")
@RequestScoped
public class TipoEmpleadoBean {

	@Inject
	private TipoEmpleadoService tipoEmpleadoService;
	
	private TipoEmpleado tipoEmpleadoSeleccionado;
	
	private List<TipoEmpleado> tipoEmpleados;
	
	public TipoEmpleadoBean() {
		
	}
	
	@PostConstruct
	public void inicializar() {
		tipoEmpleados = tipoEmpleadoService.listarTipoEmpleados();
		tipoEmpleadoSeleccionado =  new TipoEmpleado();
		
	}
	
	
	//1. Editar
	public void editListener(RowEditEvent event) {
		TipoEmpleado tipoEmpleado  = (TipoEmpleado) event.getObject();
		tipoEmpleadoService.actualizarEmpleado(tipoEmpleado);
	}
	
	//2. Para crear el empleado
	//2.1 Reiniciar el tipoEmpleadoSeleccionado
	public void reiniciarTipoEmpleadoSeleccionado() {
		this.tipoEmpleadoSeleccionado =  new TipoEmpleado();
	}
	
	//2.2 Agregar registro
	public void agregarTipoEmpleado() {
		this.tipoEmpleadoService.insertarTipoEmpleado(this.tipoEmpleadoSeleccionado);
		this.tipoEmpleados.add(tipoEmpleadoSeleccionado);
		this.tipoEmpleadoSeleccionado = null;
	}
	
	//3.Eliminar
	public void eliminarTipoEmpleado() {
		this.tipoEmpleadoService.eliminarTipoEmpleado(this.tipoEmpleadoSeleccionado);
		this.tipoEmpleados.remove(this.tipoEmpleadoSeleccionado);
		this.tipoEmpleadoSeleccionado = null;
		
	}

	public TipoEmpleado getTipoEmpleadoSeleccionado() {
		return tipoEmpleadoSeleccionado;
	}

	public void setTipoEmpleadoSeleccionado(TipoEmpleado tipoEmpleadoSeleccionado) {
		this.tipoEmpleadoSeleccionado = tipoEmpleadoSeleccionado;
	}

	public List<TipoEmpleado> getTipoEmpleados() {
		return tipoEmpleados;
	}

	public void setTipoEmpleados(List<TipoEmpleado> tipoEmpleados) {
		this.tipoEmpleados = tipoEmpleados;
	}
	
	
	
	
	
}

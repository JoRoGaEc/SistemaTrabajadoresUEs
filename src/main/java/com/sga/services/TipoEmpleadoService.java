package com.sga.services;

import java.util.List;

import com.sga.domain.TipoEmpleado;

public interface TipoEmpleadoService {
	
	public abstract List<TipoEmpleado> listarTipoEmpleados();
	
	public abstract TipoEmpleado buscarTipoEmpleadoById(TipoEmpleado tipoEmpleado);
	
	public abstract void insertarTipoEmpleado(TipoEmpleado tipoEmpleado);
	
	public abstract void actualizarEmpleado(TipoEmpleado tipoEmpleado);
	
	public abstract void eliminarTipoEmpleado(TipoEmpleado tipoEmpleado);
	
	
	
}

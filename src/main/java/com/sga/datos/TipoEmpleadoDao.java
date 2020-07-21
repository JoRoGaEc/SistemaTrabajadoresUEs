package com.sga.datos;

import java.util.List;

import com.sga.domain.TipoEmpleado;

public interface TipoEmpleadoDao {

	
	public abstract List<TipoEmpleado> listarTipoEmpleados();
	
	public abstract TipoEmpleado buscarTipoEmpleadoById(TipoEmpleado tipoEmpleado);
	
	public abstract void insertarTipoEmpleado(TipoEmpleado tipoEmpleado);
	
	public abstract void actualizarEmpleado(TipoEmpleado tipoEmpleado);
	
	public abstract void eliminarTipoEmpleado(TipoEmpleado tipoEmpleado);
	
	
	
}

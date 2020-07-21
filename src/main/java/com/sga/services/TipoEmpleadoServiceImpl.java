package com.sga.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.sga.datos.TipoEmpleadoDao;
import com.sga.domain.TipoEmpleado;

@Stateless
public class TipoEmpleadoServiceImpl implements TipoEmpleadoService{

	@Inject
	private TipoEmpleadoDao tipoEmpleadoDao;
	
	
	@Override
	public List<TipoEmpleado> listarTipoEmpleados() {
		return tipoEmpleadoDao.listarTipoEmpleados();
	}

	@Override
	public TipoEmpleado buscarTipoEmpleadoById(TipoEmpleado tipoEmpleado) {
		
		return tipoEmpleadoDao.buscarTipoEmpleadoById(tipoEmpleado);
	}

	@Override
	public void insertarTipoEmpleado(TipoEmpleado tipoEmpleado) {
		tipoEmpleadoDao.insertarTipoEmpleado(tipoEmpleado);
		
	}

	@Override
	public void actualizarEmpleado(TipoEmpleado tipoEmpleado) {
		tipoEmpleadoDao.actualizarEmpleado(tipoEmpleado);
		
	}

	@Override
	public void eliminarTipoEmpleado(TipoEmpleado tipoEmpleado) {
		tipoEmpleadoDao.eliminarTipoEmpleado(tipoEmpleado);
		
	}

}

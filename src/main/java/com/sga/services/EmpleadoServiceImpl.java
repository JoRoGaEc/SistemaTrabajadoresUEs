package com.sga.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.sga.datos.EmpleadoDao;
import com.sga.domain.Empleado;

@Stateless
public class EmpleadoServiceImpl implements EmpleadoService{

	@Inject
	private EmpleadoDao empleadoDao;
	
	@Override
	public List<Empleado> listaEmpleados() {
		return empleadoDao.findAllEmpleados();
	}

	@Override
	public Empleado encontrarEmpleadoPorId(Empleado empleado) {
		return empleadoDao.findEmpleadoById(empleado);
	}

	@Override
	public Empleado encontrarEmpleadoPorEmail(Empleado empleado) {
		return empleadoDao.findEmpleadoByNit(empleado);
	}

	@Override
	public Empleado registrarEmpleado(Empleado empleado) {
		return empleadoDao.insertEmpleado(empleado);
		
	}

	@Override
	public void modificarEmpleado(Empleado empleado) {
		empleadoDao.updateEmpleado(empleado);
		
	}

	@Override
	public void eliminarEmpleado(Empleado empleado) {
		empleadoDao.deleteEmpleado(empleado);
		
	}

}

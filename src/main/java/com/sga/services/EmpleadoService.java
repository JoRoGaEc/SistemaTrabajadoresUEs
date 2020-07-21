package com.sga.services;

import java.util.List;

import com.sga.domain.Empleado;

public interface EmpleadoService {

	public List<Empleado> listaEmpleados();
	
	public Empleado encontrarEmpleadoPorId(Empleado empleado);
	
	public Empleado encontrarEmpleadoPorEmail(Empleado empleado);
	
	public Empleado registrarEmpleado(Empleado empleado);
	
	public void modificarEmpleado(Empleado empleado);
	
	public void eliminarEmpleado(Empleado empleado);
}

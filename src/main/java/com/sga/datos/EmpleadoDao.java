package com.sga.datos;

import java.util.List;

import com.sga.domain.Empleado;

public interface EmpleadoDao {
	public List<Empleado> findAllEmpleados();
	
	public Empleado findEmpleadoById(Empleado empleado);
	
	public Empleado findEmpleadoByNit(Empleado empleado);
	
	public Empleado insertEmpleado(Empleado empleado);
	
	public void updateEmpleado(Empleado empleado);
	
	public void deleteEmpleado(Empleado empleado);
}

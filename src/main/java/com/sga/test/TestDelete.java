package com.sga.test;

import com.sga.domain.Empleado;
import com.sga.domain.TipoEmpleado;
import com.sga.services.EmpleadoService;
import com.sga.services.EmpleadoServiceImpl;

public class TestDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmpleadoService es =  new EmpleadoServiceImpl();
		es.eliminarEmpleado(new Empleado(1));
	}

}

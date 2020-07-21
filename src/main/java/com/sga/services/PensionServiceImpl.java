package com.sga.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.sga.datos.PensionDao;
import com.sga.domain.Empleado;
import com.sga.domain.Pension;
import com.sga.domain.TipoPension;

@Stateless
public class PensionServiceImpl implements PensionService{

	@Inject
	private PensionDao pensionDao;
	
	@Override
	public int guardarDatosPension(Pension pension) {
		pensionDao.guardarDatosPension(pension);
		return 0;
	}

	
}

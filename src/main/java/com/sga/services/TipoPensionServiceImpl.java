package com.sga.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.sga.datos.TipoPensionDao;
import com.sga.domain.TipoPension;

@Stateless
public class TipoPensionServiceImpl implements TipoPensionService{

	@Inject
	private TipoPensionDao tipoPensionDao;
	
	@Override
	public List<TipoPension> listarTipoPensiones() {
		return tipoPensionDao.listarTipoPensiones();
	}

	@Override
	public TipoPension buscarTipoPensionById(TipoPension tipoPension) {
		return tipoPensionDao.buscarrTipoPensionById(tipoPension);
	}

	@Override
	public void insertarTipoPension(TipoPension tipoPension) {
		tipoPensionDao.insertarTipoPension(tipoPension);
		
	}

	@Override
	public void actualizarTipoPension(TipoPension tipoPension) {
		tipoPensionDao.actualizarTipoPension(tipoPension);
		
	}

	@Override
	public void eliminarTipoPension(TipoPension tipoPension) {
		tipoPensionDao.eliminarTipoPension(tipoPension);
		
	}


	
}

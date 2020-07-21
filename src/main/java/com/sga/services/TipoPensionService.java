package com.sga.services;

import java.util.List;

import com.sga.domain.TipoPension;

public interface TipoPensionService {
	
	public abstract List<TipoPension> listarTipoPensiones();
	
	public abstract TipoPension buscarTipoPensionById(TipoPension tipoPension);
	
	public abstract void insertarTipoPension(TipoPension tipoPension);
	
	public abstract void actualizarTipoPension(TipoPension tipoPension);
	
	public abstract void eliminarTipoPension(TipoPension tipoPension);
	
}

package com.sga.datos;

import java.util.List;

import com.sga.domain.TipoPension;

public interface TipoPensionDao {

	public abstract List<TipoPension> listarTipoPensiones();
	
	public abstract TipoPension buscarrTipoPensionById(TipoPension tipoPension);
	
	public void insertarTipoPension(TipoPension tipoPension);
	
	public void actualizarTipoPension(TipoPension tipoPension);
	
	public void eliminarTipoPension(TipoPension tipoPension);
	
}

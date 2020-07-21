package com.sga.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sga.constant.ConstantesPath;
import com.sga.domain.TipoPension;

@Stateless
public class TipoPensionDaoImpl implements TipoPensionDao{

	@PersistenceContext(unitName = ConstantesPath.UNIDAD_PERSISTENCIA)
	EntityManager em;
	
	@Override
	public List<TipoPension> listarTipoPensiones() {
		Query q  =  em.createQuery("SELECT tp FROM TipoPension tp");
		return q.getResultList();
	}

	@Override
	public TipoPension buscarrTipoPensionById(TipoPension tipoPension) {
		return em.find(TipoPension.class, tipoPension.getId());
	}

	@Override
	public void insertarTipoPension(TipoPension tipoPension) {
		em.persist(tipoPension);
	}

	@Override
	public void actualizarTipoPension(TipoPension tipoPension) {
		em.merge(tipoPension);
	}

	@Override
	public void eliminarTipoPension(TipoPension tipoPension) {
		em.remove(em.merge(tipoPension));
		
	}

}

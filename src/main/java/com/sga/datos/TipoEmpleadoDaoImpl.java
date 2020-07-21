package com.sga.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sga.constant.ConstantesPath;
import com.sga.domain.TipoEmpleado;

@Stateless
public class TipoEmpleadoDaoImpl implements TipoEmpleadoDao{

	@PersistenceContext(unitName = ConstantesPath.UNIDAD_PERSISTENCIA)
	EntityManager em;
	
	
	
	@Override
	public List<TipoEmpleado> listarTipoEmpleados() {
		Query q = em.createQuery("SELECT te FROM TipoEmpleado te ");		
		return q.getResultList();
	}

	@Override
	public TipoEmpleado buscarTipoEmpleadoById(TipoEmpleado tipoEmpleado) {
		return em.find(TipoEmpleado.class, tipoEmpleado.getId());
	}

	@Override
	public void insertarTipoEmpleado(TipoEmpleado tipoEmpleado) {
		em.persist(tipoEmpleado);
		
	}

	@Override
	public void actualizarEmpleado(TipoEmpleado tipoEmpleado) {
		em.merge(tipoEmpleado);
		
	}

	@Override
	public void eliminarTipoEmpleado(TipoEmpleado tipoEmpleado) {
		em.remove(em.merge(tipoEmpleado));
		
	}

}

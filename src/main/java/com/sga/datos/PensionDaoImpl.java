package com.sga.datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sga.constant.ConstantesPath;
import com.sga.domain.Empleado;
import com.sga.domain.Pension;
import com.sga.domain.TipoPension;

@Stateless
public class PensionDaoImpl implements PensionDao{

	@PersistenceContext(unitName = ConstantesPath.UNIDAD_PERSISTENCIA)
	EntityManager em;
	
	@Override 
	public int guardarDatosPension(Pension pension) {
		em.persist(pension);	
		return 0;
	}
}

package com.sga.datos;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sga.constant.ConstantesPath;
import com.sga.domain.Empleado;

@Stateless
public class EmpleadoDaoImpl implements EmpleadoDao{

	@PersistenceContext(unitName = ConstantesPath.UNIDAD_PERSISTENCIA)
	EntityManager em;
	
	
	@Override
	public List<Empleado> findAllEmpleados() {
		Query q = em.createQuery("SELECT e FROM Empleado e");
		return q.getResultList();
	}

	@Override
	public Empleado findEmpleadoById(Empleado empleado) {
		return em.find(Empleado.class, empleado.getId());
	}

	@Override
	public Empleado findEmpleadoByNit(Empleado empleado) {
		Query q  =  em.createQuery("from Empleado e WHERE e.nit  = :nit");
		q.setParameter("nit", empleado.getNit());
	
		return (Empleado) q.getSingleResult(); 
	}

	@Override
	public Empleado insertEmpleado(Empleado empleado) {
		 em.persist(empleado);
		 em.flush();
		 System.out.println("Este es el ID del empleado que se crea " + empleado.getId());
		 return empleado;
	}

	@Override
	public void updateEmpleado(Empleado empleado) {
		em.merge(empleado);
		
	}

	@Override
	public void deleteEmpleado(Empleado empleado) {
//		Query q =  em.createQuery("delete from Empleado e where e.id = ?1");
//		q.setParameter(1, empleado.getId());
//		q.executeUpdate();	
		em.remove(em.merge(empleado));
	}

}

package com.sga.datos;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sga.constant.ConstantesPath;
import com.sga.domain.Usuario;

@Stateless
public class LoginDAOImpl implements LoginDAO {

	@PersistenceContext(unitName = ConstantesPath.UNIDAD_PERSISTENCIA)
	EntityManager em;

	@Override
	public boolean validate(String user, String password) {
		Query q = em.createQuery("Select u from Usuario u where u.username= ?1 and password = ?2");
		q.setParameter(1, user);
		q.setParameter(2, password);
		
		//System.out.println("usuarioDb "  + usuarioDb);
		if( q.getResultList().isEmpty()) {
			System.out.println("El getResult esta vacio");
			return false;

		}else {
			System.out.println("El getResult NO esta vaciio");
			return true;
		}
	

	}
}

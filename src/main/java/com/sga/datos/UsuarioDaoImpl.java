package com.sga.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sga.constant.ConstantesPath;
import com.sga.domain.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao {
	
	@PersistenceContext(unitName = ConstantesPath.UNIDAD_PERSISTENCIA)
	EntityManager em;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllUsuarios() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Usuario.findAll").getResultList();
	}

	@Override
	public Usuario findById(Usuario usuario) {
		// TODO Auto-generated method stub
		return em.find(Usuario.class, usuario.getIdUsuario());
	}

	@Override
	public Usuario findByUsername(Usuario usuario) {
		// TODO Auto-generated method stub
		Query q =  em.createQuery("from Usuario u where u.username = :username");
		q.setParameter("username", usuario.getUsername());
		return (Usuario)q.getSingleResult();
	}

	@Override
	public void insertUsuario(Usuario usuario) {
		em.persist(usuario);
		
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		em.merge(usuario);
		
	}

	@Override
	public void deletUsuario(Usuario usuario) {
		em.remove(em.merge(usuario));
		
	}

}

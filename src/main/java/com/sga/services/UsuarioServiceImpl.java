package com.sga.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.sga.datos.UsuarioDao;
import com.sga.domain.Usuario;

@Stateless
public class UsuarioServiceImpl implements UsuarioService{
	
	@Inject
	UsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> listaUsuarios() {
		// TODO Auto-generated method stub
		return usuarioDao.findAllUsuarios();
	}

	@Override
	public Usuario buscarUsuarioPorId(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(usuario);
	}

	@Override
	public void insertarUsuario(Usuario usuario) {
		usuarioDao.insertUsuario(usuario);
		
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		usuarioDao.updateUsuario(usuario);
		
	}

	@Override
	public void borrarUsuario(Usuario usuario) {
		usuarioDao.deletUsuario(usuario);
		
	}

	
	
}

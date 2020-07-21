package com.sga.services;

import java.util.List;

import javax.ejb.Local;

import com.sga.domain.Usuario;

@Local
public interface UsuarioService {

	public List<Usuario> listaUsuarios();
	
	public Usuario buscarUsuarioPorId(Usuario usuario);
	
	public void insertarUsuario(Usuario usuario);
	
	public void actualizarUsuario(Usuario usuario);
	
	public void borrarUsuario(Usuario usuario);
	
}

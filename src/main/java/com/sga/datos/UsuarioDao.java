package com.sga.datos;

import java.util.List;

import com.sga.domain.Usuario;

public interface UsuarioDao {

	public List<Usuario> findAllUsuarios();
	
	public Usuario findById(Usuario usuario);
	
	public Usuario findByUsername(Usuario usuario);
	
	public void insertUsuario(Usuario usuario);
	
	public void updateUsuario(Usuario usuario);
	
	public void deletUsuario(Usuario usuario);
	
	
}

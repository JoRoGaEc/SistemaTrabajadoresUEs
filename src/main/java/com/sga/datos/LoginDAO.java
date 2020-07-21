package com.sga.datos;

public interface LoginDAO {

	public boolean validate(String user, String password);
  	//En los metodos abstractos no se coloca cuerpo, estos metodos en las interfaces por defecto son public abstract
}

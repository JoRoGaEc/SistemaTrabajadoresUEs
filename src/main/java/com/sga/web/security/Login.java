package com.sga.web.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sga.datos.LoginDAO;
import com.sga.datos.LoginDAOImpl;

import javax.faces.application.FacesMessage;

@Named("login")
@SessionScoped
public class Login implements Serializable{

private static final long serialVersionUID = 1094801825228386363L;
	
	@Inject
	private LoginDAO loginDao;
	

	private String pwd;
	private String msg;
	private String user;
    private String mensajeCredencial;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String getMensajeCredencial() {
		return mensajeCredencial;
	}

	public void setMensajeCredencial(String mensajeCredencial) {
		this.mensajeCredencial = mensajeCredencial;
	}

	//validate login
	public String validateUsernamePassword() {
		boolean valid = loginDao.validate(user, pwd);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);
			return "/empleados/listaEmpleados" + "?faces-redirect=true";
		} else {
			System.out.println("He ingresado al Else del metodo de validar ");
			mensajeCredencial = "Credenciales Incorrectas";
			FacesContext.getCurrentInstance().addMessage(
					  null,
					  new FacesMessage(FacesMessage.SEVERITY_WARN,"Usuario Incorrecto","Por favor ingresa las credenciales correctas")
					);
			return "login" + "?faces-redirect=true";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		System.out.println("ESTOY INGRESANDO AL METODO PARA DESLOGUEARME");
		//return "login";
		return "login"+ "?faces-redirect=true";
	}
	
	
}

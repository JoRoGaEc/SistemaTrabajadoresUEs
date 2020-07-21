package com.sga.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import com.sga.domain.Empleado;
import com.sga.domain.Pension;
import com.sga.domain.TipoEmpleado;
import com.sga.domain.TipoPension;
import com.sga.services.EmpleadoService;
import com.sga.services.PensionService;
import com.sga.services.TipoEmpleadoService;
import com.sga.services.TipoPensionService;

@Named("empleadoBean")
@RequestScoped
public class EmpleadoBean{
	static Logger logger = LogManager.getLogger();
	
	@Inject
	private EmpleadoService empleadoService;
	@Inject
	private TipoEmpleadoService tipoEmpleadoService;
	
	@Inject
	private TipoPensionService  tipoPensionService;
	
	@Inject
	private PensionService pensionService;
	
	
	private Empleado empleadoSeleccionado;
	private List<Empleado> empleados;
	private Pension pensionSeleccionada;
	
	//Esto debido a la relacion
	private List<TipoEmpleado> tipoEmpleados;
	private String idTipoEmpleadoString; //El SelectOne porque el pasa los objetos o los datos como cadenas
	private int idTipoEmpleado;
	private TipoEmpleado tipoEmpleadoSeleccionado;
	
	//esto para el tipo de pension
	private int idTipoPension;
	private List<TipoPension> tipoPensiones;
	
	
	public EmpleadoBean() {
		
	}
	
	
	@PostConstruct
	public void inicializar() {
		empleados  = empleadoService.listaEmpleados();
		tipoEmpleados = tipoEmpleadoService.listarTipoEmpleados();
		empleadoSeleccionado  =  new Empleado();
		tipoEmpleadoSeleccionado =  new TipoEmpleado();
		pensionSeleccionada =  new Pension();
		tipoPensiones  = tipoPensionService.listarTipoPensiones();
		System.out.println("Esto es lo que recupere del tipo de pensiones"  + tipoEmpleados);
	}
	
	//----------------- METODOS PARA EL CRUD-------------------
	//1. Para modficar usando las bondades de Primefaces en conjunto con el Bean
	public void editListener(RowEditEvent event) {
		//Esto se puede hacer gracias a... 
       /*    
        <p:column headerText="Opciones " style="width: 50px">
          <p:rowEditor/>
        </p:column>
        <p:ajax event="rowEdit" listener="#{personaBean.editListener}"/>
		*/
		
		Empleado empleado  =  (Empleado) event.getObject();
		empleadoService.modificarEmpleado(empleado);
		
	}
	//3. Agregar
    public void agregarEmpleado(){
    	//Los datos se setean en empleadoSeleccionado cuando enviamos el formulario con el commandButton
    	//Luego se lo pasamos aqui por parametro al metodo de la interfaz service inyectada    	
    	this.empleadoSeleccionado.setTipoEmpleado(new TipoEmpleado(idTipoEmpleado));
    	Empleado empleado = this.empleadoService.registrarEmpleado(this.empleadoSeleccionado);
    	if(empleado != null ) {
    		pensionSeleccionada.setEmpleado(empleado);
    		pensionSeleccionada.setTipoPension(new TipoPension(idTipoPension));
    		pensionService.guardarDatosPension(pensionSeleccionada);
    	}
    	//Aqui vamos a crear un objeto de tipo pension con el idEmpleado y el idTipoPension
    	this.empleados.add(this.empleadoSeleccionado);   	   	
    	this.empleadoSeleccionado = null;
    }
    
    //4. Eliminar persona
    public void eliminarEmpleado(){
    	this.empleadoService.eliminarEmpleado(empleadoSeleccionado);
    	System.out.println("Este empleado se eliminara " + this.empleadoService);
    	this.empleados.remove(this.empleadoSeleccionado);
    	this.empleadoSeleccionado = null;
    }

	//2.
	public void reiniciarEmpleadoSeleccionado() {
		//Esto para quitarle cualquier dato que ya tenga
		//Luego de ejecutarse esto se abre el modal para crear el empleado
		 this.empleadoSeleccionado = new Empleado();
	}
	
	
	//GETTER Y SETTERS

	public Empleado getEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}


	public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
		this.empleadoSeleccionado = empleadoSeleccionado;
	}


	public List<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}


	public List<TipoEmpleado> getTipoEmpleados() {
		return tipoEmpleados;
	}


	public void setTipoEmpleados(List<TipoEmpleado> tipoEmpleados) {
		this.tipoEmpleados = tipoEmpleados;
	}


	public int getIdTipoEmpleado() {
		return idTipoEmpleado;
	}


	public void setIdTipoEmpleado(int idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}


	public TipoEmpleado getTipoEmpleadoSeleccionado() {
		return tipoEmpleadoSeleccionado;
	}


	public void setTipoEmpleadoSeleccionado(TipoEmpleado tipoEmpleadoSeleccionado) {
		this.tipoEmpleadoSeleccionado = tipoEmpleadoSeleccionado;
	}


	public String getIdTipoEmpleadoString() {
		return idTipoEmpleadoString;
	}


	public void setIdTipoEmpleadoString(String idTipoEmpleadoString) {
		this.idTipoEmpleadoString = idTipoEmpleadoString;
	}


	public int getIdTipoPension() {
		return idTipoPension;
	}


	public void setIdTipoPension(int idTipoPension) {
		this.idTipoPension = idTipoPension;
	}


	public List<TipoPension> getTipoPensiones() {
		return tipoPensiones;
	}


	public void setTipoPensiones(List<TipoPension> tipoPensiones) {
		this.tipoPensiones = tipoPensiones;
	}


	public Pension getPensionSeleccionada() {
		return pensionSeleccionada;
	}


	public void setPensionSeleccionada(Pension pensionSeleccionada) {
		this.pensionSeleccionada = pensionSeleccionada;
	}

	
	

	
}

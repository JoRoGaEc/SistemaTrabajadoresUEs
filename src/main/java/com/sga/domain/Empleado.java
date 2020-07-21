package com.sga.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="empleado")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado{

;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="nit")
	private String nit;
	
	//Esto por la relacion
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "empleado")
	private List<Pension> listaSeguros; //
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="empleado", cascade = CascadeType.ALL)
	private List<Renta> listaRentas; //
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "tipoempleado_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empleado_tipoempleado"))
	private TipoEmpleado tipoEmpleado;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "empleado")
	private List<BienestarMagisterial> bienestarMagisterial ;
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "empleado")
	private List<Pago> pagos ;
	
	
	@OneToOne(fetch = FetchType.LAZY , mappedBy = "empleado", cascade = CascadeType.ALL)
	private Pension pension;
	
	
	public Empleado() {
		super();
	}

	
	
	public Empleado(int id) {
		super();
		this.id = id;
	}



	public Empleado(int id, String nombre, String apellido, String nit, TipoEmpleado tipoEmpleado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nit = nit;
		this.tipoEmpleado = tipoEmpleado;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	@Override
	public String toString() {
	    return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}
		
	
}

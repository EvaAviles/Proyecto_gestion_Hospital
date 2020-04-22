package model;

import java.util.Date;

public class Suministro {

	//Atributos
	private Boolean suministro=false; //Por defecto el suministro no se ha realizado
	private Date fechaSuministroR;//Es la fecha en la que se ha realizado el suministro
	private Date fechaSuministroL;//Es la fecha en la que se debe realizar el suministro

	//Relaciones
	private Unidad unidad;
	private Receta receta;
	private Enfermero enfermero;
	private Paciente paciente;
	
	//Getters y setters
	public Boolean getSuministro() {
		return suministro;
	}

	public void setSuministro(Boolean suministro) {
		this.suministro = suministro;
	}

	public Date getFechaSuministroR() {
		return fechaSuministroR;
	}

	public void setFechaSuministro(Date fechaSuministro) {
		this.fechaSuministroR = fechaSuministro;
	}
	
	public Date getFechaSuministroL() {
		return fechaSuministroL;
	}

	public void setFechaSuministroL(Date fechaSuministroL) {
		this.fechaSuministroL = fechaSuministroL;
	}


	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public Enfermero getEnfermero() {
		return enfermero;
	}

	public void setEnfermero(Enfermero enfermero) {
		this.enfermero = enfermero;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public void crearSuministro (Date fechaSuministroL, Unidad unidad, Receta receta, Paciente paciente) {
		//Asignamos el paciente
		setPaciente(paciente);
		//Asignamos el enfermero
		setEnfermero(paciente.getEnfermero());//Asignaremos el enfermero asociado a ese paciente :)
		//Asignamos la receta
		setReceta(receta);
		//Asignamos la unidad
		setUnidad(unidad);
		//Asignamos la fechaSuministroL
		setFechaSuministroL(fechaSuministroL);
	}
	
	//Métodos
	public static void suministrarUnidad() {
		//Cuando se suministra la unidad, se borra la unidad, ya que ya no nos hace falta
	
		
		//setSuministro(true);
		//Se debe eliminar la unidad de la lista de unidades
		//Lo que ocurre también, es que debemos contabilizar ese consumo en el día específico
		//Para ello hacemos uso de la clase RegistroConsumo
		
	}
}

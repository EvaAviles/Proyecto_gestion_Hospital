package model;

import java.util.Date;

public class Suministro {

	//Atributos
	private Boolean suministro=false; //Por defecto el suministro no se ha realizado
	private Date horaSuministro;
	private Date fechaSuministro;

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

	public Date getHoraSuministro() {
		return horaSuministro;
	}

	public void setHoraSuministro(Date horaSuministro) {
		this.horaSuministro = horaSuministro;
	}

	public Date getFechaSuministro() {
		return fechaSuministro;
	}

	public void setFechaSuministro(Date fechaSuministro) {
		this.fechaSuministro = fechaSuministro;
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
	
	//Métodos
	public static void suministrarUnidad() {

	}
}

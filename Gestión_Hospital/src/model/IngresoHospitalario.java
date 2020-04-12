package model;

import java.util.Date;

public class IngresoHospitalario {

	//Atributos
	private Date fechaIngreso;
	private Date fechaAlta;
	private String motivo;
	
	//Relaciones
	private Paciente paciente;
	private Cama cama;
	private Especialidad Especialidad;
	
	//Getters y setters
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Cama getCama() {
		return cama;
	}

	public void setCama(Cama cama) {
		this.cama = cama;
	}

	public Especialidad getEspecialidad() {
		return Especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		Especialidad = especialidad;
	}
	
	//Métodos
	public static void crearIngreso() {
		
	}

	public static void finalizarIngreso() {
		
	}
	
}

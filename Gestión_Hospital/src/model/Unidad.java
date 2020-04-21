package model;

import java.util.Date;

public class Unidad {

	private Date fechaCaducidad;
	private String identificador;
	private Boolean disponible=true; //Por defecto, una unidad está disponible

	//Relaciones
	private Suministro suministro;
	private Medicamento medicamento;

	//Getters y setters
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Suministro getSuministro() {
		return suministro;
	}

	public void setSuministro(Suministro suministro) {
		this.suministro = suministro;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}



	//Métodos
	public static void avisoCaducidad() {

	}



	


}

package model;

import java.util.Date;

public class Unidad {

	private Date fechaCaducidad;
	private Long identificador;
	
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

	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
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
	
	//Métodos
	public static void avisoCaducidad() {

	}

	
}

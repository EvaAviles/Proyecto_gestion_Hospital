package model;

import java.util.Date;

public class Unidad {

	private Date fechaCaducidad;
	private String identificador;
	
	//Relaciones
	private Suministro suministro;
	private Medicamento medicamento;
	
	//Métodos
	public static void avisoCaducidad() {

	}
}

package model;

import java.util.Date;

public class Receta {

	private Date fechaCreada;
	private Date horaCreada;
	private String descripcion;
	private int numeroDosis;
	private int intervaloHoras;

	//Relaciones 
	private Medico medico;
	private Paciente Paciente;
	private Suministro listaSuministros;
	private Medicamento Medicamento;

	//Métodos
	public static void crearReceta() {

	}
	public static void eliminarReceta() {

	}
	public static void comprobarAlergías() {

	}
}

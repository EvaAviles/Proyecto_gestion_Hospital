package model;

import java.util.Date;

public class Paciente {

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private int edad;
	private Date fechaNacimiento;
	private char sexo;
	private Double altura;
	private Double peso;
	private String grupoSanguineo;
	private String historialMedico;
	private String observacionesNotas;
	private String antecedentesFamiliares;

	//Relaciones
	private Enfermero enfermero;
	private Alergia listaAlergias[];
	private Suministro listaSuministros[];
	private Receta listaRecetas[];
	private IngresoHospitalario listaIngresos[];
	private Medico medicoCabecera;
	
	//Métodos
	public static void editarFichaPaciente() {

	}
	public static void verFichaPaciente() {

	}
	public static void exportarFichaPaciente() {

	}
	public static void añadirPaciente() {

	}
	
	public String getNombre() {
		return nombre;
	}
}

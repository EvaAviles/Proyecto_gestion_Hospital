package model;

import java.util.Date;

public class IngresoHospitalario {

	private Date fechaIngreso;
	private Date fechaAlta;
	private String motivo;
	
	//Relaciones
	private Paciente paciente;
	private Cama cama;
	private Especialidad Especialidad;
	
	//M�todos
	public static void crearIngreso() {
		
	}
	
	public static void finalizarIngreso() {
		
	}
	
}

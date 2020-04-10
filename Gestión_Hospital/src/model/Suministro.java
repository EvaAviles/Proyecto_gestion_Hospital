package model;

public class Suministro {

	private Boolean suministro=false; //Por defecto el suministro no se ha realizado
	private Date horaSuministro;
	private Date fechaSuministro;

	//Relaciones
	private Unidad unidad;
	private Receta receta;
	private Enfermero enfermero;
	private Paciente paciente;
	
	//Métodos
	public static void suministrarUnidad() {

	}
}

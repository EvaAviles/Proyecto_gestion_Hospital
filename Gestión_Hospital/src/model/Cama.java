package model;

public class Cama {
	
	//Atributos
	private Boolean ocupada = false; //Por defecto una cama está desocupada
	
	//Relaciones
	private IngresoHospitalario ingreso;
	private Habitacion habitacion;
	
	//Getters y setters
	public Boolean getOcupada() {
		return ocupada;
	}

	public void setOcupada(Boolean ocupada) {
		this.ocupada = ocupada;
	}

	public IngresoHospitalario getIngreso() {
		return ingreso;
	}

	public void setIngreso(IngresoHospitalario ingreso) {
		this.ingreso = ingreso;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	//Métodos
	public static void ocuparCama(Paciente p) {
		
		
	}
	
	public static void desocuparCama() {
		
		
	}
	


}

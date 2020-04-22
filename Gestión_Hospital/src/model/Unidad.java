package model;

import java.util.Date;

public class Unidad implements Comparable<Unidad>{

	private Date fechaCaducidad;
	private Boolean disponible=true;

	//Relaciones
	private Medicamento medicamento;
	private Suministro suministro;

	//Getters y setters
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
	public Suministro getSuministro() {
		return suministro;
	}

	public void setSuministro(Suministro suministro) {
		this.suministro = suministro;
	}

	@Override
	public int compareTo(Unidad o) {//Comparamos las fechas
		if (getFechaCaducidad().after(o.getFechaCaducidad())) {
			return -1;
		}else if(getFechaCaducidad().before(o.getFechaCaducidad())) {
			return 1;
		}else {//Son iguales
			return 0;
		}
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	

	//Métodos

	public void avisoCaducidad() {
		
	}


	


}

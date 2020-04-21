package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Habitacion implements Serializable{

	//ID Memoria Persistente
	private static final long serialVersionUID = -7417514178536884514L;
	
	//Atributos
	private String nombre;
	private int planta;
	private int camasLibres;
	private int camasOcupadas;
	
	//Relaciones
	private ArrayList <Cama> listaCamas= new ArrayList<>();
	private Especialidad especialidad;
	
	//Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPlanta() {
		return planta;
	}
	public void setPlanta(int planta) {
		this.planta = planta;
	}
	public int getCamasLibres() {
		return camasLibres;
	}
	public void setCamasLibres(int camasLibres) {
		this.camasLibres = camasLibres;
	}
	public int getCamasOcupadas() {
		return camasOcupadas;
	}
	public void setCamasOcupadas(int camasOcupadas) {
		this.camasOcupadas = camasOcupadas;
	}
	public ArrayList<Cama> getListaCamas() {
		return listaCamas;
	}
	public void setListaCamas(ArrayList<Cama> listaCamas) {
		this.listaCamas = listaCamas;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	
	
}

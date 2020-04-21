package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Especialidad implements Serializable {
	
	//ID Memoria persistente
	private static final long serialVersionUID = -3291350776525045543L;

	private String nombre;
	
	//Relaciones
	private ArrayList <Usuario> listaUsuarios= new ArrayList<>();
	private ArrayList <IngresoHospitalario> listaIngresos= new ArrayList<>();
	private ArrayList <Habitacion> listaHabitaciones= new ArrayList<>();
	
	//Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public ArrayList<IngresoHospitalario> getListaIngresos() {
		return listaIngresos;
	}
	public void setListaIngresos(ArrayList<IngresoHospitalario> listaIngresos) {
		this.listaIngresos = listaIngresos;
	}
	public ArrayList<Habitacion> getListaHabitaciones() {
		return listaHabitaciones;
	}
	public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}

	//Métodos

}

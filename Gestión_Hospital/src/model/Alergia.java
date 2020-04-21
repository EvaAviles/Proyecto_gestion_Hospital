package model;

import java.io.Serializable;

public class Alergia implements Serializable{
	
	//ID para la memoria persistente
	private static final long serialVersionUID = 1240621521273875237L;
	
	//Atributos
	private String sintomas;
	private String nombre;
	
	//Getters y setters
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

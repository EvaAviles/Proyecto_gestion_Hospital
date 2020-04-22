package model;

import java.io.Serializable;

public class Alergia implements Serializable, Comparable<Alergia>{
	
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
	
	@Override
	public int compareTo(Alergia o) {
		if (!getNombre().equals(o.getNombre())) {
			return 1;//Si sale 1 - no coinciden los nombres
		} else {
			return 0;//Si sale 0 - coinciden los nombres
		}
	}
	
}

package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Medico extends Usuario implements Serializable{

	
	//ID Memoria Persistente
	private static final long serialVersionUID = 5008925907637094901L;
	
	//Relaciones
	private ArrayList <Paciente>listaPacientes= new ArrayList<>();
	private ArrayList <Receta>listaRecetas= new ArrayList<>();
	
	//Getters y setters
	public ArrayList<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public ArrayList<Receta> getListaRecetas() {
		return listaRecetas;
	}

	public void setListaRecetas(ArrayList<Receta> listaRecetas) {
		this.listaRecetas = listaRecetas;
	}
	
	//Métodos
	public static void interfazMedico() {

	}
	
	public Medico(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

}

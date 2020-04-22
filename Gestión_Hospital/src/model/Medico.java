package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Medico extends Usuario implements Serializable{

	
	//ID Memoria Persistente
	private static final long serialVersionUID = 5008925907637094901L;
	
	//Relaciones
	protected ArrayList <Paciente>listaPacientes= new ArrayList<>();
	protected ArrayList <Receta>listaRecetas= new ArrayList<>();
	
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
	
	public void añadirReceta(Receta r) {
		listaRecetas.add(r);
	}
	
	public void añadirPaciente (Paciente p) {
		listaPacientes.add(p);
	}
	//Métodos
	public static void interfazMedico() {

	}
	
	public Medico(String login, String password) {
		super(login, password);

	}
	
	public static void recetarMedicamento() {
		
	}

}

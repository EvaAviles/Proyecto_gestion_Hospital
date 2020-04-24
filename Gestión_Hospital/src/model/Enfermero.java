package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Enfermero extends Usuario implements Serializable{

	//ID memoria persistente
	private static final long serialVersionUID = 7629219017707154796L;
	private int generadorID=0;

	//Relaciones
	protected ArrayList <Paciente>listaPacientes= new ArrayList<>();
	protected ArrayList <Suministro> listaSuministros= new ArrayList<>();


	//Getters y setters
	public int getGeneradorID() {
		return generadorID;
	}

	public void incrementarID() {
		generadorID=generadorID+1;
	}

	public void setGeneradorID(int generadorID) {
		this.generadorID = generadorID;
	}

	public ArrayList<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public ArrayList<Suministro> getListaSuministros() {
		return listaSuministros;
	}

	public void setListaSuministros(ArrayList<Suministro> listaSuministros) {
		this.listaSuministros = listaSuministros;
	}

	public void añadirPaciente (Paciente p) {
		listaPacientes.add(p);
	}

	public void añadirSuministro(Suministro s) {
		listaSuministros.add(s);
	}

	//Métodos
	public static void interfazEnfermero() {

	}

	public void mostrarListaSuministrosPendientes() {
		//Ordenamos la lista de suministros
		Collections.sort(listaSuministros);
		for (Suministro s: listaSuministros) {
			if (s.getSuministro()==false) {//Si no se ha realizado el suministro...
				s.toString();
			}
		}
	}


	public Enfermero(String login, String pass) {
		super(login, pass);
	}

	public static void suministrarUnidad () {
		//Le pedimos el ID al enfermero
		
		//Cuando se ha realizado el suministro hay que cambiarlo a true
		
	}




}

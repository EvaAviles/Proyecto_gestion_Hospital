package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Enfermero extends Usuario implements Serializable{

	//ID memoria persistente
	private static final long serialVersionUID = 7629219017707154796L;
	
	//Relaciones
	private ArrayList <Paciente>listaPacientes= new ArrayList<>();
	private ArrayList <Suministro> listaSuministros= new ArrayList<>();
	
	//Getters y setters
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

	//Métodos
	public static void interfazEnfermero() {

	}
	
	public Enfermero(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	


}

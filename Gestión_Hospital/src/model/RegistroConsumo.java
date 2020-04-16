package model;

import java.util.ArrayList;
import java.util.Date;

public class RegistroConsumo {

	//Atributos
	private Date fechaConsumo;
	private int unidadesConsumidas;

	//Relaciones
	private Medicamento medicamento;
	private ArrayList <Suministro> listaSuministros= new ArrayList<>();

	//Getters y setters
	public Date getFechaConsumo() {
		return fechaConsumo;
	}

	public void setFechaConsumo(Date fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}

	public int getUnidadesConsumidas() {
		return unidadesConsumidas;
	}

	public void setUnidadesConsumidas(int unidadesConsumidas) {
		this.unidadesConsumidas = unidadesConsumidas;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public ArrayList<Suministro> getListaSuministros() {
		return listaSuministros;
	}

	public void setListaSuministros(ArrayList<Suministro> listaSuministros) {
		this.listaSuministros = listaSuministros;
	}
	
	public void añadirSuministro(Suministro s) {
		listaSuministros.add(s);
	}
	
	//Métodos
	public void añadirConsumicion(int unidades) {
		this.unidadesConsumidas = unidades+unidadesConsumidas;
	}
	

	
}

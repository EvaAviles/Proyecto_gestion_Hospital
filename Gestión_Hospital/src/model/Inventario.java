package model;

import java.io.Serializable;

public class Inventario implements Serializable{

	//ID Memoria Persistente
	private static final long serialVersionUID = -5080105661226545452L;
	
	//Relaciones
	private Medicamento medicamento;
	
	//Getters y setters
	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	//Métodos
	public static void exportarInformeInventario() {

	}

	public static void mostrarInventario() {

	}

	public static void enviarInventarioMail() {

	}


	
}

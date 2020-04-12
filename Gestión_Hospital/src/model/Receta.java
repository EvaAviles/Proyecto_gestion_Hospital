package model;

import java.util.ArrayList;
import java.util.Date;

public class Receta {

	//Atributos
	private Date fechaCreada;
	private Date horaCreada;
	private String descripcion;
	private int numeroDosis;
	private int intervaloHoras;

	//Relaciones 
	private Medico medico;
	private Paciente Paciente;
	private ArrayList <Suministro> listaSuministros= new ArrayList<>();
	private Medicamento Medicamento;

	//Getters y setters
	public Date getFechaCreada() {
		return fechaCreada;
	}
	public void setFechaCreada(Date fechaCreada) {
		this.fechaCreada = fechaCreada;
	}
	public Date getHoraCreada() {
		return horaCreada;
	}
	public void setHoraCreada(Date horaCreada) {
		this.horaCreada = horaCreada;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNumeroDosis() {
		return numeroDosis;
	}
	public void setNumeroDosis(int numeroDosis) {
		this.numeroDosis = numeroDosis;
	}
	public int getIntervaloHoras() {
		return intervaloHoras;
	}
	public void setIntervaloHoras(int intervaloHoras) {
		this.intervaloHoras = intervaloHoras;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return Paciente;
	}
	public void setPaciente(Paciente paciente) {
		Paciente = paciente;
	}
	public ArrayList<Suministro> getListaSuministros() {
		return listaSuministros;
	}
	public void setListaSuministros(ArrayList<Suministro> listaSuministros) {
		this.listaSuministros = listaSuministros;
	}
	public Medicamento getMedicamento() {
		return Medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		Medicamento = medicamento;
	}
	//Métodos
	public static void crearReceta() {

	}
	public static void eliminarReceta() {

	}
	public static void comprobarAlergías() {

	}
}

package model;

import java.util.ArrayList;
import java.util.Date;

public class Paciente {

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private int edad;
	private Date fechaNacimiento;
	private char sexo;
	private Double altura;
	private Double peso;
	private String grupoSanguineo;
	private String historialMedico;
	private String observacionesNotas;
	private String antecedentesFamiliares;

	//Relaciones
	private Enfermero enfermero;
	private ArrayList <Alergia> listaAlergias= new ArrayList<>();
	private ArrayList <Suministro> listaSuministros= new ArrayList<>();
	private ArrayList <Receta> listaRecetas= new ArrayList<>();
	private ArrayList <IngresoHospitalario> listaIngresos= new ArrayList<>();
	private Medico medicoCabecera;
	
	public Paciente(String string) {
		this.nombre=string;
	}
	//Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}
	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}
	public String getHistorialMedico() {
		return historialMedico;
	}
	public void setHistorialMedico(String historialMedico) {
		this.historialMedico = historialMedico;
	}
	public String getObservacionesNotas() {
		return observacionesNotas;
	}
	public void setObservacionesNotas(String observacionesNotas) {
		this.observacionesNotas = observacionesNotas;
	}
	public String getAntecedentesFamiliares() {
		return antecedentesFamiliares;
	}
	public void setAntecedentesFamiliares(String antecedentesFamiliares) {
		this.antecedentesFamiliares = antecedentesFamiliares;
	}
	public Enfermero getEnfermero() {
		return enfermero;
	}
	public void setEnfermero(Enfermero enfermero) {
		this.enfermero = enfermero;
	}
	public ArrayList<Alergia> getListaAlergias() {
		return listaAlergias;
	}
	public void setListaAlergias(ArrayList<Alergia> listaAlergias) {
		this.listaAlergias = listaAlergias;
	}
	public ArrayList<Suministro> getListaSuministros() {
		return listaSuministros;
	}
	public void setListaSuministros(ArrayList<Suministro> listaSuministros) {
		this.listaSuministros = listaSuministros;
	}
	public ArrayList<Receta> getListaRecetas() {
		return listaRecetas;
	}
	public void setListaRecetas(ArrayList<Receta> listaRecetas) {
		this.listaRecetas = listaRecetas;
	}
	public ArrayList<IngresoHospitalario> getListaIngresos() {
		return listaIngresos;
	}
	public void setListaIngresos(ArrayList<IngresoHospitalario> listaIngresos) {
		this.listaIngresos = listaIngresos;
	}
	public Medico getMedicoCabecera() {
		return medicoCabecera;
	}
	public void setMedicoCabecera(Medico medicoCabecera) {
		this.medicoCabecera = medicoCabecera;
	}
	
	//Métodos
	public static void editarFichaPaciente() {
	}
	
	public static void verFichaPaciente() {

	}
	public static void exportarFichaPaciente() {

	}
	public static void añadirPaciente() {

	}
	
	
}

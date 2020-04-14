package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Paciente {

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private int edad;
	private CharSequence fechaNacimiento;
	private String sexo;// H o M
	private int altura;//en cm
	private int peso;//en kg
	private String grupoSanguineo;
	private String historialMedico;
	private String observacionesNotas;
	private String antecedentesFamiliares;
	private String telefono;
	private String habitacion;

	//Relaciones
	private Enfermero enfermero;
	private ArrayList <Alergia> listaAlergias= new ArrayList<>();
	private ArrayList <Suministro> listaSuministros= new ArrayList<>();
	private ArrayList <Receta> listaRecetas= new ArrayList<>();
	private ArrayList <IngresoHospitalario> listaIngresos= new ArrayList<>();
	private Medico medicoCabecera;



	//Constructores de Paciente
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
	public CharSequence getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(CharSequence fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
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
	public void printAlergias() { 
		//Recorremos arrayList e imprimimos alergias
		for(int i=0;i<listaAlergias.size();i++) {
			System.out.println(listaAlergias.get(i));
			System.out.println(", ");
		}
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
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}

	public void actualizarEdad() {
		//A partir de la fecha de Nacimiento calculamos la edad, de esta forma podemos ir actualizando.
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse((CharSequence) fechaNacimiento, fmt);
		LocalDate ahora = LocalDate.now();
		//Comparamos la fecha de nacimiento con la fecha actual
		Period periodo = Period.between(fechaNac, ahora);
		setEdad(periodo.getYears());
	}

	//Métodos
	public static void editarFichaPaciente() {
	}

	public static void mostrarFichaPaciente(Paciente p) {
		System.out.println(
				"Nombre: "+p.getNombre()+
				"Apellidos: "+p.getApellido1()+" "+ p.getApellido2()+
				"/nDNI: "+ p.getDni()+
				"/nEdad: "+ p.getEdad()+
				"/nFecha de nacimiento" + p.getFechaNacimiento()+
				"/nSexo"+ p.getSexo()+
				"/nAltura: "+p.getAltura()+
				"/nPeso: "+ p.getPeso()+
				"/nGrupo Sanguíneo: "+p.getGrupoSanguineo()+
				"/nHistorial médico"+ p.getHistorialMedico()+
				"/nObservaciones" +p.getObservacionesNotas()+
				"/nAntecedentes Famliares: "+p.getAntecedentesFamiliares()+
				"/nTeléfono de contacto: "+ p.getTelefono()+
				"/nEnfermero: "+p.getEnfermero());
		System.out.print("Alergias: ");
		p.printAlergias();
	}


	public static void exportarFichaPaciente() {

	}



}

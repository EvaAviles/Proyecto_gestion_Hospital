package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Paciente {

	private static String nombre;
	private static String apellido1;
	private static String apellido2;
	private static String dni;
	private static int edad;
	private static CharSequence fechaNacimiento;
	private static String sexo;// H o M
	private static int altura;//en cm
	private static int peso;//en kg
	private static String grupoSanguineo;
	private static String historialMedico;
	private static String observacionesNotas;
	private static String antecedentesFamiliares;
	private static String telefono;	
	private static Boolean ingresado=false;//Por defecto un paciente NO está ingresado

	//Relaciones
	private static Enfermero enfermero;
	private static ArrayList <Alergia> listaAlergias= new ArrayList<>();
	private static ArrayList <Suministro> listaSuministros= new ArrayList<>();
	private static ArrayList <Receta> listaRecetas= new ArrayList<>();
	private static ArrayList <IngresoHospitalario> listaIngresos= new ArrayList<>();
	private static Medico medicoCabecera;
	private static Habitacion habitacionActual;
	
	public Paciente(String string) {
		Paciente.nombre=string;
	}

	//Getters y setters
	public static String getNombre() {
		return nombre;
	}
	public static void setNombre(String nombre) {
		Paciente.nombre = nombre;
	}
	public static String getApellido1() {
		return apellido1;
	}
	public static void setApellido1(String apellido1) {
		Paciente.apellido1 = apellido1;
	}
	public static String getApellido2() {
		return apellido2;
	}
	public static void setApellido2(String apellido2) {
		Paciente.apellido2 = apellido2;
	}
	public static String getDni() {
		return dni;
	}
	public static void setDni(String dni) {
		Paciente.dni = dni;
	}
	public static int getEdad() {
		return edad;
	}
	public static void setEdad(int edad) {
		Paciente.edad = edad;
	}
	public static CharSequence getFechaNacimiento() {
		return fechaNacimiento;
	}
	public static void setFechaNacimiento(CharSequence fechaNacimiento) {
		Paciente.fechaNacimiento = fechaNacimiento;
	}
	public static String getSexo() {
		return sexo;
	}
	public static void setSexo(String sexo) {
		Paciente.sexo = sexo;
	}
	public static int getAltura() {
		return altura;
	}
	public static void setAltura(int altura) {
		Paciente.altura = altura;
	}
	public static int getPeso() {
		return peso;
	}
	public static void setPeso(int peso) {
		Paciente.peso = peso;
	}
	public static String getGrupoSanguineo() {
		return grupoSanguineo;
	}
	public static void setGrupoSanguineo(String grupoSanguineo) {
		Paciente.grupoSanguineo = grupoSanguineo;
	}
	public static String getHistorialMedico() {
		return historialMedico;
	}
	public static void setHistorialMedico(String historialMedico) {
		Paciente.historialMedico = historialMedico;
	}
	public static String getObservacionesNotas() {
		return observacionesNotas;
	}
	public static void setObservacionesNotas(String observacionesNotas) {
		Paciente.observacionesNotas = observacionesNotas;
	}
	public static String getAntecedentesFamiliares() {
		return antecedentesFamiliares;
	}
	public static void setAntecedentesFamiliares(String antecedentesFamiliares) {
		Paciente.antecedentesFamiliares = antecedentesFamiliares;
	}
	public static Enfermero getEnfermero() {
		return enfermero;
	}
	public static void setEnfermero(Enfermero enfermero) {
		Paciente.enfermero = enfermero;
	}
	public static ArrayList<Alergia> getListaAlergias() {
		return listaAlergias;
	}
	public static void setListaAlergias(ArrayList<Alergia> listaAlergias) {
		Paciente.listaAlergias = listaAlergias;
	}
	public static void printAlergias() { 
		//Recorremos arrayList e imprimimos alergias
		for(int i=0;i<listaAlergias.size();i++) {
			System.out.println(listaAlergias.get(i));
			System.out.println(", ");
		}
	}

	public static ArrayList<Suministro> getListaSuministros() {
		return listaSuministros;
	}
	public static void setListaSuministros(ArrayList<Suministro> listaSuministros) {
		Paciente.listaSuministros = listaSuministros;
	}
	public static ArrayList<Receta> getListaRecetas() {
		return listaRecetas;
	}
	public static  void setListaRecetas(ArrayList<Receta> listaRecetas) {
		Paciente.listaRecetas = listaRecetas;
	}
	public static ArrayList<IngresoHospitalario> getListaIngresos() {
		return listaIngresos;
	}
	public static void setListaIngresos(ArrayList<IngresoHospitalario> listaIngresos) {
		Paciente.listaIngresos = listaIngresos;
	}
	public static Medico getMedicoCabecera() {
		return medicoCabecera;
	}
	public static void setMedicoCabecera(Medico medicoCabecera) {
		Paciente.medicoCabecera = medicoCabecera;
	}
	public static String getTelefono() {
		return telefono;
	}

	public static void setTelefono(String telefono) {
		Paciente.telefono = telefono;
	}
	

	public static void actualizarEdad() {
		//A partir de la fecha de Nacimiento calculamos la edad, de esta forma podemos ir actualizando.
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse((CharSequence) fechaNacimiento, fmt);
		LocalDate ahora = LocalDate.now();
		//Comparamos la fecha de nacimiento con la fecha actual
		Period periodo = Period.between(fechaNac, ahora);
		setEdad(periodo.getYears());
	}

	
	public static Habitacion getHabitacionActual() {
		return habitacionActual;
	}

	public static  void setHabitacionActual(Habitacion habitacionActual) {
		Paciente.habitacionActual = habitacionActual;
	}
	
	public static Boolean getIngresado() {
		return ingresado;
	}

	public static void setIngresado(Boolean ingresado) {
		Paciente.ingresado = ingresado;
	}
	
	//Métodos
	public static void editarFichaPaciente() {
	}

	public static void mostrarFichaPaciente() {
		System.out.println(
				
				"Nombre: "+getNombre()+
				"Apellidos: "+getApellido1()+" "+ getApellido2()+
				"/nDNI: "+ getDni()+
				"/nEdad: "+ getEdad()+
				"/nFecha de nacimiento" + getFechaNacimiento()+
				"/nSexo"+ getSexo()+
				"/nAltura: "+getAltura()+
				"/nPeso: "+ getPeso()+
				"/nGrupo Sanguíneo: "+getGrupoSanguineo()+
				"/nHistorial médico"+ getHistorialMedico()+
				"/nObservaciones" +getObservacionesNotas()+
				"/nAntecedentes Famliares: "+getAntecedentesFamiliares()+
				"/nTeléfono de contacto: "+ getTelefono()+
				"/nEnfermero: "+getEnfermero());
		System.out.print("Alergias: ");
		printAlergias();
		
		//Faltan atributos !!!
	}


	public static void exportarFichaPaciente() {

	}
	
}

package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Paciente implements Serializable{

	//ID Memoria persistente
	private static final long serialVersionUID = 8152466251529082349L;
	
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
	private Boolean ingresado=false;//Por defecto un paciente NO está ingresado

	//Relaciones
	private Enfermero enfermero;
	private ArrayList <Alergia> listaAlergias= new ArrayList<>();
	private ArrayList <Suministro> listaSuministros= new ArrayList<>();
	private ArrayList <Receta> listaRecetas= new ArrayList<>();
	private ArrayList <IngresoHospitalario> listaIngresos= new ArrayList<>();
	private Medico medicoCabecera;
	private Habitacion habitacionActual;
	
	public Paciente(String nombre, String apellido1, String apellido2, 
			String dni, String sexo, String altura, String peso, 
			String historial_medico, String grupo_sanguineo, String observaciones, 
			String antecedentes_familiares, String fecha, String telefono) {
		this.nombre=nombre;
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
	
	public void añadirIngreso (IngresoHospitalario a) {
		listaIngresos.add(a);
	}
	
	public void añadirAlergia (Alergia a) {
		listaAlergias.add(a);
	}
	
	public void añadirReceta (Receta a) {
		listaRecetas.add(a);
	}
	
	public void añadirSuministro (Suministro a) {
		listaSuministros.add(a);
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

	
	public Habitacion getHabitacionActual() {
		return habitacionActual;
	}

	public void setHabitacionActual(Habitacion habitacionActual) {
		this.habitacionActual = habitacionActual;
	}
	
	public Boolean getIngresado() {
		return ingresado;
	}

	public void setIngresado(Boolean ingresado) {
		this.ingresado = ingresado;
	}
	
	//Métodos
	public void editarFichaPaciente() {
	}

	public void mostrarFichaPaciente() {
		System.out.println(
				
				"\t"+"Nombre: "+getNombre()+
				"\n"+"\t"+"Apellidos: "+getApellido1()+" "+ getApellido2()+
				"\n"+"\t"+"DNI: "+ getDni()+
				"\n"+"\t"+"Edad: "+ getEdad()+
				"\n"+"\t"+"Fecha de nacimiento: " + getFechaNacimiento()+
				"\n"+"\t"+"Sexo: "+ getSexo()+
				"\n"+"\t"+"Altura: "+getAltura()+
				"\n"+"\t"+"Peso: "+ getPeso()+
				"\n"+"\t"+"Grupo Sanguíneo: "+getGrupoSanguineo()+
				"\n"+"\t"+"Historial médico: "+ getHistorialMedico()+
				"\n"+"\t"+"Observaciones: " +getObservacionesNotas()+
				"\n"+"\t"+"Antecedentes Famliares: "+getAntecedentesFamiliares()+
				"\n"+"\t"+"Teléfono de contacto: "+ getTelefono()+
				"\n"+"\t"+"Enfermero: "+getEnfermero());
		System.out.print("Alergias: ");
		printAlergias();
		
		//Faltan atributos !!!
	}


	public void exportarFichaPaciente() {

	}
	
	public void nuevoPaciente() {

		Scanner teclado = new Scanner(System.in);
		System.out.println("\n\tALTA NUEVO PACIENTE");

		//NOMBRE
		System.out.print("Nombre: ");
		String nombre = teclado.next();

		while(!nombre.matches(".*[a-z].*")) {
			System.out.println("Introduzca el nombre correctamente");
			nombre = null;
			System.out.print("Nombre: ");
			nombre = teclado.next();

		}

		//PRIMER APELLIDO
		System.out.print("Primer apellido: ");
		String apellido1 = teclado.next();

		while(!apellido1.matches(".*[a-z].*")) {
			System.out.println("Introduzca el primer apellido correctamente");
			apellido1 = null;
			System.out.print("Primer apellido: ");
			apellido1 = teclado.next();

		}

		//SEGUNDO APELLIDO
		System.out.print("Segundo apellido: ");
		String apellido2 = teclado.next();

		while(!apellido2.matches(".*[a-z].*")) {
			System.out.println("Introduzca el segundo apellido correctamente");
			apellido2 = null;
			System.out.print("Segundo apellido: ");
			apellido2 = teclado.next();

		}


		//DNI
		//SOLO PUEDEN PONER 9 CIFRAS
		System.out.print("DNI: ");
		String dni = teclado.next();

		while(dni.length() != 9) {
			System.out.println("Introduzca el DNI correctamente");
			dni = null;
			System.out.print("DNI: ");
			dni = teclado.next();

		}

		//SEXO
		System.out.print("Sexo: ");
		String sexo = teclado.next();

		while(!sexo.matches(".*[a-z].*")) {
			System.out.println("Introduzca el sexo correctamente");
			sexo = null;
			System.out.print("Sexo: ");
			sexo = teclado.next();

		}

		//ALTURA
		System.out.print("Altura: ");
		String altura = teclado.next();

		while(altura.matches(".*[a-z].*")) {
			System.out.println("Introduzca la altura correctamente");
			altura = null;
			System.out.print("Altura: ");
			altura = teclado.next();

		}

		//PESO
		System.out.print("Peso: ");
		String peso = teclado.next();

		while(peso.matches(".*[a-z].*")) {
			System.out.println("Introduzca el peso correctamente");
			peso = null;
			System.out.print("Peso: ");
			peso = teclado.next();
		}


		//HISTORIAL MÉDICO
		System.out.print("Historial médico: ");
		String historial_medico = teclado.next();

		while(!historial_medico.matches(".*[a-z].*")) {
			System.out.println("Introduzca el historial_medico correctamente");
			historial_medico = null;
			System.out.print("Historial médico: ");
			historial_medico = teclado.next();

		}
		
		
		//GRUPO SANGUÍNEO
		System.out.print("Grupo sanguíneo: ");
		String grupo_sanguineo = teclado.next();
		
		while(!grupo_sanguineo.matches(".*[a-z].*")) {
			System.out.println("Introduzca el grupo sanguineo correctamente");
			grupo_sanguineo = null;
			System.out.print("Grupo sanguineo: ");
			grupo_sanguineo = teclado.next();

		}
		
		
		//OBSERVACIONES
		System.out.print("Observaciones: ");
		String observaciones = teclado.next();

		while(!observaciones.matches(".*[a-z].*")) {
			System.out.println("Introduzca las observaciones correctamente");
			observaciones = null;
			System.out.print("Observaciones: ");
			observaciones = teclado.next();

		}
		
		
		//ANTECEDENTES FAMILIARES
		System.out.print("Antecedentes familiares: ");
		String antecedentes_familiares = teclado.next();

		while(!antecedentes_familiares.matches(".*[a-z].*")) {
			System.out.println("Introduzca los antecedentes familiares correctamente");
			antecedentes_familiares = null;
			System.out.print("Antecedentes familiares: ");
			antecedentes_familiares = teclado.next();

		}
		
		
		//FEHA DE NACIMIENTO
		System.out.print("Fecha de nacimiento: ");
		String fecha = teclado.next();

		while(fecha.matches(".*[a-z].*")) {
			System.out.println("Introduzca la fecha de nacimiento correctamente");
			fecha = null;
			System.out.print("Fecha de nacimiento: ");
			fecha = teclado.next();

		}

		//SOLO SE PUEDEN 9 NUMEROS
		//TELÉFONO
		System.out.print("Teléfono: ");
		String telefono = teclado.next();

		while(telefono.matches(".*[a-z].*") || telefono.length()!=9) {
				System.out.println("Introduzca el teléfono correctamente");
			telefono = null;
			System.out.print("Teléfono: ");
			telefono = teclado.next();
		}

	
		teclado.close();

		Paciente nuevoPaciente = new Paciente (nombre, apellido1, apellido2, dni, sexo, altura, peso, historial_medico, grupo_sanguineo,
												observaciones, antecedentes_familiares, fecha, telefono);
		listaPacientes.add(nuevoPaciente);


	}
	
}

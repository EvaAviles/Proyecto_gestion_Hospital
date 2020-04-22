package control;

import model.Alergia;
import model.Enfermero;
import model.Especialidad;
import model.Habitacion;
import model.Inventario;
import model.Medicamento;
import model.Medico;
import model.MedicoAdministrador;
import model.Paciente;
import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;


public class Sistema  {

	//Relaciones - TODAS TIENEN MEMORIA PERSISTENTE
	private ArrayList <Alergia> listaAlergias= new ArrayList<>();
	private ArrayList <Enfermero> listaEnfermeros= new ArrayList<>();
	private ArrayList <Usuario> listaUsuarios= new ArrayList<>();
	private ArrayList <Medico> listaMedicos= new ArrayList<>();
	private MedicoAdministrador medicoAdministrador;
	private ArrayList <Especialidad> listaEspecialidades= new ArrayList<>();
	private ArrayList <Habitacion> listaHabitaciones= new ArrayList<>();
	public ArrayList <Medicamento> listaMedicamentos= new ArrayList<>();
	private Inventario inventarioMedicamentos;
	public ArrayList <Paciente>listaPacientes=new ArrayList<>();//
	private static Medicamento m;


	//Getters y setters
	public ArrayList<Alergia> getListaAlergias() {
		return listaAlergias;
	}

	public void setListaAlergias(ArrayList<Alergia> listaAlergias) {
		this.listaAlergias = listaAlergias;
	}

	public ArrayList<Enfermero> getListaEnfermeros() {
		return listaEnfermeros;
	}

	public void setListaEnfermeros(ArrayList<Enfermero> listaEnfermeros) {
		this.listaEnfermeros = listaEnfermeros;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public ArrayList<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(ArrayList<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}

	public MedicoAdministrador getMedicoAdministrador() {
		return medicoAdministrador;
	}

	public void setMedicoAdministrador(MedicoAdministrador medicoAdministrador) {
		this.medicoAdministrador = medicoAdministrador;
	}

	public ArrayList<Especialidad> getListaEspecialidades() {
		return listaEspecialidades;
	}

	public void setListaEspecialidades(ArrayList<Especialidad> listaEspecialidades) {
		this.listaEspecialidades = listaEspecialidades;
	}

	public ArrayList<Habitacion> getListaHabitaciones() {
		return listaHabitaciones;
	}

	public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}

	public ArrayList<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}

	public void setListaMedicamentos(ArrayList<Medicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}

	public Inventario getInventarioMedicamentos() {
		return inventarioMedicamentos;
	}

	public void setInventarioMedicamentos(Inventario inventarioMedicamentos) {
		this.inventarioMedicamentos = inventarioMedicamentos;
	}

	public ArrayList<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	//Métodos
	public static void importarInformacion() {

	}

	public static void avisoBajoInventario() {

	}

	public static void avisoCaducidad() {

	}

	//Método buscar paciente por dni
	public int buscarPaciente(String dni) {	  //como parámetro le damos el DNI

		int posicion=-1;

		for (int i = 0 ; i <listaPacientes.size();i++) {    //recorro el ArrayList
			if(dni.equals(listaPacientes.get(i).getDni())) {    //si el dni es igual a alguno del array, me da la posición
				posicion=i;
				i=listaPacientes.size();	
			} 
		}
		return posicion;// Si se devuelve -1 no se ha encontrado nada
	}






	/*	else if(opcion.toLowerCase().equals("habitacion")) { //buscar paciente por habitación

			for (int i = 0 ; i <listaPacientes.size();i++) {

				else if(opcion.toLowerCase().equals("habitacion")) {     //buscar paciente por habitación
					for (int i = 0 ; i <listaPacientes.size();i++) {				 
						if(dato.equals(listaPacientes.get(i).getHabitacionActual().getNombre())) {

							posicion=i;
							i=listaPacientes.size();
						}
					}
				}
				return posicion;
			}
		}*/



	public static void buscarUsuario() {

	}

	public static void iniciarSesion() {

	}

	public void añadirPaciente(Paciente p) {//no se ha probado
		//Faltaría añadir la comprobación del dni para asegurarnos de que no se repiten, comprobando el DNI
		listaPacientes.add(p);
	}

	public void eliminarPaciente(int i) {//no se ha probado
		listaPacientes.remove(i);
	}

	public void añadirAlergia (Alergia a) {
		listaAlergias.add(a);
	}

	public void añadirEnfermero (Enfermero a) {
		listaEnfermeros.add(a);
	}

	public void añadirUsuario (Usuario a) {
		listaUsuarios.add(a);
	}

	public void añadirMedico (Medico a) {
		listaMedicos.add(a);
	}



	public void añadirEspecialidad (Especialidad a) {
		listaEspecialidades.add(a);
	}

	public void añadirHabitacion (Habitacion a) {
		listaHabitaciones.add(a);
	}

	//MAIN
	public static void main(String[] args) {

		//Esto es necesario porque se ha eliminado el static de los atributos:
		Sistema s = new Sistema();
		Scanner teclado= new Scanner (System.in);


		/*	//Pruba buscar Paciente
		listaPacientes= new ArrayList<Paciente>();

		//Pruba buscar Paciente
		//listaPacientes= new ArrayList<Paciente>();

		//Paciente persona1= new Paciente ("Olga","Moreno", 12, 'M',1);
		//listaPacientes.add(persona1);
		//Paciente persona2= new Paciente ("Niza","Albo", 12, 'M',2);

		listaPacientes.add(persona2);


		//listaPacientes.add(persona2);



		//Menú para buscar paciente; está a medio hacer, es solo de prueba, tengo que hacer un switch de casos bien hecho. 
			System.out.println("Introduzca la habitación que desea buscar: ");
			habitacion= teclado.nextInt();
			System.out.println(buscarPaciente(Integer.toString(habitacion), "HABITACION"));
			break;	
		}*/


		//PRUEBAS MEMORIA PERSISTENTE - DE MOMENTO FUNCIONA CON TODO LO QUE SE GUARDA EN SISTEMA.JAVA :)
		//Prueba importar Pacientes desde una plantilla csv.
		//importarPacientesPlantillaCSV("pacientesNuevos.csv", s);

		//Prueba importar pacientes memoria persistente
		//exportarListaPacientes("listaPacientes.age");

		/*importarListas();
		for (Paciente p: listaPacientes) {
			System.out.println(p.getNombre());
		}*/

		//exportarListas();


		/*Prueba buscar paciente por dni
		String dni;
		System.out.println("Introduzca el dni que desea buscar: ");
		Scanner teclado= new Scanner (System.in);
		dni= teclado.nextLine();
		System.out.println(s.buscarPaciente(dni));
		System.out.println(s.listaPacientes.size());
		teclado.close();*/

		Sistema.m= new Medicamento();
		m.crearListaMedicamentos();
		//m.añadirMedicamento();

		//Prueba buscar medicamento por nombre
		/*String nombre;
		System.out.println("Introduzca el medicamento: ");
		nombre= teclado.nextLine();
		m.verMedicamento(m.buscarMedicamento(nombre));*/
		//System.out.println(m.buscarMedicamento(nombre));
		teclado.close();

	}
}

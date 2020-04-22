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
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Sistema implements Serializable{

	//No borrar el serialVersionUID - es para la memoria persistente
	private static final long serialVersionUID = -889616695493948313L;

	//Relaciones - TODAS TIENEN MEMORIA PERSISTENTE
	public static ArrayList <Alergia> listaAlergias= new ArrayList<>();
	public static ArrayList <Enfermero> listaEnfermeros= new ArrayList<>();
	public static ArrayList <Usuario> listaUsuarios= new ArrayList<>();
	public static ArrayList <Medico> listaMedicos= new ArrayList<>();
	public static MedicoAdministrador medicoAdministrador;
	public static ArrayList <Especialidad> listaEspecialidades= new ArrayList<>();
	public static ArrayList <Habitacion> listaHabitaciones= new ArrayList<>();
	public static ArrayList <Medicamento> listaMedicamentos= new ArrayList<>();
	public static Inventario inventarioMedicamentos;
	public static ArrayList <Paciente>listaPacientes=new ArrayList<>();//


	//Getters y setters
	public static ArrayList<Alergia> getListaAlergias() {
		return listaAlergias;
	}

	public static void setListaAlergias(ArrayList<Alergia> listaAlergias) {
		Sistema.listaAlergias = listaAlergias;
	}

	public static ArrayList<Enfermero> getListaEnfermeros() {
		return listaEnfermeros;
	}


	public static void setListaEnfermeros(ArrayList<Enfermero> listaEnfermeros) {

		Sistema.listaEnfermeros = listaEnfermeros;
	}

	public static ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}


	public static void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {

		Sistema.listaUsuarios = listaUsuarios;
	}

	public static ArrayList<Medico> getListaMedicos() {
		return listaMedicos;
	}



	public static void setListaMedicos(ArrayList<Medico> listaMedicos) {
		Sistema.listaMedicos = listaMedicos;
	}

	public static MedicoAdministrador getMedicoAdministrador() {
		return medicoAdministrador;
	}

	public static void setMedicoAdministrador(MedicoAdministrador medicoAdministrador) {
		Sistema.medicoAdministrador = medicoAdministrador;
	}

	public static ArrayList<Especialidad> getListaEspecialidades() {
		return listaEspecialidades;
	}

	public static void setListaEspecialidades(ArrayList<Especialidad> listaEspecialidades) {
		Sistema.listaEspecialidades = listaEspecialidades;
	}

	public static ArrayList<Habitacion> getListaHabitaciones() {
		return listaHabitaciones;
	}

	public static void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
		Sistema.listaHabitaciones = listaHabitaciones;
	}

	public static ArrayList<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}

	public static void setListaMedicamentos(ArrayList<Medicamento> listaMedicamentos) {

		Sistema.listaMedicamentos = listaMedicamentos;
	}

	public static Inventario getInventarioMedicamentos() {
		return inventarioMedicamentos;
	}


	public static void setInventarioMedicamentos(Inventario inventarioMedicamentos) {

		Sistema.inventarioMedicamentos = inventarioMedicamentos;
	}

	public static ArrayList<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public static void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		Sistema.listaPacientes = listaPacientes;
	}

	//M�todos
	public static void importarInformacion() {

	}

	public static void avisoBajoInventario() {

	}

	public static void avisoCaducidad() {

	}

	//M�todo buscar paciente por dni
	public static int buscarPaciente(String dni) {	  //como par�metro le damos el DNI

		int posicion=-1;

		for (int i = 0 ; i <listaPacientes.size();i++) {    //recorro el ArrayList
			if(dni.equals(listaPacientes.get(i).getDni())) {    //si el dni es igual a alguno del array, me da la posici�n
				posicion=i;
				i=listaPacientes.size();	
			} 
		}
		return posicion;// Si se devuelve -1 no se ha encontrado nada
	}

	public static int buscarMedicamentoNombre (String nombre) {
		int posicion = -1;
		for (int i = 0 ; i <listaMedicamentos.size();i++) {    //recorro el ArrayList
			if(nombre.equals(listaMedicamentos.get(i).getNombre())) {    //si el dni es igual a alguno del array, me da la posici�n
				posicion=i;
				i=listaMedicamentos.size();	
			} 
		}
		
		return posicion;
	}


	public static void buscarMedicamento() {

	}

	public static void buscarUsuario() {

	}

	public static void iniciarSesion() {

	}

	public static void a�adirPaciente(Paciente p) {//no se ha probado
		//Faltar�a a�adir la comprobaci�n del dni para asegurarnos de que no se repiten, comprobando el DNI
		listaPacientes.add(p);
	}

	public static void eliminarPaciente(int i) {//no se ha probado
		listaPacientes.remove(i);
	}

	public static void a�adirAlergia (Alergia a) {
		listaAlergias.add(a);
	}

	public static void a�adirEnfermero (Enfermero a) {
		listaEnfermeros.add(a);
	}

	public static void a�adirUsuario (Usuario a) {
		listaUsuarios.add(a);
	}

	public static void a�adirMedico (Medico a) {
		listaMedicos.add(a);
	}

	public static void a�adirMedicamento (Medicamento a) {
		listaMedicamentos.add(a);
	}

	public static void a�adirEspecialidad (Especialidad a) {
		listaEspecialidades.add(a);
	}

	public static void a�adirHabitacion (Habitacion a) {
		listaHabitaciones.add(a);
	}



	public static void logearse1() {

		String pass=""; //La inicializamos en nula
		String usuario="";

		//Con un bucle buscamos la contrase�a y usuario
		int p=0;
		boolean acceso=false;
		while(acceso==false) { //Mientras q no sean correctos los datos no acaba el bucle
			//Aparecen mis ventanas para escribir usuario y contrase�a
			usuario=JOptionPane.showInputDialog("Usuario: ");
			pass=JOptionPane.showInputDialog("Password: ");
			//Recorro mi listaUsuarios para saber si coinciden
			for(Usuario u: listaUsuarios) {
				if(usuario.equals(listaUsuarios.get(p).getUsuario()) &&
						pass.equals(listaUsuarios.get(p).getPassword())) {
					//Si coinciden entro en el sistema e imprimo mensajito
					JOptionPane.showMessageDialog(null, "Bienvenid@ al sistema");
					acceso=true;
				}else {
					//Sige mi bucle e imprimo mensajito
					acceso=false;
					JOptionPane.showMessageDialog(null, "El usuario o contrase�a no coinciden");
				}
			}	
		}
	}


	//MAIN


	public static void main(String[] args) {

		/*	//Pruba buscar Paciente
		listaPacientes= new ArrayList<Paciente>();


		//Pruba buscar Paciente

		//listaPacientes= new ArrayList<Paciente>();

		//listaPacientes= new ArrayList<Paciente>();

		//Paciente persona1= new Paciente ("Olga","Moreno", 12, 'M',1);
		//listaPacientes.add(persona1);
		//Paciente persona2= new Paciente ("Niza","Albo", 12, 'M',2);

		//listaPacientes.add(persona2);



		//Men� para buscar paciente; est� a medio hacer, es solo de prueba, tengo que hacer un switch de casos bien hecho. 
		/*switch() {
		case  "nombre":
			System.out.println("Introduzca el nombre que desea buscar: ");
			nombre= teclado.nextLine();
			System.out.println(buscarPaciente(nombre, "nombre"));
			break;
		case "apellido":
			System.out.println("Introduzca el apellido que desea buscar: ");
			apellido= teclado.nextLine();
			System.out.println(buscarPaciente(apellido, "apellido"));
			break;                                 
		case "habitaci�n":
			System.out.println("Introduzca la habitaci�n que desea buscar: ");
			habitacion= teclado.nextInt();
			System.out.println(buscarPaciente(Integer.toString(habitacion), "HABITACION"));
			break;	

		}*/



		//Prueba calcular edad a partir de la fecha de nacimiento
		/*p1.setFechaNacimiento("13/04/2010");
		p1.actualizarEdad();
		System.out.println("Edad: "+ p1.getEdad());
		//Prueba importar Pacientes desde una plantilla csv.
		importarPacientesPlantillaCSV("pacientesNuevos.csv"); */


		//PRUEBAS MEMORIA PERSISTENTE - DE MOMENTO FUNCIONA CON TODO LO QUE SE GUARDA EN SISTEMA.JAVA :)
		//Prueba importar Pacientes desde una plantilla csv.

		//	importarPacientesPlantillaCSV("pacientesNuevos.csv");

		//importarPacientesPlantillaCSV("pacientesNuevos.csv", s);

		//Prueba importar pacientes memoria persistente
		//exportarListaPacientes("listaPacientes.age");

		/*importarListas();
		for (Paciente p: listaPacientes) {
			System.out.println(p.getNombre());
		}*/

		//exportarListas();

		/*
		//Prueba buscar paciente por dni
		String dni;
		System.out.println("Introduzca el dni que desea buscar: ");
		Scanner teclado= new Scanner (System.in);
		dni= teclado.nextLine();
		System.out.println(s.buscarPaciente(dni));
		System.out.println(s.listaPacientes.size());
		teclado.close();*/




		//Prueba informe paciente - funciona :)
		//f.importarPacientesPlantillaCSV("pacientesNuevos.csv",s);
		//f.exportarInformePaciente(s.listaPacientes.get(0));

	}

}

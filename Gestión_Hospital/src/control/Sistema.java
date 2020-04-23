package control;

import model.Alergia;
import model.Correo;
import model.Enfermero;
import model.Especialidad;
import model.Habitacion;
import model.Inventario;
import model.Medicamento;
import model.Medico;
import model.MedicoAdministrador;
import model.Paciente;
import model.RegistroConsumo;
import model.Usuario;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
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
	
	//Esto tampoco tiene sentido
	private static Medicamento m;

	//Getters y setters
	public ArrayList<Alergia> getListaAlergias() {
		return listaAlergias;
	}

	public void setListaAlergias(ArrayList<Alergia> listaAlergias) {
		Sistema.listaAlergias = listaAlergias;
	}

	public ArrayList<Enfermero> getListaEnfermeros() {
		return listaEnfermeros;
	}

	public void setListaEnfermeros(ArrayList<Enfermero> listaEnfermeros) {
		Sistema.listaEnfermeros = listaEnfermeros;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		Sistema.listaUsuarios = listaUsuarios;
	}

	public ArrayList<Medico> getListaMedicos() {
		return listaMedicos;
	}


	public void setListaMedicos(ArrayList<Medico> listaMedicos) {
		Sistema.listaMedicos = listaMedicos;
	}

	public MedicoAdministrador getMedicoAdministrador() {
		return medicoAdministrador;
	}

	public static void setMedicoAdministrador(MedicoAdministrador medicoAdministrador) {
		Sistema.medicoAdministrador = medicoAdministrador;
	}

	public static ArrayList<Especialidad> getListaEspecialidades() {
		return listaEspecialidades;
	}

	public void setListaEspecialidades(ArrayList<Especialidad> listaEspecialidades) {
		Sistema.listaEspecialidades = listaEspecialidades;
	}

	public ArrayList<Habitacion> getListaHabitaciones() {
		return listaHabitaciones;
	}

	public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
		Sistema.listaHabitaciones = listaHabitaciones;
	}

	public ArrayList<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}

	public void setListaMedicamentos(ArrayList<Medicamento> listaMedicamentos) {

		Sistema.listaMedicamentos = listaMedicamentos;
	}

	public Inventario getInventarioMedicamentos() {
		return inventarioMedicamentos;
	}


	public static void setInventarioMedicamentos(Inventario inventarioMedicamentos) {

		Sistema.inventarioMedicamentos = inventarioMedicamentos;
	}

	public ArrayList<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		Sistema.listaPacientes = listaPacientes;
	}

	//Métodos
	public static void importarInformacion() {

	}

	public static void avisoBajoInventario() {

	}

	public static void avisoCaducidad() {

	}

	//Método buscar paciente por dni
	public static int buscarPaciente(String dni) {	  //como parámetro le damos el DNI

		int posicion=-1;

		for (int i = 0 ; i <listaPacientes.size();i++) {    //recorro el ArrayList
			if(dni.equals(listaPacientes.get(i).getDni())) {    //si el dni es igual a alguno del array, me da la posición
				posicion=i;
				i=listaPacientes.size();	
			} 
		}
		return posicion;// Si se devuelve -1 no se ha encontrado nada
	}


	public static int buscarMedicamentoNombre (String nombre) {
		int posicion = -1;
		for (int i = 0 ; i <listaMedicamentos.size();i++) {    //recorro el ArrayList
			if(nombre.equals(listaMedicamentos.get(i).getNombre())) {    //si el dni es igual a alguno del array, me da la posición
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

	public static void añadirPaciente(Paciente p) {//no se ha probado
		//Faltaría añadir la comprobación del dni para asegurarnos de que no se repiten, comprobando el DNI
		listaPacientes.add(p);
	}

	public static void eliminarPaciente(int i) {//no se ha probado
		listaPacientes.remove(i);
	}

	public static void añadirAlergia (Alergia a) {
		listaAlergias.add(a);
	}

	public static void añadirEnfermero (Enfermero a) {
		listaEnfermeros.add(a);
	}

	public static void añadirUsuario (Usuario a) {
		listaUsuarios.add(a);
	}

	public static void añadirMedico (Medico a) {
		listaMedicos.add(a);
	}
	
	public static void añadirMedicamento (Medicamento a) {
		listaMedicamentos.add(a);
	}



	public static void añadirEspecialidad (Especialidad a) {
		listaEspecialidades.add(a);
	}

	public static void añadirHabitacion (Habitacion a) {
		listaHabitaciones.add(a);
	}

	
	//Este método debe estar siempre en el main!!
	public static void generarRegistrosDia () {
		//Creamos la fecha de hoy
		Date hoy = new Date();
		//Primero comprobamos que no se haya creado ningún registro de ese día
		Boolean done = false;
		for (Medicamento m: listaMedicamentos) {
			for (RegistroConsumo r: m.getListaRegistroConsumo()) {
				if (r.getFechaConsumo().equals(hoy)) {
					done =true;
				}
			}
		}
		//Si no se han creado registros ese día, recorremos la lista de medicamentos
		if (done == false) {
			for (Medicamento m: listaMedicamentos) {
				//Para cada medicamento creamos un nuevo RegistroConsumo con la fecha actual
				RegistroConsumo s = new RegistroConsumo();
				s.setFechaConsumo(hoy);
				//Añadimos el registro a la lista de registros del medicamento
				m.añadirRegistroConsumo(s);
			}
		}
		
		
	}
	
	public static void logearse1() {

		String pass=""; //La inicializamos en nula
		String usuario="";
		
		//Con un bucle buscamos la contraseña y usuario
		boolean acceso=false;
		while(acceso==false) { //Mientras q no sean correctos los datos no acaba el bucle
			//Aparecen mis ventanas para escribir usuario y contraseña
			usuario=JOptionPane.showInputDialog("Usuario: ");
			pass=JOptionPane.showInputDialog("Password: ");
			
			//Recorro mi listaUsuarios para saber si coinciden
			for (int i=0; i<listaUsuarios.size(); i++) {
				if(usuario.equals(listaUsuarios.get(i).getLogin()) &&
						pass.equals(listaUsuarios.get(i).getPassword())) {
					//Si coinciden entro en el sistema e imprimo mensajito
					JOptionPane.showMessageDialog(null, "Bienvenid@ al sistema");
					acceso=true;
				}else {
					//Sige mi bucle e imprimo mensajito
					JOptionPane.showMessageDialog(null, "El usuario o contraseña no coinciden");

				}
			}
		}
	}


	//MAIN


	public static void main(String[] args) {

		Scanner teclado= new Scanner (System.in);


		/*	//Pruba buscar Paciente
		listaPacientes= new ArrayList<Paciente>();
		//Pruba buscar Paciente

		//listaPacientes= new ArrayList<Paciente>();

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


		/*Prueba buscar paciente por dni
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

		Sistema.m= new Medicamento();
		m.crearListaMedicamentos();
		
		//Prueba usuario, login
	/*	Usuario u = new Usuario ("123","123");
		Usuario p = new Usuario ("222a","123");
		añadirUsuario(u);
		añadirUsuario(p);
		logearse1();
		
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

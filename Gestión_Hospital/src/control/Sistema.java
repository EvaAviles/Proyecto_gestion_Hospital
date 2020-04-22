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
import model.RegistroConsumo;
import model.Usuario;
import java.util.ArrayList;
import java.util.Date;


public class Sistema  {

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
	//hi

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

	//MAIN
	public static void main(String[] args) {

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
		case "habitación":
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

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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

	//Relaciones
	private ArrayList <Alergia> listaAlergias= new ArrayList<>();
	private ArrayList <Enfermero> listaEnfermeros= new ArrayList<>();
	private ArrayList <Usuario> listaUsuarios= new ArrayList<>();
	private ArrayList <Medico> listaMedicos= new ArrayList<>();
	private MedicoAdministrador medicoAdministrador;
	private ArrayList <Especialidad> listaEspecialidades= new ArrayList<>();
	private ArrayList <Habitacion> listaHabitaciones= new ArrayList<>();
	private ArrayList <Medicamento> listaMedicamentos= new ArrayList<>();
	private Inventario inventarioMedicamentos;
	private static ArrayList <Paciente>listaPacientes= new ArrayList<>();
	private static int contadorPacientesID=0;

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

	public static Paciente buscarPacienteNombre(String nombre) {//Da error porque el return no devuelve realmente un paciente

		//Creamos un boolean para parar la búesqueda cuando encontremos al paciente
		boolean busqueda= false;	
		int posicion=0;
		//Recorro el arrayList		
		for(int i = 0 ; (i <listaPacientes.size()) && (busqueda==false);i++) {
			if(nombre.contentEquals(listaPacientes.get(i).getNombre())) {
				busqueda=true;
				posicion=i;
				System.out.println("exito");
			} 
			else {
				System.out.println("No se encuentra ningún paciente con el nombre " +nombre + ".");    
			}
		}
		return listaPacientes.get(posicion);

	}

	public static void buscarMedicamento() {

	}

	public static void buscarUsuario() {

	}

	public static void iniciarSesion() {

	}

	public static void añadirPaciente(Paciente p) {//no se ha probado
		listaPacientes.add(p);
	}

	public static void eliminarPaciente(int i) {//no se ha probado
		listaPacientes.remove(i);
	}

	//IMPORTAR PACIENTES DESDE UN CSV
	public static int contarLineas (String ruta) {
		File fichero = new File(ruta);
		int lineas = 0;

		try {
			Scanner leer = new Scanner(fichero);
			while(leer.hasNextLine()) {
				leer.nextLine();
				lineas++;
			}
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero '"+ ruta +"' no encontrado!");
		}
		return lineas;
	}

	public static int contarColumnas (String ruta) {
		File fichero = new File(ruta);
		int columnas = 0;

		try {
			Scanner leer = new Scanner(fichero);
			if(leer.hasNextLine()) {
				String linea = leer.nextLine();
				columnas = linea.split(";").length;
			}
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero '"+ ruta +"' no encontrado!");
		}
		return columnas;
	}

	public static String[][] leerFicheroMatriz(String ruta) {
		int filas = contarLineas(ruta);
		int columnas = contarColumnas(ruta);
		String[][] salida = new String[filas][columnas]; 

		File fichero = new File(ruta);
		try {
			Scanner leer = new Scanner(fichero);

			for (int i=0; i<filas; i++) {
				String linea = leer.nextLine(); 	
				String[] valores = linea.split(";");
				for(int j=0; j<columnas; j++) {
					salida[i][j] = valores[j];
				}
			}
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero '"+ ruta +"' no encontrado!");
		}
		return salida;
	}
	
	public static int convertirStringInt(String s) {
		String numCadena = s; 
		int numEntero = Integer. parseInt(numCadena);
		return numEntero;
	}

	public static void importarPacientesPlantillaCSV (String ruta){//Se ha probado y funciona :)
		//Leemos el fichero y lo guardamos en una matriz
		String pacientes[][]= leerFicheroMatriz(ruta);
		//Recorremos cada fila para crear instancias de cada paciente
		for (int i=1; i<pacientes.length;i++) {//Comenzamos por la fila 1 ya que el csv tiene títulos en la posición 2
			//Por cada fila creamos un nuevo paciente
			Paciente p = new Paciente(pacientes[i][0]);
			//Añadimos cada atributo
			p.setApellido1(pacientes[i][1]);
			p.setApellido2(pacientes[i][2]);
			p.setDni(pacientes[i][3]);
			//Hacemos un parse a la edad: String-int
			p.setEdad(convertirStringInt(pacientes[i][4]));
			//Hacemos un parse de la fechaNacimiento: String-CharSequence
			String s = pacientes[i][5];
			CharSequence fecha = s;
			p.setFechaNacimiento(fecha);
			//Actualizamos ahora la edad del paciente
			p.actualizarEdad();
			//Seguimos añadiendo atributos
			p.setSexo(pacientes[i][6]);
			//Hacemos parse de String a int
			p.setAltura(convertirStringInt(pacientes[i][7]));
			p.setPeso(convertirStringInt(pacientes[i][8]));
			p.setGrupoSanguineo(pacientes[i][9]);
			p.setHistorialMedico(pacientes[i][10]);
			p.setObservacionesNotas(pacientes[i][11]);
			p.setAntecedentesFamiliares(pacientes[i][12]);
			p.setTelefono(pacientes[i][13]);
			//Añadimos el paciente a la lista de pacientes
			añadirPaciente(p);
		}

	}

	//MAIN
	public static void main(String[] args) {

		//Pruba buscar Paciente
		Paciente p1= new Paciente("Ramon");
		listaPacientes.add(p1);
		buscarPacienteNombre("Monica");
		//Prueba calcular edad a partir de la fecha de nacimiento
		p1.setFechaNacimiento("13/04/2010");
		p1.actualizarEdad();
		System.out.println("Edad: "+ p1.getEdad());
		//Prueba importar Pacientes desde una plantilla csv.
		importarPacientesPlantillaCSV("pacientesNuevos.csv");
		buscarPacienteNombre("IGNACIO");
		System.out.println(listaPacientes.size());
		
		
		



	}

}

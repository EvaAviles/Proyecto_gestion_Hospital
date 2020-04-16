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

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Sistema implements Serializable{

	//No borrar el serialVersionUID - es para la memoria persistente
	private static final long serialVersionUID = -889616695493948313L;

	//Relaciones - TODAS TIENEN MEMORIA PERSISTENTE
	private static ArrayList <Alergia> listaAlergias= new ArrayList<>();
	private static ArrayList <Enfermero> listaEnfermeros= new ArrayList<>();
	private static ArrayList <Usuario> listaUsuarios= new ArrayList<>();
	private static ArrayList <Medico> listaMedicos= new ArrayList<>();
	private static MedicoAdministrador medicoAdministrador;
	private static ArrayList <Especialidad> listaEspecialidades= new ArrayList<>();
	private static ArrayList <Habitacion> listaHabitaciones= new ArrayList<>();
	private static ArrayList <Medicamento> listaMedicamentos= new ArrayList<>();
	private static Inventario inventarioMedicamentos;
	public static ArrayList <Paciente>listaPacientes=new ArrayList<>();//


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

	public static ArrayList<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public static void setListaMedicos(ArrayList<Medico> listaMedicos) {
		Sistema.listaMedicos = listaMedicos;
	}

	public MedicoAdministrador getMedicoAdministrador() {
		return medicoAdministrador;
	}

	public void setMedicoAdministrador(MedicoAdministrador medicoAdministrador) {
		Sistema.medicoAdministrador = medicoAdministrador;
	}

	public ArrayList<Especialidad> getListaEspecialidades() {
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

	public void setInventarioMedicamentos(Inventario inventarioMedicamentos) {
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

	//Método buscar paciente
	public static int buscarPaciente(String dato, String opcion) {	  /*como dato será el que me manda por teclado el usuario
                                                                      como opción será nombre, apellido o habitación*/
		int posicion=-1;
		//opción buscar paciente por nombre
		if (opcion.toLowerCase().equals("nombre")) {   //por si acaso, cambio lo que me manda el usuario a minúsculas
			for (int i = 0 ; i <listaPacientes.size();i++) {    //recorro el ArrayList
				if(dato.equals(listaPacientes.get(i).getNombre())) {    //si el nombre es igual a alguno del array, me da la posición
					posicion=i;
					i=listaPacientes.size();	
				} 
			}
		} 
		else if(opcion.toLowerCase().equals("apellido")) {       //Caso buscar paciente por apellido
			for (int i = 0 ; i <listaPacientes.size();i++) {
				if(dato.equals(listaPacientes.get(i).getApellido1())) {
					posicion=i;
					i=listaPacientes.size();	
				} 
			}
		} //

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

		return posicion;// Si se devuelve -1 no se ha encontrado nada
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

	//Implementación de MEMORIA PERSISTENTE
	//Importar todas las listas
	public static void importarListas() {
		try {
			importarListaPacientes();
			importarListaAlergias();
			importarListaEnfermeros();
			importarListaUsuarios();
			importarListaMedicos();
			importarListaEspecialidades();
			importarListaHabitaciones();
			importarListaMedicamentos();
			importarMedicoAdministrador();
			importarInventario();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Exportar todas las listas
	public static void exportarListas () {
		exportarListaAlergias();
		exportarListaEnfermeros();
		exportarListaPacientes();
		exportarListaUsuarios();
		exportarListaMedicos();
		exportarListaEspecialidades();
		exportarListaHabitaciones();
		exportarListaMedicamentos();
		exportarInventario();
		exportarMedicoAdministrador();
	}
	//ListaPacientes
	public static void exportarListaPacientes() {
		//Se rodea de un try-catch para gestionar los posibles errores
		//Con ObjectOutputStream instanciamos un tipo de "scanner" para leer el fichero
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaPacientes.age"))){
			//Recorremos nuestra lista de pacientes
			for (Paciente o: listaPacientes) {
				//Escribimos cada objeto en el fichero
				oos.writeObject(o);
			}
			//Damos feedback
			System.out.println("La lista de pacientes se ha guardado con éxito en la ruta: listaPaciente.age");
			//Cerramos el "scanner"
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importarListaPacientes() throws IOException, ClassNotFoundException{
		//Con ObjectInputStream instanciamos un tipo de "scanner" con el que leeremos el fichero
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaPacientes.age"))) {
			//Creamos un paciente auxiliar
			Paciente aux;
			//Mientras haya texto (true) leemos el fichero
			while (true) {
				//En el paciente aux guardamos el objeto que leemos, le hacemos cast de Paciente
				aux= (Paciente)ois.readObject();
				//Añadimos el paciente a la lista
				añadirPaciente(aux);
			}
		} catch(EOFException ex){}	
	}
	//ListaAlergias
	public static void exportarListaAlergias() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaAlergias.age"))){
			for (Alergia o: listaAlergias) {
				oos.writeObject(o);
			}
			System.out.println("La lista de pacientes se ha guardado con éxito en la ruta: listaAlergias.age");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importarListaAlergias() throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaAlergias.age"))) {
			Alergia aux;
			while (true) {
				aux= (Alergia)ois.readObject();
				añadirAlergia(aux);
			}
		} catch(EOFException ex){}	
	}
	//ListaEnfermeros
	public static void exportarListaEnfermeros() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaEnfermeros.age"))){
			for (Enfermero o: listaEnfermeros) {
				oos.writeObject(o);
			}
			System.out.println("La lista de pacientes se ha guardado con éxito en la ruta: listaEnfermeros.age");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importarListaEnfermeros() throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaEnfermeros.age"))) {
			Enfermero aux;
			while (true) {
				aux= (Enfermero)ois.readObject();
				añadirEnfermero(aux);
			}
		} catch(EOFException ex){}	
	}
	//ListaUsuarios
	public static void exportarListaUsuarios() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaUsuarios.age"))){
			for (Usuario o: listaUsuarios) {
				oos.writeObject(o);
			}
			System.out.println("La lista de pacientes se ha guardado con éxito en la ruta: listaUsuarios.age");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importarListaUsuarios() throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaUsuarios.age"))) {
			Usuario aux;
			while (true) {
				aux= (Usuario)ois.readObject();
				añadirUsuario(aux);
			}
		} catch(EOFException ex){}	
	}
	//ListaMedicos
	public static void exportarListaMedicos() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaMedicos.age"))){
			for (Medico o: listaMedicos) {
				oos.writeObject(o);
			}
			System.out.println("La lista de pacientes se ha guardado con éxito en la ruta: listaMedicos.age");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importarListaMedicos() throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaMedicos.age"))) {
			Medico aux;
			while (true) {
				aux= (Medico)ois.readObject();
				añadirMedico(aux);
			}
		} catch(EOFException ex){}	
	}
	//ListaEspecialidades
	public static void exportarListaEspecialidades() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaEspecialidades.age"))){
			for (Especialidad o: listaEspecialidades) {
				oos.writeObject(o);
			}
			System.out.println("La lista de pacientes se ha guardado con éxito en la ruta: listaEspecialidades.age");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importarListaEspecialidades() throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaEspecialidades.age"))) {
			Especialidad aux;
			while (true) {
				aux= (Especialidad)ois.readObject();
				añadirEspecialidad(aux);
			}
		} catch(EOFException ex){}	
	}
	//ListaHabitaciones
	public static void exportarListaHabitaciones() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaHabitaciones.age"))){
			for (Habitacion o: listaHabitaciones) {
				oos.writeObject(o);
			}
			System.out.println("La lista de pacientes se ha guardado con éxito en la ruta: listaHabitaciones.age");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importarListaHabitaciones() throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaHabitaciones.age"))) {
			Habitacion aux;
			while (true) {
				aux= (Habitacion)ois.readObject();
				añadirHabitacion(aux);
			}
		} catch(EOFException ex){}	
	}
	//ListaMedicamentos
	public static void exportarListaMedicamentos() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaMedicamentos.age"))){
			for (Medicamento o: listaMedicamentos) {
				oos.writeObject(o);
			}
			System.out.println("La lista de pacientes se ha guardado con éxito en la ruta: listaMedicamentos.age");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importarListaMedicamentos() throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaMedicamentos.age"))) {
			Medicamento aux;
			while (true) {
				aux= (Medicamento)ois.readObject();
				añadirMedicamento(aux);
			}
		} catch(EOFException ex){}	
	}
	//MedicoAdministrador
	public static void exportarMedicoAdministrador() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MedicoAdministrador.age"))){
			oos.writeObject(medicoAdministrador);
			System.out.println("La información del médico administrador se ha guardado con éxito en la ruta: MedicoAdministrador.age");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importarMedicoAdministrador() throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("MedicoAdministrador.age"))) {
			while (true) {
				medicoAdministrador= (MedicoAdministrador)ois.readObject();
			}
		} catch(EOFException ex){}	
	}
	//InventarioMedicamentos
	public static void exportarInventario() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("InventarioMedicamentos.age"))){
			oos.writeObject(inventarioMedicamentos);
			System.out.println("El inventario de medicamentos se ha guardado con éxito en la ruta: InventarioMedicamentos.age");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importarInventario() throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("InventarioMedicamentos.age"))) {

			while (true) {
				inventarioMedicamentos= (Inventario)ois.readObject();
			}
		} catch(EOFException ex){}	
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
	//	importarPacientesPlantillaCSV("pacientesNuevos.csv");
	
		//Prueba importar pacientes memoria persistente
		//exportarListaPacientes("listaPacientes.age");

		/*importarListas();
		//for (Paciente p: listaPacientes) {
			System.out.println(p.getNombre());
		}*/
		
		//exportarListas();

		






	}

}

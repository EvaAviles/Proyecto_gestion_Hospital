package control;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

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

public class ManejoFicheros implements Serializable {

	//ID Memoria persistente
	private static final long serialVersionUID = 149495058740209621L;

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

	public static void importarPacientesPlantillaCSV (String ruta, Sistema s){//Se ha probado y funciona :)
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
			String fechaNacimiento = pacientes[i][5];
			CharSequence fecha = fechaNacimiento;
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
			s.añadirPaciente(p);
		}
	}
	//Escribir la matriz en un fichero
	public static void escribirMatrizFichero(String ruta, String [][] datos) {
		FileWriter fichero;
		try {
			fichero = new FileWriter(ruta);
			// Escribimos linea a linea en el fichero
			for (int i=0; i<datos.length; i++) {
				for (int j=0; j<datos[0].length; j++) {
					
					if (j==datos[0].length-1) {	// Último valor sin ;
						fichero.write(datos[i][j]+"");
					}
					else {
						fichero.write(datos[i][j] + ";");
					}
				}
				fichero.write("\n");	// salto de línea al final de la fila
			}
			fichero.close();
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}
	//Exportar informe paciente (en un csv) FALTA PROBAR!
	public void exportarInformePaciente(Paciente p) {
		String datosPaciente[][] = new String[20][2];
		//En el caso de POO -> datosPaciente[1][1] = get.nombrePaciente;
		
		datosPaciente[0][0] = "Datos del paciente";
		datosPaciente[1][0] = "Primer apellido: ";
		datosPaciente[2][0] = "Segundo apellido:";
		datosPaciente[3][0] = "Nombre:";
		datosPaciente[4][0] = "DNI:";
		datosPaciente[5][0] = "Fecha nacimento:";
		datosPaciente[6][0] = "Sexo:";
		datosPaciente[7][0] = "Altura (cm)";
		datosPaciente[8][0] = "Peso (Kg):";
		datosPaciente[9][0] = "Grupo sanguíneo";
		datosPaciente[10][0] = "Historial médico";
		datosPaciente[11][0] = "Alergias";
		datosPaciente[12][0] = "Observaciones:";
		datosPaciente[13][0] = "Antecedentes familiares:";
		datosPaciente[14][0] = "Número de teléfono:";
		datosPaciente[15][0] = "Enfermero asignado:";
		datosPaciente[16][0] = "Médico asignado:";

		//Añadido con getters y setters
		datosPaciente[1][1] = p.getApellido1();
		datosPaciente[2][1] = p.getApellido2();
		datosPaciente[3][1] = p.getNombre();
		datosPaciente[4][1] = p.getDni();
		datosPaciente[5][1] = p.getFechaNacimiento();
		datosPaciente[6][1] = p.getSexo();
		datosPaciente[7][1] = p.getAltura();
		datosPaciente[8][1] = p.getPeso();
		datosPaciente[9][1] = p.getGrupoSanguineo();
		datosPaciente[10][1] = p.getHistorialMedico();
		datosPaciente[11][1] = p.getAlergias();
		datosPaciente[12][1] = p.getObservaciones();
		datosPaciente[13][1] = p.getAntecedentesFamiliares();
		datosPaciente[14][1] = p.getTelefono();
		
		//Falta completar los métodos de estas clases
		//datosPaciente[15][1] = p.getEnfermero();
		//datosPaciente[16][1] = p.getMedico();
		//datosPaciente[17][1] = p.getHabitacion();
		
		String ruta = "Informe_" + p.getDni() + ".csv";
		escribirMatrizFichero(ruta,datosPaciente); 
	}

	//Implementación de MEMORIA PERSISTENTE
	
	//Importar todas las listas
	public static void importarListas(Sistema s) {
		try {
			importarListaPacientes(s);
			importarListaAlergias(s);
			importarListaEnfermeros(s);
			importarListaUsuarios(s);
			importarListaMedicos(s);
			importarListaEspecialidades(s);
			importarListaHabitaciones(s);
			importarListaMedicamentos(s);
			importarMedicoAdministrador(s);
			importarInventario(s);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Exportar todas las listas
	public static void exportarListas (Sistema s) {
		exportarListaAlergias(s);
		exportarListaEnfermeros(s);
		exportarListaPacientes(s);
		exportarListaUsuarios(s);
		exportarListaMedicos(s);
		exportarListaEspecialidades(s);
		exportarListaHabitaciones(s);
		exportarListaMedicamentos(s);
		exportarInventario(s);
		exportarMedicoAdministrador(s);
	}
	
	//ListaPacientes
	public static void exportarListaPacientes(Sistema s) {
		//Se rodea de un try-catch para gestionar los posibles errores
		//Con ObjectOutputStream instanciamos un tipo de "scanner" para leer el fichero
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaPacientes.age"))){
			//Recorremos nuestra lista de pacientes
			for (Paciente o: s.getListaPacientes()) {
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

	public static void importarListaPacientes(Sistema s) throws IOException, ClassNotFoundException{
		//Con ObjectInputStream instanciamos un tipo de "scanner" con el que leeremos el fichero
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaPacientes.age"))) {
			//Creamos un paciente auxiliar
			Paciente aux;
			//Mientras haya texto (true) leemos el fichero
			while (true) {
				//En el paciente aux guardamos el objeto que leemos, le hacemos cast de Paciente
				aux= (Paciente)ois.readObject();
				//Añadimos el paciente a la lista
				s.añadirPaciente(aux);
			}
		} catch(EOFException ex){}	
	}
	//ListaAlergias
	public static void exportarListaAlergias(Sistema s) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaAlergias.age"))){
			for (Alergia o: s.getListaAlergias()) {
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

	public static void importarListaAlergias(Sistema s) throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaAlergias.age"))) {
			Alergia aux;
			while (true) {
				aux= (Alergia)ois.readObject();
				s.añadirAlergia(aux);
			}
		} catch(EOFException ex){}	
	}

	//ListaEnfermeros
	public static void exportarListaEnfermeros(Sistema s) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaEnfermeros.age"))){
			for (Enfermero o: s.getListaEnfermeros()) {
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

	public static void importarListaEnfermeros(Sistema s) throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaEnfermeros.age"))) {
			Enfermero aux;
			while (true) {
				aux= (Enfermero)ois.readObject();
				s.añadirEnfermero(aux);
			}
		} catch(EOFException ex){}	
	}

	//ListaUsuarios
	public static void exportarListaUsuarios(Sistema s) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaUsuarios.age"))){
			for (Usuario o: s.getListaUsuarios()) {
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

	public static void importarListaUsuarios(Sistema s) throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaUsuarios.age"))) {
			Usuario aux;
			while (true) {
				aux= (Usuario)ois.readObject();
				s.añadirUsuario(aux);
			}
		} catch(EOFException ex){}	
	}

	//ListaMedicos
	public static void exportarListaMedicos(Sistema s) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaMedicos.age"))){
			for (Medico o: s.getListaMedicos()) {
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

	public static void importarListaMedicos(Sistema s) throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaMedicos.age"))) {
			Medico aux;
			while (true) {
				aux= (Medico)ois.readObject();
				s.añadirMedico(aux);
			}
		} catch(EOFException ex){}	
	}

	//ListaEspecialidades
	public static void exportarListaEspecialidades(Sistema s) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaEspecialidades.age"))){
			for (Especialidad o: s.getListaEspecialidades()) {
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

	public static void importarListaEspecialidades(Sistema s) throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaEspecialidades.age"))) {
			Especialidad aux;
			while (true) {
				aux= (Especialidad)ois.readObject();
				s.añadirEspecialidad(aux);
			}
		} catch(EOFException ex){}	
	}

	//ListaHabitaciones
	public static void exportarListaHabitaciones(Sistema s) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaHabitaciones.age"))){
			for (Habitacion o: s.getListaHabitaciones()) {
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

	public static void importarListaHabitaciones(Sistema s) throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaHabitaciones.age"))) {
			Habitacion aux;
			while (true) {
				aux= (Habitacion)ois.readObject();
				s.añadirHabitacion(aux);
			}
		} catch(EOFException ex){}	
	}

	//ListaMedicamentos
	public static void exportarListaMedicamentos(Sistema s) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaMedicamentos.age"))){
			for (Medicamento o: s.getListaMedicamentos()) {
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

	public static void importarListaMedicamentos(Sistema s) throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("listaMedicamentos.age"))) {
			Medicamento aux;
			while (true) {
				aux= (Medicamento)ois.readObject();
				s.añadirMedicamento(aux);
			}
		} catch(EOFException ex){}	
	}

	//MedicoAdministrador
	public static void exportarMedicoAdministrador(Sistema s) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MedicoAdministrador.age"))){
			oos.writeObject(s.getMedicoAdministrador());
			System.out.println("La información del médico administrador se ha guardado con éxito en la ruta: MedicoAdministrador.age");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importarMedicoAdministrador(Sistema s) throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("MedicoAdministrador.age"))) {
			while (true) {
				MedicoAdministrador auxiliar = (MedicoAdministrador)ois.readObject();
				s.setMedicoAdministrador(auxiliar);
			}
		} catch(EOFException ex){}	
	}
	
	//InventarioMedicamentos
	public static void exportarInventario(Sistema s) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("InventarioMedicamentos.age"))){
			oos.writeObject(s.getInventarioMedicamentos());
			System.out.println("El inventario de medicamentos se ha guardado con éxito en la ruta: InventarioMedicamentos.age");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importarInventario(Sistema s) throws IOException, ClassNotFoundException{
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream ("InventarioMedicamentos.age"))) {

			while (true) {
				Inventario aux = (Inventario)ois.readObject();
				s.setInventarioMedicamentos(aux);
			}
		} catch(EOFException ex){}	
	}

}

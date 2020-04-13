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
		
		
		

	}

}

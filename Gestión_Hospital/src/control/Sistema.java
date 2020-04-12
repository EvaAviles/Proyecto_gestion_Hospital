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
	private Alergia listaAlergias[];
	private Enfermero listaEnfermeros[];
	private Usuario listaUsuarios[];
	private Medico listaMedicos[];
	private MedicoAdministrador medicoAdministrador;
	private Especialidad listaEspecialidades[];
	private Habitacion listaHabitaciones[];
	private Medicamento listaMedicamentos[];
	private Inventario inventarioMedicamentos[];
	private ArrayList <Paciente>listaPacientes;

	//Métodos
	public static void importarInformacion() {

	}

	public static void avisoBajoInventario() {

	}

	public static void avisoCaducidad() {

	}

	public static Paciente buscarPacienteNombre(String nombre) {

		//Hago un iterador para poder recorrer mi ArrayList	
		boolean busqueda= false;	
		
		//Recorro el arrayList		
		for(int i = 0 ; (i <listaPacientes.size()) && (busqueda==false);i++) {
			if(nombre.contentEquals(listaPacientes.get(i).getNombre())) {
				busqueda=true;
				return listaPacientes.get(i);
			} 
			else {
				System.out.println("No se encuentra ningún paciente con el nombre " +nombre + ".");    
			}
		}
	}

	public static void buscarMedicamento() {

	}

	public static void buscarUsuario() {

	}

	public static void iniciarSesion() {

	}

	//MAIN
	public static void main(String[] args) {
		


	}

}

package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Receta {

	//Atributos
	private Date fechaCreada;
	private String descripcion;
	private int numeroDosis;
	private int intervaloHoras;

	//Relaciones 
	private Medico medico;
	private Paciente paciente;
	private ArrayList <Suministro> listaSuministros= new ArrayList<>();
	private Medicamento medicamento;

	//Getters y setters
	public Date getFechaCreada() {
		return fechaCreada;
	}
	public void setFechaCreada(Date fechaCreada) {
		this.fechaCreada = fechaCreada;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNumeroDosis() {
		return numeroDosis;
	}
	public void setNumeroDosis(int numeroDosis) {
		this.numeroDosis = numeroDosis;
	}
	public int getIntervaloHoras() {
		return intervaloHoras;
	}
	public void setIntervaloHoras(int intervaloHoras) {
		this.intervaloHoras = intervaloHoras;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public ArrayList<Suministro> getListaSuministros() {
		return listaSuministros;
	}
	public void setListaSuministros(ArrayList<Suministro> listaSuministros) {
		this.listaSuministros = listaSuministros;
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
	//Métodos
	public void crearReceta (String descripcion, int numDosis, int intervaloHoras, Medico medico, Paciente paciente, Medicamento medicamento ) { //Realmente esto es como un contructor de Receta
		//La idea es que por consola se pidan y validen los datos, y después pasarle los datos a este método
		//Comprobamos las alergías
		if(medicamento.comprobarAlergías(paciente)==false) {//Si no hay ninguna coincidencia...
			//Hora de generar los suministros deacuerdo con la prescripción (interválo de horas y número de dosis)
			//Para poder generar los suministros, tenemos que comprobar que existen X unidades disponibles del medicamento (numDosis)
			if(medicamento.comprobarUnidadesDisponibles(numDosis)==true) {//Si existen...
				//Rellenamos los datos de la receta, para ello, creamos una nueva receta:
				Receta r = new Receta();
				//Asignamos el médico
				r.setMedico(medico);
				//Asignamos el paciente
				r.setPaciente(paciente);
				//Asignamos el medicamento
				r.setMedicamento(medicamento);
				//Asignamos la descripción
				r.setDescripcion(descripcion);
				//Asignamos la fecha de creación
				Date fecha = new Date (); //Esto nos devuelve la fecha y hora de el instante en que se crea
				r.setFechaCreada(fecha);
				//Tenemos que tener en cuenta que las fechas en las que se asignan los suministros se generan automáticamente,
				//teniendo en cuenta la fecha en la que se creó la receta
				//Usando la clase Calendar, podremos sumarle horas a la fecha
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				Date tempDate = cal.getTime();
				//Una vez validadas las unidades disponibles y las alergías, podemos generar los suministros:
				for (int i =0; i<numDosis; i++) {
					Suministro s = new Suministro ();
					//Asignamos la fecha en la que se debe crear el suministro
					//Para ello a la fecha que hemos creado antes, le vamos sumando el intervalo de horas
					//Le cambiamos las horas
					cal.set(Calendar.HOUR, cal.get(Calendar.HOUR)+ intervaloHoras);
					tempDate = cal.getTime();
					//Le pasamos todos los datos al método crearSuministro
					s.crearSuministro(tempDate, (medicamento.asignarUnidad()), r, paciente);
					//Guardamos el suministro en el enfermero asignado al paciente y el paciente
					paciente.getEnfermero().añadirSuministro(s);
					paciente.añadirSuministro(s);
					//Incrementamos el intervalo
					intervaloHoras = intervaloHoras + intervaloHoras;
				}
				//Finalmente, completamos las relaciones de la receta, es decir:
				//Añadimos la receta a la listaRecetas del paciente
				paciente.añadirReceta(r);
				//Añadimos la receta a la lista de recetas del médico
				medico.añadirReceta(r);
				//Damos feedback de que ya se ha completado la receta
				System.out.println("La receta se ha creado con éxito.");
			} else {
				//Le damos feedback al médico
				System.out.println("Lo sentimos pero no se puede recetar este medicamento, ya que no existen suficientes unidades disponibles en este momento. Consulte con el médico administrador para más información.");
			}
		} else {
			//Si existe una coincidencia le damos feedback al médico
			System.out.println("No puede recetar el medicamento "+medicamento.getNombre()+" a este paciente, ya que es alérgico.");
		}
	}
	
	public static void eliminarReceta() {
		
	}
	
	public static void comprobarAlergías() {
		
	}
	
}

package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import control.Sistema;

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

	//M�todos
	public void crearReceta (Medico medico, Paciente paciente) { 
		Scanner teclado = new Scanner(System.in);
		int posicion=0;
		if (paciente.getIngresado()==true) {//Si el paciente no est� ingresado, no se puede realizar la receta
			if (paciente.getEnfermero()==null) {//Si un paciente no tiene asignado un enfermero, no se podr� crear una Receta
				System.out.println("Lo sentimos, no se puede recetar un medicamento a este paciente porque no tiene un enfermero asignado");
			} else {//Si tiene un Enfermero asignado, seguimos
				//Hacemos que el m�dico busque el medicamento:
				String nombreMed = "";
				boolean salir=false;
				while (teclado.hasNextLine()&&salir==false) {
					System.out.print("Introduzca el nombre del medicamento (s:salir): ");
					if (teclado.hasNextLine()) {
						String confirmacion="";
						nombreMed=teclado.nextLine();
						if (nombreMed.contentEquals("S")) {
							salir=true;
						}else {
							if (Sistema.buscarMedicamentoNombre(nombreMed)==-1){
								System.out.println("No se ha encontrado ning�n medicamento con el nombre: "+nombreMed);
								
							} else {
								posicion = Sistema.buscarMedicamentoNombre(nombreMed);
								System.out.println("Se ha encontrado el medicamento: "+Sistema.listaMedicamentos.get(posicion).getNombre());
								System.out.println("�Es este el medicamento que buscaba? (s: si, n: no) ");
								confirmacion=teclado.nextLine().toUpperCase();
								if (confirmacion.contentEquals("SI")) {
									salir=true;
								}
								
							}
						} 

					} else {
						System.out.println("El par�metro introducido no es v�lido.");
						teclado.nextLine();//Para que el programa no de errores
					}
				}

				if(nombreMed.contentEquals("S")) {
					System.out.println("Ha solicitado salir.");
				} else {
					
					//Comprobamos las alerg�as
					if(Sistema.listaMedicamentos.get(posicion).comprobarAlerg�as(paciente)==false) {//Si no hay ninguna coincidencia...
						//Hora de generar los suministros deacuerdo con la prescripci�n (interv�lo de horas y n�mero de dosis)
						//Para poder generar los suministros, tenemos que comprobar que existen X unidades disponibles del medicamento (numDosis)
						//Le pedimos al m�dico el n�m de dosis
						boolean parar = false;
						int numDosis=0;
						while (teclado.hasNext()&&parar==false) {
							System.out.print("Introduzca el n�mero de dosis: ");
							if (teclado.hasNextInt()) {
								if(numDosis>0) {
									numDosis= teclado.nextInt();
									parar=true;
								}else {
									System.out.println("El n�mero de dosis debe ser positivo.");
								}
							} else {
								System.out.println("El valor introducido no es v�lido.");
								teclado.nextLine();
							}
						}
						if(Sistema.listaMedicamentos.get(posicion).comprobarUnidadesDisponibles(numDosis)==true) {//Si existen...
							//Le pedimos al m�dico el int�rvalo de horas y la descripci�n
							int intervaloHoras=0;
							boolean salga=false;
							while (teclado.hasNext()&&salga==false) {
								System.out.print("Introduzca el int�rvalo de horas: ");
								if (teclado.hasNextInt()) {
									if(intervaloHoras>0) {
										intervaloHoras= teclado.nextInt();
										salga=true;
									}else {
										System.out.println("El n�mero de dosis debe ser positivo.");
										intervaloHoras=0;
									}
								} else {
									System.out.println("El valor introducido no es v�lido.");
									intervaloHoras=0;
									teclado.nextLine();
								}
							}
							String descripcion ="";
							System.out.print("Introduzca una descripci�n: ");
							descripcion= teclado.nextLine();
							
							//Rellenamos los datos de la receta, para ello, creamos una nueva receta:
							Receta r = new Receta();
							//Asignamos el m�dico
							r.setMedico(medico);
							//Asignamos el paciente
							r.setPaciente(paciente);
							//Asignamos el medicamento
							r.setMedicamento(Sistema.listaMedicamentos.get(posicion));
							//Asignamos la descripci�n
							r.setDescripcion(descripcion);
							//Asignamos la fecha de creaci�n
							Date fecha = new Date (); //Esto nos devuelve la fecha y hora de el instante en que se crea
							r.setFechaCreada(fecha);
							
							//Tenemos que tener en cuenta que las fechas en las que se asignan los suministros se generan autom�ticamente,
							//teniendo en cuenta la fecha en la que se cre� la receta
							//Usando la clase Calendar, podremos sumarle horas a la fecha
							Calendar cal = Calendar.getInstance();
							cal.setTime(new Date());
							Date tempDate = cal.getTime();
							//Una vez validadas las unidades disponibles y las alerg�as, podemos generar los suministros:
							for (int i =0; i<numDosis; i++) {
								Suministro s = new Suministro ();
								//Asignamos la fecha en la que se debe crear el suministro
								//Para ello a la fecha que hemos creado antes, le vamos sumando el intervalo de horas
								//Le cambiamos las horas
								cal.set(Calendar.HOUR, cal.get(Calendar.HOUR)+ intervaloHoras);
								tempDate = cal.getTime();
								//Le pasamos todos los datos al m�todo crearSuministro
								s.crearSuministro(tempDate, (medicamento.asignarUnidad()), r, paciente);
								//Guardamos el suministro en el enfermero asignado al paciente y el paciente
								paciente.getEnfermero().a�adirSuministro(s);
								paciente.a�adirSuministro(s);
								//Incrementamos el intervalo
								intervaloHoras = intervaloHoras + intervaloHoras;
								//Asignamos el ID
								s.setId(paciente.getEnfermero().getGeneradorID()+1);
								//Cambiamos el generador ID
								paciente.getEnfermero().incrementarID();
							}
							
							//Finalmente, completamos las relaciones de la receta, es decir:
							//A�adimos la receta a la listaRecetas del paciente
							paciente.a�adirReceta(r);
							//A�adimos la receta a la lista de recetas del m�dico
							medico.a�adirReceta(r);
							//Damos feedback de que ya se ha completado la receta
							System.out.println("La receta se ha creado con �xito.");
							
						} else {
							//Le damos feedback al m�dico
							System.out.println("Lo sentimos pero no se puede recetar este medicamento, ya que no existen suficientes unidades disponibles en este momento.");
							System.out.println("Consulte con el m�dico administrador para m�s informaci�n.");
						}
					} else {
						//Si existe una coincidencia le damos feedback al m�dico
						System.out.println("No puede recetar el medicamento "+medicamento.getNombre()+" a este paciente, ya que es al�rgico.");
					}	
				}
			}
		} else {
			System.out.println("Lo sentimos, no se puede recetar un medicamento a este paciente porque no est� ingresado.");
		}

		teclado.close();
	}

	public static void eliminarReceta() {

	}

	public static void comprobarAlerg�as() {

	}

}

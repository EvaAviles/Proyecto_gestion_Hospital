package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import control.Sistema;
public class Medicamento implements Serializable{

	//ID Memoria Persistente
	private static final long serialVersionUID = -5502406172604608229L;

	//Atributos
	private String nombre;
	private int stockDeseado;
	private int stockDisponible;
	private Double precioUnidad;
	private String dosis;

	//Relaciones
	private Inventario inventario;
	private ArrayList <Unidad> listaUnidades= new ArrayList<>() ;
	private ArrayList <RegistroConsumo> listaRegistroConsumo= new ArrayList<>();
	private Estad�sticaMedicamentos estadistica;
	private ArrayList <Alergia> listaAlergias= new ArrayList<>();


	public Medicamento(String nombre, int stockDeseado, int stockDisponible, double precioUnidad, String dosis) {

		this.nombre=nombre;
		this.stockDeseado=stockDeseado;
		this.stockDisponible=stockDisponible;
		this.precioUnidad= precioUnidad;
		this.dosis=dosis;
		
		//Se deben crear las unidades con esa fecha de caducidad!!!, as� que le tenemos que pedir la fecha de caducidad de 
		//las unidades que introduce
	}
	
	public String nombreMasyusculas(String nombre) {
		char[]caracteres=nombre.toCharArray();
		caracteres[0]=Character.toUpperCase(caracteres[0]);
		return new String (caracteres);
	}


	@Override
	public String toString() {
		return "Medicamento: " + nombreMasyusculas(nombre) + "\nStockDeseado: " + stockDeseado + ", StockDisponible: "
				+ stockDisponible + ", Precio por unidad: " + precioUnidad + ", Dosis por unidad: " + dosis + ".";
	}
	
	public void eliminarUnidad(Unidad u) {
		this.listaUnidades.remove(u);
	}


	//Getters y setters

	public Medicamento() {

	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStockDeseado() {
		return stockDeseado;
	}
	public void setStockDeseado(int stockDeseado) {
		this.stockDeseado = stockDeseado;
	}
	public int getStockDisponible() {
		return stockDisponible;
	}
	public void setStockDisponible(int stockDisponible) {
		this.stockDisponible = stockDisponible;
	}
	public Double getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(Double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public String getDosis() {
		return dosis;
	}
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	public Inventario getInventario() {
		return inventario;
	}
	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	public ArrayList<Unidad> getListaUnidades() {
		return listaUnidades;
	}
	public void setListaUnidades(ArrayList<Unidad> listaUnidadesDisponibles) {
		this.listaUnidades = listaUnidadesDisponibles;
	}
	public ArrayList<RegistroConsumo> getListaRegistroConsumo() {
		return listaRegistroConsumo;
	}
	public void setListaRegistroConsumo(ArrayList<RegistroConsumo> listaRegistroConsumo) {
		this.listaRegistroConsumo = listaRegistroConsumo;
	}
	public Estad�sticaMedicamentos getEstadistica() {
		return estadistica;
	}
	public void setEstadistica(Estad�sticaMedicamentos estadistica) {
		this.estadistica = estadistica;
	}
	public ArrayList<Alergia> getListaAlergias() {
		return listaAlergias;
	}
	public void setListaAlergias(ArrayList<Alergia> listaAlergias) {
		this.listaAlergias = listaAlergias;
	}

	public void a�adirRegistroConsumo (RegistroConsumo s) {
		listaRegistroConsumo.add(s);
	}

	public void a�adirAlergia(Alergia a) {
		listaAlergias.add(a);
	}

	public void a�adirUnidad (Unidad a) {
		listaUnidades.add(a);
	}


	public Boolean comprobarAlerg�as (Paciente p) {//Funciona correctamente
		Boolean coincidencia = false;
		for (Alergia a: listaAlergias) {
			for (Alergia b: p.getListaAlergias()) {
				if (b.compareTo(a)==0) {
					coincidencia = true; //Si hay una coincidencia, devuelve un true
				}
			}
		}
		return coincidencia;
	}

	public Boolean comprobarUnidadesDisponibles (int numDosis) {
		int unidadesDisponibles=0;
		Boolean existen = false; //Por defecto no hay sufiecientes unidades (suposici�n)
		//Recorremos la lista de Unidades del medicamento
		for (Unidad u: listaUnidades) {
			if (u.getDisponible()==true) {
				unidadesDisponibles++;//Contamos la unidad si est� disponible
			}
		}
		//Si hay m�s o iguales unidades disponibles que el numDosis devolvemos un true
		if (unidadesDisponibles >= numDosis) {
			existen=true;
		}
		return existen;
	}

	public Unidad asignarUnidad () {
		//Primero ordenamos la lista de unidades por fecha
		//De esta forma asignamos primero la unidad que caduca antes
		Collections.sort(getListaUnidades());
		//Recorremos la lista de unidades
		int posicion = -1;
		int i;
		for (i=0;i <getListaUnidades().size();i++) {   
			if(listaUnidades.get(i).getDisponible()==true) {   
				posicion=i;
				//Especificamos que la unidad no est� disponible
				listaUnidades.get(i).setDisponible(false);
				i=getListaUnidades().size();
			} 
		}

		return listaUnidades.get(posicion);//Devolvemos esa unidad
	}


	public static void avisoCaducidad() {

	}

	//M�todo buscar medicamento por su nombre
	public int buscarMedicamento(String nombre) { //como par�metro le damos el nombre del medicamento

		int posicion=-1; //inicializo la variable a -1, para que si me da este valor sepa que algo va mal

		for (int i = 0 ; i <Sistema.listaMedicamentos.size();i++) {    //recorro el ArrayList
			if(nombre.toLowerCase().equals(Sistema.listaMedicamentos.get(i).getNombre())) {    //si el nombre del medicamento buscado es igual a alguno del array, 
				posicion=i;                                                            //me da la posici�n de donde est� en mi lista de medicamentos  
			} 
		} if (posicion==-1) {
			System.out.println("Lo siento, pero no se encuentra este medicamento");
		}
		return posicion;// Si se devuelve -1 no se ha encontrado nada
	}

	public void verMedicamento(int posicionArray){
		System.out.println(Sistema.listaMedicamentos.get(posicionArray).toString()); //Imprimo el medicamento buscado con mi m�todo to String
		//al get le doy como par�metro la posici�n del medicamento que se ha buscado
		if (posicionArray==-1) {
			System.out.println("Lo siento, pero no se encuentra este medicamento");
		}
	}


	public void a�adirMedicamento () { //A�adir un medicamento		

		Medicamento m=new Medicamento();   //Creo un nuevo medicamento
		String respuesta;
		Scanner teclado= new Scanner(System.in);
		do {
			System.out.println("Introduzca el nombre del medicamento: ");
			m.setNombre(nombre=teclado.nextLine().toLowerCase());

			System.out.println("Introduzca el stock deseado del medicamento: ");
			m.setStockDeseado(stockDeseado=teclado.nextInt());
			do {                       //El stock deseado es el m�nimo que queremos tener, por eso obligo al usuario a que el stock disponible sea mayor
				System.out.println("Introduzca el stock disponible del medicamento: ");
				m.setStockDisponible(stockDisponible=teclado.nextInt());
				if(stockDisponible<stockDeseado) {
					System.out.println("El stock disponible debe ser mayor que el deseado");
				}
			} while(stockDisponible<stockDeseado);

			System.out.println("Introduzca el precio por unidad del medicamento: ");
			m.setPrecioUnidad(precioUnidad=teclado.nextDouble());		

			System.out.println("Introduzca la dosis por unidad del medicamento: ");
			m.setDosis(dosis=teclado.next());

			System.out.println("�Es el siguiente medicamento el que desea a�adir?\n"+m.toString());  //Ense�o al usuario el medicamento completo que quer�a a�adir
			respuesta=teclado.next();
			teclado.nextLine();

		} while (!respuesta.equals("si"));
		Sistema.listaMedicamentos.add(m); //Si la respuesta es si, el medicamento se a�adir� en la lista de medicamentos.  
		teclado.close();
	}


	/*	public void editarMedicamento(Medicamento a) {
		Scanner teclado= new Scanner (System.in);
		String edicion;
		String respuesta= null;
		do {
			System.out.println("�Qu� desea editar del medicamento?\n"
					+ "\ta)Nombre\n\tb)Stock deseado\n\tc)Stock disponible\n\td)Precio\n\te)Dosis por unidad");
			edicion=teclado.nextLine();
			switch (edicion){
			case "nombre":
				System.out.println("�Qu� nombre desea asinar a este medicamento?");
				a.setNombre(nombre=teclado.next());
				System.out.println("�Desea cambiar algo m�s?");
				respuesta=teclado.next();
				teclado.hasNextLine();
				break;

			}
		}while(!respuesta.equals("no"));
	}*/

	
	public static void a�adirStock() {

	}
	public static void descontarStock() {

	}
	public static void a�adirUnidades() {

	}

	public void avisoBajoStock() {

		for(int i=0; i<Sistema.listaMedicamentos.size();i++) {

			if(Sistema.listaMedicamentos.get(i).getStockDisponible()< 
					Sistema.listaMedicamentos.get(i).getStockDeseado()) {

				System.out.print("AVISO IMPORTANTE el f�rmaco "+ Sistema.listaMedicamentos.get(i).getNombre().toString()
						+" est� "+ "por debajo del stock deseado le recomendamos que lo reponga urgentemente");
			}
		}
	}

}

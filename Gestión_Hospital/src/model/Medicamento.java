package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

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
	private EstadísticaMedicamentos estadistica;
	private ArrayList <Alergia> listaAlergias= new ArrayList<>();
	
	//Getters y setters
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
	public EstadísticaMedicamentos getEstadistica() {
		return estadistica;
	}
	public void setEstadistica(EstadísticaMedicamentos estadistica) {
		this.estadistica = estadistica;
	}
	public ArrayList<Alergia> getListaAlergias() {
		return listaAlergias;
	}
	public void setListaAlergias(ArrayList<Alergia> listaAlergias) {
		this.listaAlergias = listaAlergias;
	}
	
	public void añadirRegistroConsumo (RegistroConsumo s) {
		listaRegistroConsumo.add(s);
	}
	
	public void añadirAlergia(Alergia a) {
		listaAlergias.add(a);
	}
	
	public void añadirUnidad (Unidad a) {
		listaUnidades.add(a);
	}
	
	
	//Métodos
	
	public Boolean comprobarAlergías (Paciente p) {//Funciona correctamente
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
		Boolean existen = false; //Por defecto no hay sufiecientes unidades (suposición)
		//Recorremos la lista de Unidades del medicamento
		for (Unidad u: listaUnidades) {
			if (u.getDisponible()==true) {
				unidadesDisponibles++;//Contamos la unidad si está disponible
			}
		}
		//Si hay más o iguales unidades disponibles que el numDosis devolvemos un true
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
				//Especificamos que la unidad no está disponible
				listaUnidades.get(i).setDisponible(false);
				i=getListaUnidades().size();
			} 
		}
		return listaUnidades.get(posicion);//Devolvemos esa unidad
		
	}
	
	public static void avisoCaducidad() {

	}
	
	public static void mostrarMedicamento() {

	}
	public static void crearMedicamento() {

	}
	public static void editarMedicamento() {

	}
	public static void borrarMedicamento() {

	}
	public static void añadirStock() {

	}
	public static void descontarStock() {

	}
	public static void añadirUnidades() {

	}
	public static void avisoBajoStock() {

	}
}

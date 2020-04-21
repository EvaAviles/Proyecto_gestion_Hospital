package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
	/*public Boolean gastarUnidad (Medicamento m) {
		
	}*/
	
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
		int i=0;
		Boolean asignado=false;
		//Vamos a recorrer la lista de unidades con un iterador:
		Iterator<Unidad> it = listaUnidades.iterator();
		while(it.hasNext() && asignado==false){
			Unidad u = it.next();
			if (u.getDisponible()==true) {
				//Cambiamos la disponibilidad de la unidad
				u.setDisponible(false);
				//Además, descontamos una unidad disponible en el stock
				setStockDisponible(getStockDisponible()-1);
				i=buscarUnidadID(u.getIdentificador());
			}
		}
		return listaUnidades.get(i);//Devolvemos esa unidad
		
	}
	
	public int buscarUnidadID(String ID) {
		int posicion =0;
		for (int i = 0 ; i <listaUnidades.size();i++) {    //recorro el ArrayList
			if(nombre.equals(listaUnidades.get(i).getIdentificador())) {    //si el dni es igual a alguno del array, me da la posición
				posicion=i;
				i=listaUnidades.size();	
			} 
		}
		return posicion;
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

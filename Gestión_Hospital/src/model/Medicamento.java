package model;

import java.io.Serializable;
import java.util.ArrayList;

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
	private ArrayList <Unidad> listaUnidadesDisponibles= new ArrayList<>() ;
	private ArrayList <Unidad> listaUnidadesNoDisponibles= new ArrayList<>() ;
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
	public ArrayList<Unidad> getListaUnidadesDisponibles() {
		return listaUnidadesDisponibles;
	}
	public void setListaUnidadesDisponibles(ArrayList<Unidad> listaUnidadesDisponibles) {
		this.listaUnidadesDisponibles = listaUnidadesDisponibles;
	}
	public ArrayList<Unidad> getListaUnidadesNoDisponibles() {
		return listaUnidadesNoDisponibles;
	}
	public void setListaUnidadesNoDisponibles(ArrayList<Unidad> listaUnidadesNoDisponibles) {
		this.listaUnidadesNoDisponibles = listaUnidadesNoDisponibles;
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
	
	public void añadirUnidadDisponible (Unidad a) {
		listaUnidadesDisponibles.add(a);
	}
	
	public void añadirUnidadNoDisponible (Unidad a) {
		listaUnidadesNoDisponibles.add(a);
	}
	
	//Métodos
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

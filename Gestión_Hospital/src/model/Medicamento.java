package model;

public class Medicamento {

	private String nombre;
	private int stockDeseado;
	private int stockDisponible;
	private Double precioUnidad;
	private String dosis;
	
	//Relaciones
	private Inventario inventario;
	private Unidad listaUnidadesDisponibles;
	private Unidad listaUnidadesNoDisponibles;
	private RegistroConsumo listaRegistroConsumo[];
	private EstadísticaMedicamentos estadistica;
	private Alergia listaAlergias[];
	
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

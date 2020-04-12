package model;

public class Usuario extends Paciente{

	
	private String login;
	private String password;

	//Relaciones
	private Especialidad especialidad;

	//Getters y setters
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	//Métodos
	
	public static void eliminarUsuario() {

	}
	public static void crearUsuario() {

	}
	
	public Usuario(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}
}

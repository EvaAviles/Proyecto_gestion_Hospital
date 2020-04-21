package model;
import javax.swing.JOptionPane;
import java.io.Serializable;

public class  Usuario implements Serializable{ 

	private String usuario; //este será el número de empleado

	//ID Memoria Persistente
	private static final long serialVersionUID = 5329259474600388330L;
	private String login;
	private String password;

	//Relaciones
	private Especialidad especialidad;

	//Constructor
	public Usuario(String usuario, String password){
		this.usuario=usuario;
		this.password=password;
	}

	//Getters y setters
	public String getUsuario() {
		return usuario;
	}
	public void setusuario(String usuario) {
		this.usuario = usuario;
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

}

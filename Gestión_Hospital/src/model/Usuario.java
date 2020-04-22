package model;

import java.io.Serializable;

public class Usuario implements Serializable{

	//ID Memoria Persistente
	private static final long serialVersionUID = 5329259474600388330L;
	private String login;
	private String password;

	//Relaciones
	private Especialidad especialidad;

	//Getters y setters
	public Usuario (String login, String password) {
		this.login=login;
		this.password= password;
	}
	
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

}

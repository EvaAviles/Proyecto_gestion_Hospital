package model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class  Usuario {

	private String usuario; //este ser� el n�mero de empleado
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

	//M�todos

	public static void eliminarUsuario() {

	}
	public static void crearUsuario() {

	}

}

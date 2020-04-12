package model;

public class MedicoAdministrador extends Medico{

	

	//Atributos
	private String email;

	//Getters y setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//Métodos
	public static void interfazMedicoAdministrador() {

	}
	
	public MedicoAdministrador(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

}

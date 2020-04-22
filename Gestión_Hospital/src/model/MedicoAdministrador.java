package model;

public class MedicoAdministrador extends Medico{

	
	private static final long serialVersionUID = -3812304402437247591L;
	
	//Atributos
	protected String email;

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
	
	public MedicoAdministrador(String login, String password) {
		super(login, password);

	}

}

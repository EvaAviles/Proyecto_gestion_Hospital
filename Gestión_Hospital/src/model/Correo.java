package model;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Correo {

	private final Properties prop = new Properties();
	//Dónde guardaremos la info de inicio de sesion
	private Session session;
	//Atributos que usaremos para enviar el correo
	private String password = "vivaMallorca2020";
	private String miEmail = "the.biofix@gmail.com";
	private String nombreUsuario = "Biofix Company";
	private String destinatario = "mmateupons272@gmail.com";

	public Correo() {
		
	}
	
	private void init() {
		prop.put("mail.smtp.host", "mail.gmail.com");//host que accede al servidor de correo
		prop.put("mail.transport.protocol","smtp");//Protocolo de comunicación usado para enviar el mail (en este caso SMTP)
		prop.put("mail.smtp.starttls.enable", "true");//Cambia la conexión a una protegida (TLS)
		prop.put("mail.smtp.port",25);//El puerto SMTP a través del cual se establece la conexion (25 por defecto)
		prop.put("mail.smtp.mail.sender", miEmail);
		prop.put("mail.smtp.user", nombreUsuario);
		prop.put("mail.smtp.auth", "true");//indica si se requiere una autenticación de SMTP
		//Meter la info de inicio de sesión en una variable
		session = Session.getDefaultInstance(prop);
	}//init

	public void sendEmail(){
		//para poder usar la variable session devuelta por init()
		init();
		try{
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress((String)prop.get("mail.smtp.mail.sender")));//Obtiene la direcci
			//msg.addRecipient(Message.RecipientType.TO, new InternetAddress("receptor@gmail.com"));
			msg.addRecipients(Message.RecipientType.TO, new InternetAddress[] { new InternetAddress(destinatario) });
			msg.setSubject("Prueba"); //asunto
			msg.setText("Texto"); //contenido mail
			Transport t = session.getTransport("smtp");
			t.connect((String)prop.get("mail.smtp.user"), password);
			t.sendMessage(msg, msg.getAllRecipients());
			t.close();
		}catch (MessagingException me){
			System.out.println(me); //imprime errror
			return;
		}

	}
}


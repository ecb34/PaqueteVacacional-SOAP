
/**
 * NotificacionSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package org.mtis.www.notificacion;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * NotificacionSkeleton java skeleton for the axisService
 */
public class NotificacionSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @param email
	 * @return emailResponse
	 */

	public org.mtis.www.notificacion.EmailResponse email(org.mtis.www.notificacion.Email email) {
		// Recipient's email ID needs to be mentioned.
        String to = email.getEmail();

        // Sender's email ID needs to be mentioned
        String from = "sendermtis@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("sendermtis@gmail.com", "mtissender2020");

            }

        });
        
     // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Reserva realizada");

            // Now set the actual message
            message.setText("Buenos días, su reserva con id " + email.getIdReserva() + " ha sido realizada correctamente");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
            EmailResponse response = new EmailResponse();
            response.setEnviado(true);
            return response;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            EmailResponse response = new EmailResponse();
            response.setEnviado(false);
            response.setCodigoError(400);
            return response;
        }
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param mensajeError
	 * @return mensajeErrorResponse
	 */

	public org.mtis.www.notificacion.MensajeErrorResponse mensajeError(
			org.mtis.www.notificacion.MensajeError mensajeError) {
		
		MensajeErrorResponse response = new MensajeErrorResponse();
		switch(mensajeError.getCodigoError()){
			case 400:
				response.setMensajeError("Petición incorrecta");
				break;
			case 401:
				response.setMensajeError("Usuario no autorizado");
				break;
			case 404:
				response.setMensajeError("Recurso no encontrado");
				break;
			case 500:
				response.setMensajeError("Error interno del servidor, intente de nuevo");
				break;
			default:
				response.setMensajeError("Error desconocido");
		}
		
		return response;
	}

}

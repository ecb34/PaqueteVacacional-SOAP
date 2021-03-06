
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
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import mysql.Mysql;

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

                return new PasswordAuthentication("sendermtis@gmail.com", "mtissender2019");

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

            Mysql db = new Mysql();
			db.MySQLConnect();
			db.statement = db.connection.createStatement();
			String query = "SELECT id FROM reserva ORDER BY id DESC LIMIT 1";
			db.result = db.statement.executeQuery(query);
			int id = 1;
			if (db.result.first()) {
				id = db.result.getInt(1);
			}
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("Buenos d�as, su reserva con id " + id + " ha sido realizada correctamente, le adjuntamos su factura", "text/html");
            
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            MimeBodyPart attachPart = new MimeBodyPart();
            String fileName = "../factura_" + id + ".pdf";
            attachPart.attachFile(fileName);
            multipart.addBodyPart(attachPart);
            message.setContent(multipart);
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
            EmailResponse response = new EmailResponse();
            response.setEnviado(true);
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
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
				response.setMensajeError("Petici�n incorrecta");
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

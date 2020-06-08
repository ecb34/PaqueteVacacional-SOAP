
/**
 * ReservaSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package org.mtis.www.reserva;

import mysql.Mysql;

/**
 * ReservaSkeleton java skeleton for the axisService
 */
public class ReservaSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @param crearReserva
	 * @return crearReservaResponse
	 */

	public org.mtis.www.reserva.CrearReservaResponse crearReserva(org.mtis.www.reserva.CrearReserva data) {
		Mysql db = new Mysql();
		db.MySQLConnect();
		
		CrearReservaResponse res = new CrearReservaResponse();
		try {
			db.statement = db.connection.createStatement();
			String query = String.format("INSERT INTO reserva (email,paquete_id,unidades,precio) VALUES ('%s',%s,%s,%s)", data.getEmail(), data.getIdPaquete(), data.getUnidades(),data.getPrecio());
			int rowsAffected = db.statement.executeUpdate(query);
			if(rowsAffected > 0){
				res.setCreada(true);
				res.setCodigoError(-1);
			}else{
				res.setCreada(false);
				res.setCodigoError(404);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setCodigoError(500);
			res.setCreada(false);
		}
		
		return res;
	}

}

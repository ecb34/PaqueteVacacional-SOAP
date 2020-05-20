
/**
 * DisponibilidadSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package org.mtis.www.disponibilidad;

import mysql.Mysql;

/**
 * DisponibilidadSkeleton java skeleton for the axisService
 */
public class DisponibilidadSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @param verificarDisponibilidad
	 * @return verificarDisponibilidadResponse
	 */

	public org.mtis.www.disponibilidad.VerificarDisponibilidadResponse verificarDisponibilidad(
			org.mtis.www.disponibilidad.VerificarDisponibilidad data) {
		Mysql db = new Mysql();
		db.MySQLConnect();
		VerificarDisponibilidadResponse res = new VerificarDisponibilidadResponse();
		
		try{
			db.statement = db.connection.createStatement();
			String query = String.format("SELECT precio FROM paquete WHERE id=%s AND cantidad >= %s", data.getId(), data.getUnidades());
			db.result = db.statement.executeQuery(query);
			if(db.result.first()){
				res.setPrecio(db.result.getFloat(1));
			}else{
				res.setCodigoError(404);
				res.setPrecio(-1);
			}
		}catch(Exception err){
			res.setCodigoError(500);
			res.setPrecio(-1);
		}
		
		return res;
	}


	public org.mtis.www.disponibilidad.ActualizarDisponibilidadResponse actualizarDisponibilidad(
			org.mtis.www.disponibilidad.ActualizarDisponibilidad data) {
		Mysql db = new Mysql();
		db.MySQLConnect();
		ActualizarDisponibilidadResponse res = new ActualizarDisponibilidadResponse();
		
		try{
			
			db.statement = db.connection.createStatement();
			String query = String.format("UPDATE paquete SET cantidad = cantidad - %s WHERE id=%s and cantidad >=%s", data.getUnidades(), data.getId(), data.getUnidades());
			db.result = db.statement.executeQuery(query);
			if(db.result.rowUpdated()){
				res.setActualizado(true);
			}else{
				res.setActualizado(false);
				res.setCodigoError(404);
			}
		}catch(Exception err){
			res.setActualizado(false);
			res.setCodigoError(500);
		}
		return res;
	}

}

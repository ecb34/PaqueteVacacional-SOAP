
/**
 * DescuentosSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package org.mtis.www.descuentos;

import mysql.Mysql;

/**
 * DescuentosSkeleton java skeleton for the axisService
 */
public class DescuentosSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @param verificarDescuento
	 * @return verificarDescuentoResponse
	 */

	public org.mtis.www.descuentos.VerificarDescuentoResponse verificarDescuento(
			org.mtis.www.descuentos.VerificarDescuento data) {
		Mysql db = new Mysql();
		db.MySQLConnect();
		VerificarDescuentoResponse res = new VerificarDescuentoResponse();
		
		try{
			db.statement = db.connection.createStatement();
			String query = String.format("SELECT id FROM descuento WHERE usuario_id=%s", data.getIdUsuario());
			db.result = db.statement.executeQuery(query);
			if(db.result.first()) {
				res.setIdDescuento(db.result.getInt(1));
			}else{
				res.setIdDescuento(-1);
			}
			db.result.close();
		}catch(Exception err){
			res.setIdDescuento(-1);
			res.setCodigoError(500);
		}
		
		return res;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param aplicarDescuento
	 * @return aplicarDescuentoResponse
	 */

	public org.mtis.www.descuentos.AplicarDescuentoResponse aplicarDescuento(
			org.mtis.www.descuentos.AplicarDescuento data) {
		Mysql db = new Mysql();
		db.MySQLConnect();
		
		AplicarDescuentoResponse response = new AplicarDescuentoResponse();
		
		try{
			db.statement = db.connection.createStatement();
			String query = String.format("SELECT porcentaje FROM descuento WHERE id=%s", data.getIdDescuento());
			db.result = db.statement.executeQuery(query);
			
			if(db.result.first()){
				int porcentaje = 100 - db.result.getInt(1);
				response.setPrecioFinal(data.getPrecioPaquetes() * (porcentaje/100));
			}else{
				response.setPrecioFinal(data.getPrecioPaquetes());
			}
		}catch(Exception ex){
			response.setPrecioFinal(-1);
			response.setCodigoError(400);
		}
		
		return response;
	}

}

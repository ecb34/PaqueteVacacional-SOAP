
/**
 * DescuentosSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package org.mtis.www.descuentos;

import mysql.Mysql;;

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
			String query = String.format("SELECT id FROM descuentos WHERE usuario_id=%s AND tiporeserva_id=%s", data.getIdUsuario(), data.getIdtipoReserva());
			db.result = db.statement.executeQuery(query);
			if(db.result.first()) {
				res.setCodigoRespuesta(200);
				res.setIdDescuento(db.result.getInt(1));
				res.setVerificado(true);
			}else{
				res.setCodigoRespuesta(404);
				res.setIdDescuento(-1);
				res.setVerificado(false);
			}
			db.result.close();
		}catch(Exception err){
			res.setIdDescuento(-1);
			res.setVerificado(false);
			res.setCodigoRespuesta(500);
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
			org.mtis.www.descuentos.AplicarDescuento aplicarDescuento) {
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException(
				"Please implement " + this.getClass().getName() + "#aplicarDescuento");
	}

}

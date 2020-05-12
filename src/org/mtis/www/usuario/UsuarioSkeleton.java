
/**
 * UsuarioSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package org.mtis.www.usuario;


import mysql.Mysql;

/**
 * UsuarioSkeleton java skeleton for the axisService
 */
public class UsuarioSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @param verificarUsuario
	 * @return verificarUsuarioResponse
	 */

	public org.mtis.www.usuario.VerificarUsuarioResponse verificarUsuario(
			org.mtis.www.usuario.VerificarUsuario data) {
		Mysql db = new Mysql();
		db.MySQLConnect();
		VerificarUsuarioResponse res = new VerificarUsuarioResponse();
		
		try{
			db.statement = db.connection.createStatement();
			String query = String.format("SELECT usuario FROM usuario WHERE usuario=%s AND password >= %s", data.getUsuario(), data.getPassword());
			db.result = db.statement.executeQuery(query);
			if(db.result.first()){
				res.setVerificado(true);
			}else{
				res.setCodigoError(404);
				res.setVerificado(false);
			}
		}catch(Exception err){
			System.out.println(err.getMessage());
			res.setCodigoError(500);
			res.setVerificado(false);
		}
		
		return res;
	}

}

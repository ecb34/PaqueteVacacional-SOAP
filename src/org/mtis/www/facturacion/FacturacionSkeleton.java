
/**
 * FacturacionSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package org.mtis.www.facturacion;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * FacturacionSkeleton java skeleton for the axisService
 */
public class FacturacionSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @param crearFactura
	 * @return crearFacturaResponse
	 */

	public org.mtis.www.facturacion.CrearFacturaResponse crearFactura(
			org.mtis.www.facturacion.CrearFactura crearFactura) {
		
		CrearFacturaResponse response = new CrearFacturaResponse();
		Document document = new Document();
		try {
			
			PdfWriter.getInstance(document, new FileOutputStream("D:/factura.pdf"));
			 
			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			Chunk chunk = new Chunk("Hello World", font);
			 
			
			document.add(chunk);
			
			response.setCreada(true);
		} catch (Exception e) {
			response.setCreada(false);
			response.setCodigoError(400);
			e.printStackTrace();
		}finally{
			document.close();
		}
		
		return response;
	}

}

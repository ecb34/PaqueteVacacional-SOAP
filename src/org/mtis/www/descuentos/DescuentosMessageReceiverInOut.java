
/**
 * DescuentosMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
        package org.mtis.www.descuentos;

        /**
        *  DescuentosMessageReceiverInOut message receiver
        */

        public class DescuentosMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        DescuentosSkeleton skel = (DescuentosSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("verificarDescuento".equals(methodName)){
                
                org.mtis.www.descuentos.VerificarDescuentoResponse verificarDescuentoResponse9 = null;
	                        org.mtis.www.descuentos.VerificarDescuento wrappedParam =
                                                             (org.mtis.www.descuentos.VerificarDescuento)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.mtis.www.descuentos.VerificarDescuento.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               verificarDescuentoResponse9 =
                                                   
                                                   
                                                         skel.verificarDescuento(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), verificarDescuentoResponse9, false, new javax.xml.namespace.QName("http://www.mtis.org/Descuentos/",
                                                    "verificarDescuento"));
                                    } else 

            if("aplicarDescuento".equals(methodName)){
                
                org.mtis.www.descuentos.AplicarDescuentoResponse aplicarDescuentoResponse11 = null;
	                        org.mtis.www.descuentos.AplicarDescuento wrappedParam =
                                                             (org.mtis.www.descuentos.AplicarDescuento)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.mtis.www.descuentos.AplicarDescuento.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               aplicarDescuentoResponse11 =
                                                   
                                                   
                                                         skel.aplicarDescuento(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), aplicarDescuentoResponse11, false, new javax.xml.namespace.QName("http://www.mtis.org/Descuentos/",
                                                    "aplicarDescuento"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(org.mtis.www.descuentos.VerificarDescuento param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.mtis.www.descuentos.VerificarDescuento.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.mtis.www.descuentos.VerificarDescuentoResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.mtis.www.descuentos.VerificarDescuentoResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.mtis.www.descuentos.AplicarDescuento param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.mtis.www.descuentos.AplicarDescuento.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.mtis.www.descuentos.AplicarDescuentoResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.mtis.www.descuentos.AplicarDescuentoResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.mtis.www.descuentos.VerificarDescuentoResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.mtis.www.descuentos.VerificarDescuentoResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.mtis.www.descuentos.VerificarDescuentoResponse wrapVerificarDescuento(){
                                org.mtis.www.descuentos.VerificarDescuentoResponse wrappedElement = new org.mtis.www.descuentos.VerificarDescuentoResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.mtis.www.descuentos.AplicarDescuentoResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.mtis.www.descuentos.AplicarDescuentoResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.mtis.www.descuentos.AplicarDescuentoResponse wrapAplicarDescuento(){
                                org.mtis.www.descuentos.AplicarDescuentoResponse wrappedElement = new org.mtis.www.descuentos.AplicarDescuentoResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (org.mtis.www.descuentos.AplicarDescuento.class.equals(type)){
                
                        return org.mtis.www.descuentos.AplicarDescuento.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
            
                if (org.mtis.www.descuentos.AplicarDescuentoResponse.class.equals(type)){
                
                        return org.mtis.www.descuentos.AplicarDescuentoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
            
                if (org.mtis.www.descuentos.VerificarDescuento.class.equals(type)){
                
                        return org.mtis.www.descuentos.VerificarDescuento.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
            
                if (org.mtis.www.descuentos.VerificarDescuentoResponse.class.equals(type)){
                
                        return org.mtis.www.descuentos.VerificarDescuentoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
            
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    
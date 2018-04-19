
package com.zrt.portal.admin;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ExternalModeFault", targetNamespace = "http://portal.vidyo.com/admin/v1_1")
public class ExternalModeFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ExternalModeFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ExternalModeFault_Exception(String message, ExternalModeFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ExternalModeFault_Exception(String message, ExternalModeFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.zrt.portal.admin.ExternalModeFault
     */
    public ExternalModeFault getFaultInfo() {
        return faultInfo;
    }

}

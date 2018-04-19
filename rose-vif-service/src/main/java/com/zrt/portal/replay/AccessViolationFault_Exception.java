
package com.zrt.portal.replay;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "AccessViolationFault", targetNamespace = "http://replay.vidyo.com/apiservice")
public class AccessViolationFault_Exception
    extends java.lang.Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private AccessViolationFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public AccessViolationFault_Exception(String message, AccessViolationFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public AccessViolationFault_Exception(String message, AccessViolationFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.zrt.portal.replay.AccessViolationFault
     */
    public AccessViolationFault getFaultInfo() {
        return faultInfo;
    }

}

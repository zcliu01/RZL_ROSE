
package com.zrt.portal.user;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NotAllowedToCreateFault", targetNamespace = "http://portal.vidyo.com/user/v1_1")
public class NotAllowedToCreateFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NotAllowedToCreateFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NotAllowedToCreateFault_Exception(String message, NotAllowedToCreateFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public NotAllowedToCreateFault_Exception(String message, NotAllowedToCreateFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.zrt.portal.user.NotAllowedToCreateFault
     */
    public NotAllowedToCreateFault getFaultInfo() {
        return faultInfo;
    }

}

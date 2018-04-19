
package com.zrt.portal.user;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "RoomNotFoundFault", targetNamespace = "http://portal.vidyo.com/user/v1_1")
public class RoomNotFoundFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private RoomNotFoundFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public RoomNotFoundFault_Exception(String message, RoomNotFoundFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public RoomNotFoundFault_Exception(String message, RoomNotFoundFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.zrt.portal.user.RoomNotFoundFault
     */
    public RoomNotFoundFault getFaultInfo() {
        return faultInfo;
    }

}

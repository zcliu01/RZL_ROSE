
package com.zrt.portal.user;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ScheduledRoomCreationFault", targetNamespace = "http://portal.vidyo.com/user/v1_1")
public class ScheduledRoomCreationFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ScheduledRoomCreationFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ScheduledRoomCreationFault_Exception(String message, ScheduledRoomCreationFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ScheduledRoomCreationFault_Exception(String message, ScheduledRoomCreationFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.zrt.portal.user.ScheduledRoomCreationFault
     */
    public ScheduledRoomCreationFault getFaultInfo() {
        return faultInfo;
    }

}

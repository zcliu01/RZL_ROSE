
package com.zrt.portal.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://portal.vidyo.com/user/v1_1}ClientType" minOccurs="0"/>
 *         &lt;element name="returnEndpointBehavior" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="returnAuthToken" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="returnPortalVersion" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="returnServiceAddress" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="returnNeoRoomPermanentPairingDeviceUserAttribute" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="returnUserRole" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clientType",
    "returnEndpointBehavior",
    "returnAuthToken",
    "returnPortalVersion",
    "returnServiceAddress",
    "returnNeoRoomPermanentPairingDeviceUserAttribute",
    "returnUserRole"
})
@XmlRootElement(name = "LogInRequest")
public class LogInRequest {

    @XmlElement(name = "ClientType")
    protected String clientType;
    @XmlElement(defaultValue = "false")
    protected Boolean returnEndpointBehavior;
    @XmlElement(defaultValue = "false")
    protected Boolean returnAuthToken;
    @XmlElement(defaultValue = "false")
    protected Boolean returnPortalVersion;
    @XmlElement(defaultValue = "false")
    protected Boolean returnServiceAddress;
    @XmlElement(defaultValue = "false")
    protected Boolean returnNeoRoomPermanentPairingDeviceUserAttribute;
    @XmlElement(defaultValue = "false")
    protected Boolean returnUserRole;

    /**
     * 获取clientType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientType() {
        return clientType;
    }

    /**
     * 设置clientType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientType(String value) {
        this.clientType = value;
    }

    /**
     * 获取returnEndpointBehavior属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnEndpointBehavior() {
        return returnEndpointBehavior;
    }

    /**
     * 设置returnEndpointBehavior属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnEndpointBehavior(Boolean value) {
        this.returnEndpointBehavior = value;
    }

    /**
     * 获取returnAuthToken属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnAuthToken() {
        return returnAuthToken;
    }

    /**
     * 设置returnAuthToken属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnAuthToken(Boolean value) {
        this.returnAuthToken = value;
    }

    /**
     * 获取returnPortalVersion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnPortalVersion() {
        return returnPortalVersion;
    }

    /**
     * 设置returnPortalVersion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnPortalVersion(Boolean value) {
        this.returnPortalVersion = value;
    }

    /**
     * 获取returnServiceAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnServiceAddress() {
        return returnServiceAddress;
    }

    /**
     * 设置returnServiceAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnServiceAddress(Boolean value) {
        this.returnServiceAddress = value;
    }

    /**
     * 获取returnNeoRoomPermanentPairingDeviceUserAttribute属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnNeoRoomPermanentPairingDeviceUserAttribute() {
        return returnNeoRoomPermanentPairingDeviceUserAttribute;
    }

    /**
     * 设置returnNeoRoomPermanentPairingDeviceUserAttribute属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnNeoRoomPermanentPairingDeviceUserAttribute(Boolean value) {
        this.returnNeoRoomPermanentPairingDeviceUserAttribute = value;
    }

    /**
     * 获取returnUserRole属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnUserRole() {
        return returnUserRole;
    }

    /**
     * 设置returnUserRole属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnUserRole(Boolean value) {
        this.returnUserRole = value;
    }

}

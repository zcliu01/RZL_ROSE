
package com.zrt.portal.user;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="pak" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vmaddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proxyaddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loctag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pak2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endpointExternalIPAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minimumPINLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maximumPINLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="minMediaPort" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxMediaPort" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vrProxyConfig" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endpointBehavior" type="{http://portal.vidyo.com/user/v1_1}EndpointBehaviorDataType" minOccurs="0"/>
 *         &lt;element name="authToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="portalVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pairingService" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="registrationService" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="neoRoomPermanentPairingDeviceUser" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="userRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pak",
    "vmaddress",
    "proxyaddress",
    "loctag",
    "pak2",
    "endpointExternalIPAddress",
    "minimumPINLength",
    "maximumPINLength",
    "minMediaPort",
    "maxMediaPort",
    "vrProxyConfig",
    "endpointBehavior",
    "authToken",
    "portalVersion",
    "pairingService",
    "registrationService",
    "neoRoomPermanentPairingDeviceUser",
    "userRole"
})
@XmlRootElement(name = "LogInResponse")
public class LogInResponse {

    @XmlElement(required = true)
    protected String pak;
    @XmlElementRef(name = "vmaddress", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vmaddress;
    @XmlElementRef(name = "proxyaddress", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> proxyaddress;
    @XmlElementRef(name = "loctag", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> loctag;
    @XmlElementRef(name = "pak2", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pak2;
    protected String endpointExternalIPAddress;
    protected Integer minimumPINLength;
    protected Integer maximumPINLength;
    protected Integer minMediaPort;
    protected Integer maxMediaPort;
    protected String vrProxyConfig;
    protected EndpointBehaviorDataType endpointBehavior;
    protected String authToken;
    protected String portalVersion;
    @XmlSchemaType(name = "anyURI")
    protected String pairingService;
    @XmlSchemaType(name = "anyURI")
    protected String registrationService;
    protected Boolean neoRoomPermanentPairingDeviceUser;
    protected String userRole;

    /**
     * 获取pak属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPak() {
        return pak;
    }

    /**
     * 设置pak属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPak(String value) {
        this.pak = value;
    }

    /**
     * 获取vmaddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVmaddress() {
        return vmaddress;
    }

    /**
     * 设置vmaddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVmaddress(JAXBElement<String> value) {
        this.vmaddress = value;
    }

    /**
     * 获取proxyaddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProxyaddress() {
        return proxyaddress;
    }

    /**
     * 设置proxyaddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProxyaddress(JAXBElement<String> value) {
        this.proxyaddress = value;
    }

    /**
     * 获取loctag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLoctag() {
        return loctag;
    }

    /**
     * 设置loctag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLoctag(JAXBElement<String> value) {
        this.loctag = value;
    }

    /**
     * 获取pak2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPak2() {
        return pak2;
    }

    /**
     * 设置pak2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPak2(JAXBElement<String> value) {
        this.pak2 = value;
    }

    /**
     * 获取endpointExternalIPAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndpointExternalIPAddress() {
        return endpointExternalIPAddress;
    }

    /**
     * 设置endpointExternalIPAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndpointExternalIPAddress(String value) {
        this.endpointExternalIPAddress = value;
    }

    /**
     * 获取minimumPINLength属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinimumPINLength() {
        return minimumPINLength;
    }

    /**
     * 设置minimumPINLength属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinimumPINLength(Integer value) {
        this.minimumPINLength = value;
    }

    /**
     * 获取maximumPINLength属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaximumPINLength() {
        return maximumPINLength;
    }

    /**
     * 设置maximumPINLength属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaximumPINLength(Integer value) {
        this.maximumPINLength = value;
    }

    /**
     * 获取minMediaPort属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinMediaPort() {
        return minMediaPort;
    }

    /**
     * 设置minMediaPort属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinMediaPort(Integer value) {
        this.minMediaPort = value;
    }

    /**
     * 获取maxMediaPort属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxMediaPort() {
        return maxMediaPort;
    }

    /**
     * 设置maxMediaPort属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxMediaPort(Integer value) {
        this.maxMediaPort = value;
    }

    /**
     * 获取vrProxyConfig属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVrProxyConfig() {
        return vrProxyConfig;
    }

    /**
     * 设置vrProxyConfig属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVrProxyConfig(String value) {
        this.vrProxyConfig = value;
    }

    /**
     * 获取endpointBehavior属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EndpointBehaviorDataType }
     *     
     */
    public EndpointBehaviorDataType getEndpointBehavior() {
        return endpointBehavior;
    }

    /**
     * 设置endpointBehavior属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EndpointBehaviorDataType }
     *     
     */
    public void setEndpointBehavior(EndpointBehaviorDataType value) {
        this.endpointBehavior = value;
    }

    /**
     * 获取authToken属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * 设置authToken属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthToken(String value) {
        this.authToken = value;
    }

    /**
     * 获取portalVersion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortalVersion() {
        return portalVersion;
    }

    /**
     * 设置portalVersion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortalVersion(String value) {
        this.portalVersion = value;
    }

    /**
     * 获取pairingService属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPairingService() {
        return pairingService;
    }

    /**
     * 设置pairingService属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPairingService(String value) {
        this.pairingService = value;
    }

    /**
     * 获取registrationService属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationService() {
        return registrationService;
    }

    /**
     * 设置registrationService属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationService(String value) {
        this.registrationService = value;
    }

    /**
     * 获取neoRoomPermanentPairingDeviceUser属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeoRoomPermanentPairingDeviceUser() {
        return neoRoomPermanentPairingDeviceUser;
    }

    /**
     * 设置neoRoomPermanentPairingDeviceUser属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeoRoomPermanentPairingDeviceUser(Boolean value) {
        this.neoRoomPermanentPairingDeviceUser = value;
    }

    /**
     * 获取userRole属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 设置userRole属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserRole(String value) {
        this.userRole = value;
    }

}

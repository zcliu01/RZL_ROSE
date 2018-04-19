
package com.zrt.portal.admin;

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
 *         &lt;element name="clientType" type="{http://portal.vidyo.com/admin/v1_1}ClientType"/>
 *         &lt;element name="currentTag" type="{http://portal.vidyo.com/admin/v1_1}EndpointVersionPattern"/>
 *         &lt;element name="installerURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="setActive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "currentTag",
    "installerURL",
    "setActive"
})
@XmlRootElement(name = "addClientVersionRequest")
public class AddClientVersionRequest {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ClientType clientType;
    @XmlElement(required = true)
    protected String currentTag;
    @XmlElement(required = true)
    protected String installerURL;
    @XmlElementRef(name = "setActive", namespace = "http://portal.vidyo.com/admin/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> setActive;

    /**
     * 获取clientType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ClientType }
     *     
     */
    public ClientType getClientType() {
        return clientType;
    }

    /**
     * 设置clientType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ClientType }
     *     
     */
    public void setClientType(ClientType value) {
        this.clientType = value;
    }

    /**
     * 获取currentTag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentTag() {
        return currentTag;
    }

    /**
     * 设置currentTag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentTag(String value) {
        this.currentTag = value;
    }

    /**
     * 获取installerURL属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstallerURL() {
        return installerURL;
    }

    /**
     * 设置installerURL属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstallerURL(String value) {
        this.installerURL = value;
    }

    /**
     * 获取setActive属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getSetActive() {
        return setActive;
    }

    /**
     * 设置setActive属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setSetActive(JAXBElement<Boolean> value) {
        this.setActive = value;
    }

}

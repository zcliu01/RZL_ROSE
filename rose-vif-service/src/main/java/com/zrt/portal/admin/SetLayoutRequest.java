
package com.zrt.portal.admin;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="participantID" type="{http://portal.vidyo.com/admin/v1_1}EntityID"/>
 *         &lt;element name="layout" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxParticipants" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
    "participantID",
    "layout",
    "maxParticipants"
})
@XmlRootElement(name = "SetLayoutRequest")
public class SetLayoutRequest {

    protected int participantID;
    @XmlElementRef(name = "layout", namespace = "http://portal.vidyo.com/admin/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> layout;
    @XmlElementRef(name = "maxParticipants", namespace = "http://portal.vidyo.com/admin/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> maxParticipants;

    /**
     * 获取participantID属性的值。
     * 
     */
    public int getParticipantID() {
        return participantID;
    }

    /**
     * 设置participantID属性的值。
     * 
     */
    public void setParticipantID(int value) {
        this.participantID = value;
    }

    /**
     * 获取layout属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLayout() {
        return layout;
    }

    /**
     * 设置layout属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLayout(JAXBElement<String> value) {
        this.layout = value;
    }

    /**
     * 获取maxParticipants属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getMaxParticipants() {
        return maxParticipants;
    }

    /**
     * 设置maxParticipants属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setMaxParticipants(JAXBElement<BigInteger> value) {
        this.maxParticipants = value;
    }

}

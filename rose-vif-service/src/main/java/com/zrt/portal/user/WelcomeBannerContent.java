
package com.zrt.portal.user;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="welcomeBannerText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://portal.vidyo.com/user/v1_1}LoginAttempt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="welcomeBannerPasswordExpiryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
    "welcomeBannerText",
    "loginAttempt",
    "welcomeBannerPasswordExpiryDate"
})
@XmlRootElement(name = "WelcomeBannerContent")
public class WelcomeBannerContent {

    @XmlElementRef(name = "welcomeBannerText", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> welcomeBannerText;
    @XmlElement(name = "LoginAttempt")
    protected List<LoginAttempt> loginAttempt;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar welcomeBannerPasswordExpiryDate;

    /**
     * 获取welcomeBannerText属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWelcomeBannerText() {
        return welcomeBannerText;
    }

    /**
     * 设置welcomeBannerText属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWelcomeBannerText(JAXBElement<String> value) {
        this.welcomeBannerText = value;
    }

    /**
     * Gets the value of the loginAttempt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loginAttempt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoginAttempt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoginAttempt }
     * 
     * 
     */
    public List<LoginAttempt> getLoginAttempt() {
        if (loginAttempt == null) {
            loginAttempt = new ArrayList<LoginAttempt>();
        }
        return this.loginAttempt;
    }

    /**
     * 获取welcomeBannerPasswordExpiryDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWelcomeBannerPasswordExpiryDate() {
        return welcomeBannerPasswordExpiryDate;
    }

    /**
     * 设置welcomeBannerPasswordExpiryDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWelcomeBannerPasswordExpiryDate(XMLGregorianCalendar value) {
        this.welcomeBannerPasswordExpiryDate = value;
    }

}

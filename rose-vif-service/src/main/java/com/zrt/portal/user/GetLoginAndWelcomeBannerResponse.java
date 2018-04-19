
package com.zrt.portal.user;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="loginBannerText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://portal.vidyo.com/user/v1_1}WelcomeBannerContent" minOccurs="0"/>
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
    "loginBannerText",
    "welcomeBannerContent"
})
@XmlRootElement(name = "getLoginAndWelcomeBannerResponse")
public class GetLoginAndWelcomeBannerResponse {

    @XmlElementRef(name = "loginBannerText", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> loginBannerText;
    @XmlElement(name = "WelcomeBannerContent")
    protected WelcomeBannerContent welcomeBannerContent;

    /**
     * 获取loginBannerText属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLoginBannerText() {
        return loginBannerText;
    }

    /**
     * 设置loginBannerText属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLoginBannerText(JAXBElement<String> value) {
        this.loginBannerText = value;
    }

    /**
     * 获取welcomeBannerContent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WelcomeBannerContent }
     *     
     */
    public WelcomeBannerContent getWelcomeBannerContent() {
        return welcomeBannerContent;
    }

    /**
     * 设置welcomeBannerContent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WelcomeBannerContent }
     *     
     */
    public void setWelcomeBannerContent(WelcomeBannerContent value) {
        this.welcomeBannerContent = value;
    }

}

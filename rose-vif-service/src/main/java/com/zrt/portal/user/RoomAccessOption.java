
package com.zrt.portal.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="accessOption" type="{http://portal.vidyo.com/user/v1_1}AccessOptionName"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "accessOption",
    "value"
})
@XmlRootElement(name = "RoomAccessOption")
public class RoomAccessOption {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected AccessOptionName accessOption;
    @XmlElement(required = true)
    protected String value;

    /**
     * 获取accessOption属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AccessOptionName }
     *     
     */
    public AccessOptionName getAccessOption() {
        return accessOption;
    }

    /**
     * 设置accessOption属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AccessOptionName }
     *     
     */
    public void setAccessOption(AccessOptionName value) {
        this.accessOption = value;
    }

    /**
     * 获取value属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置value属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}

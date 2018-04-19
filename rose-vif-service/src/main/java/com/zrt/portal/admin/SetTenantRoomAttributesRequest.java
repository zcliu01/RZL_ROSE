
package com.zrt.portal.admin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="setWaitingRoomState" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="supportedClientsOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "setWaitingRoomState",
    "supportedClientsOnly"
})
@XmlRootElement(name = "SetTenantRoomAttributesRequest")
public class SetTenantRoomAttributesRequest {

    protected Integer setWaitingRoomState;
    protected Boolean supportedClientsOnly;

    /**
     * 获取setWaitingRoomState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSetWaitingRoomState() {
        return setWaitingRoomState;
    }

    /**
     * 设置setWaitingRoomState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSetWaitingRoomState(Integer value) {
        this.setWaitingRoomState = value;
    }

    /**
     * 获取supportedClientsOnly属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportedClientsOnly() {
        return supportedClientsOnly;
    }

    /**
     * 设置supportedClientsOnly属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportedClientsOnly(Boolean value) {
        this.supportedClientsOnly = value;
    }

}

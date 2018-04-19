
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
 *         &lt;element name="setPrivateChatState" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="setPublicChatState" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "setPrivateChatState",
    "setPublicChatState"
})
@XmlRootElement(name = "setChatStateAdminRequest")
public class SetChatStateAdminRequest {

    protected Boolean setPrivateChatState;
    protected Boolean setPublicChatState;

    /**
     * 获取setPrivateChatState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSetPrivateChatState() {
        return setPrivateChatState;
    }

    /**
     * 设置setPrivateChatState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSetPrivateChatState(Boolean value) {
        this.setPrivateChatState = value;
    }

    /**
     * 获取setPublicChatState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSetPublicChatState() {
        return setPublicChatState;
    }

    /**
     * 设置setPublicChatState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSetPublicChatState(Boolean value) {
        this.setPublicChatState = value;
    }

}

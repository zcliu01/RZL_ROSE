
package com.zrt.portal.admin;

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
 *         &lt;element name="endpointBehavior" type="{http://portal.vidyo.com/admin/v1_1}EndpointBehaviorDataType"/>
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
    "endpointBehavior"
})
@XmlRootElement(name = "createEndpointBehaviorRequest")
public class CreateEndpointBehaviorRequest {

    @XmlElement(required = true)
    protected EndpointBehaviorDataType endpointBehavior;

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

}

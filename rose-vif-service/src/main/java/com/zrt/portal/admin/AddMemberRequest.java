
package com.zrt.portal.admin;

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
 *         &lt;element name="returnObjectInResponse" type="{http://portal.vidyo.com/admin/v1_1}ReturnObjectInResponse" minOccurs="0"/>
 *         &lt;element name="member" type="{http://portal.vidyo.com/admin/v1_1}Member"/>
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
    "returnObjectInResponse",
    "member"
})
@XmlRootElement(name = "AddMemberRequest")
public class AddMemberRequest {

    @XmlSchemaType(name = "string")
    protected ReturnObjectInResponse returnObjectInResponse;
    @XmlElement(required = true)
    protected Member member;

    /**
     * 获取returnObjectInResponse属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReturnObjectInResponse }
     *     
     */
    public ReturnObjectInResponse getReturnObjectInResponse() {
        return returnObjectInResponse;
    }

    /**
     * 设置returnObjectInResponse属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnObjectInResponse }
     *     
     */
    public void setReturnObjectInResponse(ReturnObjectInResponse value) {
        this.returnObjectInResponse = value;
    }

    /**
     * 获取member属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Member }
     *     
     */
    public Member getMember() {
        return member;
    }

    /**
     * 设置member属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Member }
     *     
     */
    public void setMember(Member value) {
        this.member = value;
    }

}


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
 *         &lt;element name="conferenceID" type="{http://portal.vidyo.com/admin/v1_1}EntityID"/>
 *         &lt;choice>
 *           &lt;element name="entityID" type="{http://portal.vidyo.com/admin/v1_1}EntityID"/>
 *           &lt;element name="invite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/choice>
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
    "conferenceID",
    "entityID",
    "invite"
})
@XmlRootElement(name = "InviteToConferenceRequest")
public class InviteToConferenceRequest {

    protected int conferenceID;
    protected Integer entityID;
    protected String invite;

    /**
     * 获取conferenceID属性的值。
     * 
     */
    public int getConferenceID() {
        return conferenceID;
    }

    /**
     * 设置conferenceID属性的值。
     * 
     */
    public void setConferenceID(int value) {
        this.conferenceID = value;
    }

    /**
     * 获取entityID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEntityID() {
        return entityID;
    }

    /**
     * 设置entityID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEntityID(Integer value) {
        this.entityID = value;
    }

    /**
     * 获取invite属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvite() {
        return invite;
    }

    /**
     * 设置invite属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvite(String value) {
        this.invite = value;
    }

}


package com.zrt.portal.user;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SilenceSpeakerServerType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SilenceSpeakerServerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="conferenceID" type="{http://portal.vidyo.com/user/v1_1}EntityID"/>
 *         &lt;element name="participantID" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="silenceState" type="{http://portal.vidyo.com/user/v1_1}SilenceState"/>
 *         &lt;element name="moderatorPIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SilenceSpeakerServerType", propOrder = {
    "conferenceID",
    "participantID",
    "silenceState",
    "moderatorPIN"
})
public class SilenceSpeakerServerType {

    @XmlElement(required = true)
    protected String conferenceID;
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger participantID;
    protected int silenceState;
    protected String moderatorPIN;

    /**
     * 获取conferenceID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConferenceID() {
        return conferenceID;
    }

    /**
     * 设置conferenceID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConferenceID(String value) {
        this.conferenceID = value;
    }

    /**
     * 获取participantID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getParticipantID() {
        return participantID;
    }

    /**
     * 设置participantID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setParticipantID(BigInteger value) {
        this.participantID = value;
    }

    /**
     * 获取silenceState属性的值。
     * 
     */
    public int getSilenceState() {
        return silenceState;
    }

    /**
     * 设置silenceState属性的值。
     * 
     */
    public void setSilenceState(int value) {
        this.silenceState = value;
    }

    /**
     * 获取moderatorPIN属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModeratorPIN() {
        return moderatorPIN;
    }

    /**
     * 设置moderatorPIN属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModeratorPIN(String value) {
        this.moderatorPIN = value;
    }

}

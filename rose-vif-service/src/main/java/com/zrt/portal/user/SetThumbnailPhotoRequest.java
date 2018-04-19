
package com.zrt.portal.user;

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
 *         &lt;element name="thumbNailPhoto" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
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
    "thumbNailPhoto"
})
@XmlRootElement(name = "SetThumbnailPhotoRequest")
public class SetThumbnailPhotoRequest {

    @XmlElement(required = true)
    protected byte[] thumbNailPhoto;

    /**
     * 获取thumbNailPhoto属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getThumbNailPhoto() {
        return thumbNailPhoto;
    }

    /**
     * 设置thumbNailPhoto属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setThumbNailPhoto(byte[] value) {
        this.thumbNailPhoto = value;
    }

}

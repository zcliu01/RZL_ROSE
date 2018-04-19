
package com.zrt.portal.user;

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
 *         &lt;element name="minimumPINLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maximumPINLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "minimumPINLength",
    "maximumPINLength"
})
@XmlRootElement(name = "GetPINLengthRangeResponse")
public class GetPINLengthRangeResponse {

    protected int minimumPINLength;
    protected int maximumPINLength;

    /**
     * 获取minimumPINLength属性的值。
     * 
     */
    public int getMinimumPINLength() {
        return minimumPINLength;
    }

    /**
     * 设置minimumPINLength属性的值。
     * 
     */
    public void setMinimumPINLength(int value) {
        this.minimumPINLength = value;
    }

    /**
     * 获取maximumPINLength属性的值。
     * 
     */
    public int getMaximumPINLength() {
        return maximumPINLength;
    }

    /**
     * 设置maximumPINLength属性的值。
     * 
     */
    public void setMaximumPINLength(int value) {
        this.maximumPINLength = value;
    }

}

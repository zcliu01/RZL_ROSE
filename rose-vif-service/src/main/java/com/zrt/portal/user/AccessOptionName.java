
package com.zrt.portal.user;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AccessOptionName的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="AccessOptionName">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="roomURL"/>
 *     &lt;enumeration value="extension"/>
 *     &lt;enumeration value="PIN"/>
 *     &lt;enumeration value="dial-in-Number"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AccessOptionName")
@XmlEnum
public enum AccessOptionName {

    @XmlEnumValue("roomURL")
    ROOM_URL("roomURL"),
    @XmlEnumValue("extension")
    EXTENSION("extension"),
    PIN("PIN"),
    @XmlEnumValue("dial-in-Number")
    DIAL_IN_NUMBER("dial-in-Number");
    private final String value;

    AccessOptionName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccessOptionName fromValue(String v) {
        for (AccessOptionName c: AccessOptionName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

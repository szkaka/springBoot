//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2015.01.30 at 12:49:43 PM PST
//

package 工具.TableauTest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java class for granteeCapabilitiesType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="granteeCapabilitiesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="group" type="{http://tableau.com/api}groupType"/>
 *           &lt;element name="user" type="{http://tableau.com/api}userType"/>
 *         &lt;/choice>
 *         &lt;element name="capabilities">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="capability" type="{http://tableau.com/api}capabilityType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "granteeCapabilitiesType", propOrder = { "group", "user", "capabilities" })
public class GranteeCapabilitiesType {

    protected GroupType group;
    protected UserType user;
    @XmlElement(required = true)
    protected GranteeCapabilitiesType.Capabilities capabilities;

    /**
     * Gets the value of the group property.
     *
     * @return possible object is {@link GroupType }
     *
     */
    public GroupType getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     *
     * @param value
     *            allowed object is {@link GroupType }
     *
     */
    public void setGroup(GroupType value) {
        this.group = value;
    }

    /**
     * Gets the value of the user property.
     *
     * @return possible object is {@link UserType }
     *
     */
    public UserType getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     *
     * @param value
     *            allowed object is {@link UserType }
     *
     */
    public void setUser(UserType value) {
        this.user = value;
    }

    /**
     * Gets the value of the capabilities property.
     *
     * @return possible object is {@link GranteeCapabilitiesType.Capabilities }
     *
     */
    public GranteeCapabilitiesType.Capabilities getCapabilities() {
        return capabilities;
    }

    /**
     * Sets the value of the capabilities property.
     *
     * @param value
     *            allowed object is {@link GranteeCapabilitiesType.Capabilities }
     *
     */
    public void setCapabilities(GranteeCapabilitiesType.Capabilities value) {
        this.capabilities = value;
    }

    /**
     * <p>
     * Java class for anonymous complex type.
     *
     * <p>
     * The following schema fragment specifies the expected content contained
     * within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="capability" type="{http://tableau.com/api}capabilityType" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "capability" })
    public static class Capabilities {

        @XmlElement(required = true)
        protected List<CapabilityType> capability;

        /**
         * Gets the value of the capability property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a
         * snapshot. Therefore any modification you make to the returned list
         * will be present inside the JAXB object. This is why there is not a
         * <CODE>set</CODE> method for the capability property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         *
         * <pre>
         * getCapability().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CapabilityType }
         *
         *
         */
        public List<CapabilityType> getCapability() {
            if (capability == null) {
                capability = new ArrayList<CapabilityType>();
            }
            return this.capability;
        }

    }

}

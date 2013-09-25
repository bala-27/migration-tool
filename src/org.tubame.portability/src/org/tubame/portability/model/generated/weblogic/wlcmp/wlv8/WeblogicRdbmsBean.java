//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.17 at 10:51:28 AM JST 
//

package org.tubame.portability.model.generated.weblogic.wlcmp.wlv8;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "ejbName", "dataSourceName", "tableMap",
        "fieldGroup", "relationshipCaching", "weblogicQuery",
        "delayDatabaseInsertUntil", "useSelectForUpdate", "lockOrder",
        "instanceLockOrder", "automaticKeyGeneration", "checkExistsOnMethod" })
@XmlRootElement(name = "weblogic-rdbms-bean")
public class WeblogicRdbmsBean {

    @XmlElement(name = "ejb-name", required = true)
    protected String ejbName;
    @XmlElement(name = "data-source-name", required = true)
    protected String dataSourceName;
    @XmlElement(name = "table-map", required = true)
    protected List<TableMap> tableMap;
    @XmlElement(name = "field-group")
    protected List<FieldGroup> fieldGroup;
    @XmlElement(name = "relationship-caching")
    protected List<RelationshipCaching> relationshipCaching;
    @XmlElement(name = "weblogic-query")
    protected List<WeblogicQuery> weblogicQuery;
    @XmlElement(name = "delay-database-insert-until")
    protected String delayDatabaseInsertUntil;
    @XmlElement(name = "use-select-for-update")
    protected String useSelectForUpdate;
    @XmlElement(name = "lock-order")
    protected String lockOrder;
    @XmlElement(name = "instance-lock-order")
    protected String instanceLockOrder;
    @XmlElement(name = "automatic-key-generation")
    protected AutomaticKeyGeneration automaticKeyGeneration;
    @XmlElement(name = "check-exists-on-method")
    protected String checkExistsOnMethod;

    /**
     * Gets the value of the ejbName property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getEjbName() {
        return ejbName;
    }

    /**
     * Sets the value of the ejbName property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setEjbName(String value) {
        this.ejbName = value;
    }

    /**
     * Gets the value of the dataSourceName property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getDataSourceName() {
        return dataSourceName;
    }

    /**
     * Sets the value of the dataSourceName property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setDataSourceName(String value) {
        this.dataSourceName = value;
    }

    /**
     * Gets the value of the tableMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the tableMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getTableMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link TableMap }
     * 
     * 
     */
    public List<TableMap> getTableMap() {
        if (tableMap == null) {
            tableMap = new ArrayList<TableMap>();
        }
        return this.tableMap;
    }

    /**
     * Gets the value of the fieldGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the fieldGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getFieldGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FieldGroup }
     * 
     * 
     */
    public List<FieldGroup> getFieldGroup() {
        if (fieldGroup == null) {
            fieldGroup = new ArrayList<FieldGroup>();
        }
        return this.fieldGroup;
    }

    /**
     * Gets the value of the relationshipCaching property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the relationshipCaching property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getRelationshipCaching().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelationshipCaching }
     * 
     * 
     */
    public List<RelationshipCaching> getRelationshipCaching() {
        if (relationshipCaching == null) {
            relationshipCaching = new ArrayList<RelationshipCaching>();
        }
        return this.relationshipCaching;
    }

    /**
     * Gets the value of the weblogicQuery property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the weblogicQuery property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getWeblogicQuery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WeblogicQuery }
     * 
     * 
     */
    public List<WeblogicQuery> getWeblogicQuery() {
        if (weblogicQuery == null) {
            weblogicQuery = new ArrayList<WeblogicQuery>();
        }
        return this.weblogicQuery;
    }

    /**
     * Gets the value of the delayDatabaseInsertUntil property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getDelayDatabaseInsertUntil() {
        return delayDatabaseInsertUntil;
    }

    /**
     * Sets the value of the delayDatabaseInsertUntil property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setDelayDatabaseInsertUntil(String value) {
        this.delayDatabaseInsertUntil = value;
    }

    /**
     * Gets the value of the useSelectForUpdate property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getUseSelectForUpdate() {
        return useSelectForUpdate;
    }

    /**
     * Sets the value of the useSelectForUpdate property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setUseSelectForUpdate(String value) {
        this.useSelectForUpdate = value;
    }

    /**
     * Gets the value of the lockOrder property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getLockOrder() {
        return lockOrder;
    }

    /**
     * Sets the value of the lockOrder property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setLockOrder(String value) {
        this.lockOrder = value;
    }

    /**
     * Gets the value of the instanceLockOrder property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getInstanceLockOrder() {
        return instanceLockOrder;
    }

    /**
     * Sets the value of the instanceLockOrder property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setInstanceLockOrder(String value) {
        this.instanceLockOrder = value;
    }

    /**
     * Gets the value of the automaticKeyGeneration property.
     * 
     * @return possible object is {@link AutomaticKeyGeneration }
     * 
     */
    public AutomaticKeyGeneration getAutomaticKeyGeneration() {
        return automaticKeyGeneration;
    }

    /**
     * Sets the value of the automaticKeyGeneration property.
     * 
     * @param value
     *            allowed object is {@link AutomaticKeyGeneration }
     * 
     */
    public void setAutomaticKeyGeneration(AutomaticKeyGeneration value) {
        this.automaticKeyGeneration = value;
    }

    /**
     * Gets the value of the checkExistsOnMethod property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCheckExistsOnMethod() {
        return checkExistsOnMethod;
    }

    /**
     * Sets the value of the checkExistsOnMethod property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCheckExistsOnMethod(String value) {
        this.checkExistsOnMethod = value;
    }

}
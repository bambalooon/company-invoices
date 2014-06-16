
package pl.bb.broker.company.invoices.rest.bankclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transfer" type="{http://schemas.datacontract.org/2004/07/BankService.Messages}MoneyTransfer" minOccurs="0"/>
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
    "transfer"
})
@XmlRootElement(name = "transferMoney")
public class TransferMoney {

    @XmlElementRef(name = "transfer", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<MoneyTransfer> transfer;

    /**
     * Gets the value of the transfer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MoneyTransfer }{@code >}
     *     
     */
    public JAXBElement<MoneyTransfer> getTransfer() {
        return transfer;
    }

    /**
     * Sets the value of the transfer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MoneyTransfer }{@code >}
     *     
     */
    public void setTransfer(JAXBElement<MoneyTransfer> value) {
        this.transfer = value;
    }

}

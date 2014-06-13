package pl.bb.broker.company.invoices.ws.exceptions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 02.06.14
 * Time: 18:36
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name = "ExceptionFault")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pl.bb.broker.company.invoices.ws.exceptions.WSException")
public class WSExceptionBean {
    private String message;

    public WSExceptionBean() {}
    public WSExceptionBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

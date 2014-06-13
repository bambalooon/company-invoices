package pl.bb.broker.company.invoices.ws.exceptions;

import javax.xml.ws.WebFault;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 02.06.14
 * Time: 18:35
 * To change this template use File | Settings | File Templates.
 */

@WebFault(name = "WSException", faultBean = "pl.bb.broker.company.invoices.ws.exceptions.WSExceptionBean")
public class WSException extends Exception {
    private WSExceptionBean faultBean;

    public WSException(String message, WSExceptionBean faultInfo) {
        super(message);
        faultBean = faultInfo;
    }

    public WSException(String message, WSExceptionBean faultInfo, Throwable cause) {
        super(message);
        faultBean = faultInfo;
    }

    public WSExceptionBean getFaultInfo() {
        return faultBean;
    }
}

package pl.bb.broker.company.invoices.ws.services;

import pl.bb.broker.brokerdb.broker.entities.InvoicesEntity;
import pl.bb.broker.company.invoices.ws.exceptions.WSException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 11.06.14
 * Time: 20:43
 * To change this template use File | Settings | File Templates.
 */

@WebService(name = "InvoiceService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface InvoiceService {

    @WebMethod
    void sendInvoice(@WebParam(name = "invoice")InvoicesEntity invoice) throws WSException;

}

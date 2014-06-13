package pl.bb.broker.company.invoices.ws.services;

import pl.bb.broker.brokerdb.broker.entities.InvoicesEntity;
import pl.bb.broker.company.companydb.util.PensjonatDBInvoicesUtil;
import pl.bb.broker.company.invoices.ws.exceptions.WSException;

import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 11.06.14
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */

@WebService(endpointInterface = "pl.bb.broker.company.invoices.ws.services.InvoiceService")
public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public void sendInvoice(InvoicesEntity invoice) throws WSException {
        PensjonatDBInvoicesUtil.FACTORY.saveInvoice(invoice);
    }
}

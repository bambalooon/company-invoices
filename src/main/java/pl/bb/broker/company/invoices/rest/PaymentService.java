package pl.bb.broker.company.invoices.rest;

import pl.bb.broker.company.invoices.rest.bankclient.BankService;
import pl.bb.broker.company.invoices.rest.bankclient.IBankService;
import pl.bb.broker.company.invoices.rest.bankclient.MoneyTransfer;
import pl.bb.broker.company.invoices.rest.bankclient.ObjectFactory;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 13.06.14
 * Time: 16:51
 * To change this template use File | Settings | File Templates.
 */
@Path("/pay")
public class PaymentService {
    public static final long brokerBankAccoundID = 1L;

    @GET
    @Path("/{desc}/{value}")
    public String transferMoney(@PathParam("desc") String description, @PathParam("value")Double value) {
        MoneyTransfer transfer = new MoneyTransfer();
        transfer.setID(PaymentService.brokerBankAccoundID);
        transfer.setDescription(new ObjectFactory().createMoneyTransferDescription(description));
        transfer.setValue(value);

        BankService serviceImpl = new BankService();
        IBankService service = serviceImpl.getBasicHttpBindingIBankService();
        return service.transferMoney(transfer);
    }

}

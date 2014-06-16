package pl.bb.broker.company.invoices.rest;

import org.hibernate.HibernateException;
import pl.bb.broker.company.companydb.pensjonat.entities.InvoicesEntity;
import pl.bb.broker.company.companydb.util.PensjonatDBInvoicesUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 13.06.14
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */

@Path("/new")
public class NewInvoiceService {

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response sendInvoice(pl.bb.broker.brokerdb.broker.entities.InvoicesEntity invoice) {
        InvoicesEntity inv = InvoicesEntity.convert(invoice);
        try {
            PensjonatDBInvoicesUtil.FACTORY.saveInvoice(inv);
        } catch (HibernateException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
        return Response.status(201).build();
    }

}

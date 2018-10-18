package org.scm.ojt.rest.services;

import com.google.inject.Singleton;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.scm.ojt.rest.logic.SupplierLogic;
import org.scm.ojt.rest.entity.Supplier;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Yoyok_T on 11/10/2018.
 */
@Singleton
@Api("Suppplier Service")
@Path("/supplier")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SupplierService {
    private SupplierLogic supplierLogic;

    @Inject
    public SupplierService(SupplierLogic supplierLogic){
        this.supplierLogic = supplierLogic;
    }

    @GET
    @ApiOperation(value="List all supplier")
    public List<Supplier> listSupplier() {
        return supplierLogic.listSupplier();
    }

    @POST
    @ApiOperation(value="Create Supplier")
    public Response createSupplier(final Supplier supplier) {
        Supplier supplierResp = supplierLogic.createSupplier(supplier);
        return Response.ok().entity(supplierResp).build();
    }
}

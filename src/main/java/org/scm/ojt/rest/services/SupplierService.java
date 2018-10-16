package org.scm.ojt.rest.services;

import com.google.inject.Singleton;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.scm.ojt.rest.logic.SupplierLogic;
import org.scm.ojt.rest.logic.TestLogic;
import org.scm.ojt.rest.model.Supplier;
import org.scm.ojt.rest.dto.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Yoyok_T on 11/10/2018.
 */
@Singleton
@Api("Supplier Service")
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
    @Produces(MediaType.APPLICATION_JSON)
    public List<Supplier> listSupplier() {
//        ModelMapper mapper = new ModelMapper();
//        List<SupplierDTO> listDTO = new ArrayList<>();
//        supplierLogic.listSupplier().forEach(supplier -> {
//            SupplierDTO supplierDTO = mapper.map(supplier, org.scm.ojt.rest.dto.SupplierDTO.class);
//            listDTO.add(supplierDTO);
//        });
        return supplierLogic.listSupplier();
    }

    @POST
    @ApiOperation(value="Create Supplier")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSupplier(final Supplier supplier) {
        Supplier supplierResp = supplierLogic.createSupplier(supplier);
//        ModelMapper mapper = new ModelMapper();
//        PropertyMap<Supplier, SupplierDTO> supplierMap = new PropertyMap<Supplier, SupplierDTO>() {
//            protected void configure() {
//                map().setId(source.getId().toString());
//                map(source.getId(), destination.setId(source.getId().toString()));
//            }
//        };
//        mapper.addMappings(supplierMap);
//        SupplierDTO supplierDTO = mapper.map(supplierResp, org.scm.ojt.rest.dto.SupplierDTO.class);
        return Response.ok(supplierResp.getId().toString()).build();
    }
}

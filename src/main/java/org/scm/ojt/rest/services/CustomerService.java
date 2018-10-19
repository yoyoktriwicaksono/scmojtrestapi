package org.scm.ojt.rest.services;

import com.google.inject.Singleton;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.scm.ojt.rest.dao.ConnectionManager;
import org.scm.ojt.rest.dao.CustomerDAO;
import org.scm.ojt.rest.dao.DAOManager;
import org.scm.ojt.rest.dto.CustomerDTO;
import org.scm.ojt.rest.entity.Customer;
import org.scm.ojt.rest.model.Supplier;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

/**
 * Created by Yoyok_T on 17/10/2018.
 */
@Singleton
@Api("Customer Service")
@Path("/customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerService {
    private final ConnectionManager connectionManager;
    private final CustomerDAO customerDAO;
    private final DAOManager daoManager;

    @Inject
    public CustomerService(ConnectionManager connectionManager, DAOManager daoManager){
        this.connectionManager = connectionManager;
        this.customerDAO = new CustomerDAO(this.connectionManager.getDatastore());
        this.daoManager = daoManager;
    }

    @GET
    @ApiOperation(value="List all Customer")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDTO> listCustomer(){
        Query<Customer> query = this.connectionManager.getDatastore().createQuery(Customer.class);
        query.and(
                query.criteria("accounts.name").equal("Personal Account"),
                query.criteria("address.number").equal("81"),
                query.criteria("name").contains("Bank")
        );

        /*
            THIS IS USING SINGLE DAO APPROACH
         */
        QueryResults<Customer> retrievedCustomers =  customerDAO.find(query);

        return createCustomerDTOList(retrievedCustomers);
    }

    @GET
    @Path("/search")
    @ApiOperation(value="Search Customer")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDTO> searchCustomer(
            @ApiParam(value = "Customer Name", required = true) @QueryParam("customerName") final String customerName,
            @ApiParam(value = "Account Name", required = true) @QueryParam("accountName") final String accountName
    ){
        Query<Customer> query = this.connectionManager.getDatastore().createQuery(Customer.class);
        query.and(
                query.criteria("name").contains(customerName),
                query.criteria("accounts.name").contains(accountName)
        );

        /*
            THIS IS USING DAO MANAGER APPROACH
         */
        QueryResults<Customer> retrievedCustomers =  daoManager.userDAO.find(query);

        return createCustomerDTOList(retrievedCustomers);
    }

    private List<CustomerDTO> createCustomerDTOList(QueryResults<Customer> retrievedCustomers){
        List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
        ModelMapper modelMapper = new ModelMapper();
        for (Customer retrievedCustomer : retrievedCustomers) {
//            System.out.println(retrievedCustomer.getName());
//            System.out.println(retrievedCustomer.getAddress().getPostcode());
//            System.out.println(retrievedCustomer.getAccounts().get(0).getName());
            //customerDAO.delete(retrievedCustomer);
            CustomerDTO customerDTO = modelMapper.map(retrievedCustomer, CustomerDTO.class);
            customers.add(customerDTO);
        }
        return customers;
    }

//    @GET
//    @Path("{id}")
//    @ApiOperation(value="Get Supplier", response = SupplierDTO.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 400, message = "Invalid ID"),
//            @ApiResponse(code = 404, message = "Supplier Not Found"),
//            @ApiResponse(code = 500, message = "Something wrong in Server")
//    })
//    public Response getById(
//            @ApiParam(value = "id", required = true) @PathParam("id") final String id
//    ) throws NotFoundException {
//        if (supplierLogic.getObjectId(id) != null) {
//            SupplierDTO supplierDTO = supplierLogic.getById(id);
//            if (supplierDTO != null) {
//                return Response.ok().entity(supplierDTO).build();
//            } else {
//                throw new NotFoundException(404, "Supplier Not Found");
//            }
//        } else {
//            throw new NotFoundException(400, "Invalid ID");
//        }
//    }


}

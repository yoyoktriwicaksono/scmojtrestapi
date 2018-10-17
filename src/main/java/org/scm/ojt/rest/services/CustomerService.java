package org.scm.ojt.rest.services;

import com.google.inject.Singleton;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.scm.ojt.rest.dao.ConnectionManager;
import org.scm.ojt.rest.dao.CustomerDAO;
import org.scm.ojt.rest.dto.CustomerDTO;
import org.scm.ojt.rest.entity.Customer;
import org.scm.ojt.rest.model.Supplier;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

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

    @Inject
    public CustomerService(ConnectionManager connectionManager){
        this.connectionManager = connectionManager;
        this.customerDAO = new CustomerDAO(this.connectionManager.getDatastore());
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

        QueryResults<Customer> retrievedCustomers =  customerDAO.find(query);
        List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
        ModelMapper modelMapper = new ModelMapper();
        for (Customer retrievedCustomer : retrievedCustomers) {
            System.out.println(retrievedCustomer.getName());
            System.out.println(retrievedCustomer.getAddress().getPostcode());
            System.out.println(retrievedCustomer.getAccounts().get(0).getName());
            //customerDAO.delete(retrievedCustomer);
            CustomerDTO customerDTO = modelMapper.map(retrievedCustomer, CustomerDTO.class);
            customers.add(customerDTO);
        }

        return customers;
    }
}

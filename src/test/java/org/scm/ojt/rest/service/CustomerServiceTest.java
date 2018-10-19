package org.scm.ojt.rest.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mongodb.morphia.Datastore;
import org.scm.ojt.rest.dao.ConnectionManager;
import org.scm.ojt.rest.dto.CustomerDTO;
import org.scm.ojt.rest.services.CustomerService;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Yoyok_T on 19/10/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

//    private ConnectionManager connectionManager = Mockito.mock(ConnectionManager.class);
//    private DAOManager daoManager = Mockito.mock(DAOManager.class);
//    private Datastore datastore = Mockito.mock(Datastore.class);
//    private CustomerService customerService;
//
//    private List<CustomerDTO> customerDTOList;
//    private List<AccountDTO> accountDTOList;
//    private AddressDTO addressDTO;

    @Before
    public void setUp() throws Exception {
//        customerService = new CustomerService(connectionManager,daoManager);
//
//        AccountDTO accountDTO = new AccountDTO();
//        accountDTO.setName("Test Account");
//        accountDTOList.add(accountDTO);
//
//        addressDTO = new AddressDTO();
//        addressDTO.setNumber("10");
//        addressDTO.setStreet("Street");
//        addressDTO.setTown("Bandung");
//        addressDTO.setPostcode("12345");
//
//        CustomerDTO customerDTO = new CustomerDTO("1","customer name",accountDTOList,addressDTO);
//        customerDTOList.add(customerDTO);

    }

    @Test
    public void testFirst(){
        String test = "test";
        assertNotNull(test);
    }

    @Test
    public void testSearchCustomer(){
//        when(customerService.searchCustomer(anyObject(),anyObject())).thenReturn(customerDTOList);
//
//        List<CustomerDTO> customers = customerService.searchCustomer("1","1");
//        assertNotNull(customers);
    }

}

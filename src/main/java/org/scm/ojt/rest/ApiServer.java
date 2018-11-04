package org.scm.ojt.rest;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.scm.ojt.rest.config.ConfigurationManager;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.webapp.WebAppContext;
import org.scm.ojt.rest.config.MongoConfigData;
import org.scm.ojt.rest.dao.CustomerDAO;
import org.scm.ojt.rest.dto.CustomerDTO;
import org.scm.ojt.rest.entity.Account;
import org.scm.ojt.rest.entity.Address;
import org.scm.ojt.rest.entity.Customer;
import org.scm.ojt.rest.utils.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ApiServer implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(ApiServer.class);

    private final int port;
    private final Server server;

    public ApiServer(final int port) {
        this.port = port;

        String resourceBaseApi = "src/main/swagger";
        if (Files.notExists(Paths.get(resourceBaseApi))) {
            resourceBaseApi = ApiServer.class.getProtectionDomain().getCodeSource().getLocation().toExternalForm();
        }

        final String xmlDescriptor = ApiServer.class.getResource("/WEB-INF/web.xml").toExternalForm();

        final WebAppContext webAppContextApi = new WebAppContext(resourceBaseApi, "/api/");
        webAppContextApi.setDescriptor(xmlDescriptor);

        server = new Server(port);

        final HandlerList handlers = new HandlerList();
        handlers.addHandler( webAppContextApi );

        server.setHandler(handlers);
    }

    @Override
    public void run() {
        try {
            server.start();
            LOG.info("Server listening on port:{}", port);
            server.join();
        } catch (final InterruptedException ie) {
            LOG.warn("Server was Interrupted");
        } catch (final Exception e) {
            LOG.error("Server was unable to start", e);
        }
    }

    public void stop() throws Exception {
        LOG.info("Stopping Server");
        server.stop();
    }

    public static void main(final String[] args) {

//        Morphia morphia = new Morphia();
//        morphia.mapPackage("org.scm.ojt.rest.entity");
//        MongoConfigData mongoConfigData = ConfigurationManager.getInstance().getMongoConfigData();
//
//        ServerAddress addr = new ServerAddress(
//                mongoConfigData.host(),
//                mongoConfigData.port()
//        );
//        List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
//        MongoCredential credentia = MongoCredential.createCredential(
//                mongoConfigData.username(), mongoConfigData.database(), mongoConfigData.password().toCharArray());
//        credentialsList.add(credentia);
//        MongoClient client = new MongoClient(addr, credentialsList);
//
//        Datastore datastore = morphia.createDatastore(
//                client,
//                mongoConfigData.database()
//        );
//        datastore.ensureIndexes();

//        String dbName = new String("bank");
//        Mongo mongo = new Mongo();
//        Datastore datastore = morphia.createDatastore(mongo, dbName);

//        morphia.mapPackage("org.scm.ojt.rest.entity");

//        Address address = new Address();
//        address.setNumber("81");
//        address.setStreet("Mongo Street");
//        address.setTown("City");
//        address.setPostcode("CT81 1DB");
//
//        Account account = new Account();
//        account.setName("Personal Account");
//
//        List<Account> accounts = new ArrayList<Account>();
//        accounts.add(account);
//
//        Customer customer = new Customer();
//        customer.setAddress(address);
//        customer.setName("Mr Bank Customer");
//        customer.setAccounts(accounts);
//
//        Key<Customer> savedCustomer = datastore.save(customer);
//        System.out.println(savedCustomer.getId());
//
//        // WITH DAO
//        CustomerDAO customerDAO = new CustomerDAO(datastore);
//        Customer customerWithDAO = new Customer();
//        customerWithDAO.setAddress(address);
//        customerWithDAO.setName("Mr Bank Customer DAO");
//        customerWithDAO.setAccounts(accounts);
//
//        Key<Customer> savedCustomerWithDAO = customerDAO.save(customerWithDAO);
//        System.out.println(savedCustomerWithDAO.getId());
//
////        ObjectId id = savedCustomerWithDAO.getId();
//        ObjectId oid = new ObjectId(savedCustomerWithDAO.getId().toString());
//        Customer savedCustomerWithDAOGet = customerDAO.get(oid);
//        System.out.println(savedCustomerWithDAOGet.getId());
//
//        ModelMapper modelMapper = new ModelMapper();
//        CustomerDTO customerDTO = modelMapper.map(savedCustomerWithDAOGet, CustomerDTO.class);
//        System.out.println(customerDTO.getId());

//        CustomerDAO customerDAO = new CustomerDAO(morphia, mongo, dbName);
//        customerDAO.save(customer);
//
//        Query<Customer> query = datastore.createQuery(Customer.class);
//        query.and(
//                query.criteria("accounts.name").equal("Personal Account"),
//                query.criteria("address.number").equal("81"),
//                query.criteria("name").contains("Bank")
//        );
//
//        QueryResults<Customer> retrievedCustomers =  customerDAO.find(query);
//
//        for (Customer retrievedCustomer : retrievedCustomers) {
//            System.out.println(retrievedCustomer.getName());
//            System.out.println(retrievedCustomer.getAddress().getPostcode());
//            System.out.println(retrievedCustomer.getAccounts().get(0).getName());
//            customerDAO.delete(retrievedCustomer);
//        }

        // SCHEDULER
        final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.print(new Date());
            }
        }, 0, 10, TimeUnit.SECONDS);

        final ApiServer server = new ApiServer(
                ConfigurationManager.
                        getInstance().
                        getAppConfigData().
                        port()
        );
        server.run();
    }

//    public void testMorphia(){
//        Morphia morphia = new Morphia();
//        morphia.mapPackage("org.scm.ojt.rest.entity");
//        MongoConfigData mongoConfigData = ConfigurationManager.getInstance().getMongoConfigData();
//
//        ServerAddress addr = new ServerAddress(
//                mongoConfigData.host(),
//                mongoConfigData.port()
//        );
//        List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
//        MongoCredential credentia = MongoCredential.createCredential(
//                mongoConfigData.username(), mongoConfigData.database(), mongoConfigData.password().toCharArray());
//        credentialsList.add(credentia);
//        MongoClient client = new MongoClient(addr, credentialsList);
//
//        Datastore datastore = morphia.createDatastore(
//                client,
//                mongoConfigData.database()
//        );
//        datastore.ensureIndexes();
//
////        String dbName = new String("bank");
////        Mongo mongo = new Mongo();
////        Datastore datastore = morphia.createDatastore(mongo, dbName);
//
//        morphia.mapPackage("com.city81.mongodb.morphia.entity");
//
//        Address address = new Address();
//        address.setNumber("81");
//        address.setStreet("Mongo Street");
//        address.setTown("City");
//        address.setPostcode("CT81 1DB");
//
//        Account account = new Account();
//        account.setName("Personal Account");
//
//        List<Account> accounts = new ArrayList<Account>();
//        accounts.add(account);
//
//        Customer customer = new Customer();
//        customer.setAddress(address);
//        customer.setName("Mr Bank Customer");
//        customer.setAccounts(accounts);
//
//        Key<Customer> savedCustomer = datastore.save(customer);
//        System.out.println(savedCustomer.getId());
//    }
}
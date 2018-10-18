package org.scm.ojt.rest.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.dao.DAO;
import org.scm.ojt.rest.entity.Customer;

import javax.inject.Inject;

/**
 * Created by Yoyok_T on 18/10/2018.
 *
 THIS IS AN APPROACH TO CREATE DAO BASED ON ENTITY
 WHIT THIS APPROACH WE CAN SIMPLIFY THE IMPLEMENTATION OF MANY DAO
 */
public class DAOManager {
    private final ConnectionManager connectionManager;
    public final DAO<Customer, ObjectId> userDAO;

    @Inject
    public DAOManager(ConnectionManager connectionManager){
        this.connectionManager = connectionManager;
        userDAO = new BasicDAO<Customer, ObjectId>(Customer.class,this.connectionManager.getDatastore());
    }
}

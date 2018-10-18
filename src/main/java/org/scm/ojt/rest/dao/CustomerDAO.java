package org.scm.ojt.rest.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.scm.ojt.rest.entity.Customer;

/**
 * Created by Yoyok_T on 16/10/2018.

 THIS IS AN APPROACH TO CREATE DAO BASED ON ENTITY
 WHIT THIS APPROACH WE CAN ENHANCE THE DAO EASILY FOR THE ENTITY
 */
public class CustomerDAO extends BasicDAO<Customer, ObjectId> {

    public CustomerDAO(Datastore datastore){
        super(datastore);
    }
}

package org.scm.ojt.rest.dao;

import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.scm.ojt.rest.entity.Supplier;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Yoyok_T on 11/10/2018.
 */
public class SupplierDAO {
    private final ConnectionManager connectionManager;

    @Inject
    public SupplierDAO(ConnectionManager connectionManager){
        this.connectionManager = connectionManager;
    }

    public List<Supplier> listSupplier(){
        final Query<Supplier> query = connectionManager.getDatastore().createQuery(Supplier.class);
        final List<Supplier> suppliers = query.asList();
        return suppliers;
    }

    public Key createSupplier(Supplier supplier){
        return connectionManager.getDatastore().save(supplier);
    }

    public Supplier getSupplierByID(Key id){
        final Query<Supplier> query = connectionManager.getDatastore().createQuery(Supplier.class);
        return query.filter("_id =", id).get();
    }
}

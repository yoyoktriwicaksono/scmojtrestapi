package org.scm.ojt.rest.dao;

import org.mongodb.morphia.dao.BasicDAO;
import org.scm.ojt.rest.model.Supplier;

import javax.inject.Inject;

/**
 * Created by Yoyok_T on 28/10/2018.
 */
public class SupplierDAO2 extends BasicDAO {
    private final ConnectionManager connectionManager;
    private final BasicDAO supplierDAO;

    @Inject
    public SupplierDAO2(ConnectionManager connectionManager){
        super(connectionManager.getDatastore());
        this.connectionManager = connectionManager;
        this.supplierDAO = new BasicDAO(Supplier.class,this.connectionManager.getDatastore());
    }
}

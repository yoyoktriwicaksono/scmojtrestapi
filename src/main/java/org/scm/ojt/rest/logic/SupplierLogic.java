package org.scm.ojt.rest.logic;

import org.mongodb.morphia.Key;
import org.scm.ojt.rest.dao.SupplierDAO;
import org.scm.ojt.rest.dao.TestDAO;
import org.scm.ojt.rest.model.Supplier;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Yoyok_T on 11/10/2018.
 */
public class SupplierLogic {
    @Inject
    private SupplierDAO supplierDAO;

    public List<Supplier> listSupplier(){
        return supplierDAO.listSupplier();
    }

    public Supplier createSupplier(Supplier supplier){
        Key key = supplierDAO.createSupplier(supplier);
        Supplier supplierResponse = supplierDAO.getSupplierByID(key);
        return supplierResponse;
    }
}

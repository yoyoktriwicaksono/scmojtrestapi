package org.scm.ojt.rest.dao;

import org.scm.ojt.rest.model.Employee;
import javax.inject.Inject;

/**
 * Created by Yoyok_T on 28/09/2018.
 */
public class TestDAO {

    private final ConnectionManager connectionManager;

    @Inject
    public TestDAO(ConnectionManager connectionManager){
        this.connectionManager = connectionManager;
    }

    public String getTest(){
        final Employee elmer = new Employee();
        elmer.setName("Elmer Fudd");
        elmer.setSalary(50000.0);
        connectionManager.getDatastore().save(elmer);

        return "get Todo Logic Test - DAO - Inject";
    }
}

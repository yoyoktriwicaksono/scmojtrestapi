package org.scm.ojt.rest.logic;

import org.scm.ojt.rest.dao.TestDAO;

import javax.inject.Inject;

public class TestLogic {

    @Inject private TestDAO testDAO;

//    @Inject private Datastore datastore;
//    public TestLogic(){
//
//    }

    public String getTest(){

        return testDAO.getTest(); //"get Todo Logic Test - Inject";
    }
}
package org.scm.ojt.rest.services;

import org.scm.ojt.rest.logic.TestLogic;
import org.scm.ojt.rest.entity.EntityModel;
import com.google.inject.Singleton;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Yoyok_T on 28/09/2018.
 */
@Singleton
@Api("Test")
@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestService {
    private TestLogic testLogic;

    @Inject
    public TestService(TestLogic testLogic){
        this.testLogic = testLogic;
    }

    @GET
    @Path("/gettest")
    @ApiOperation(value="Get Test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTest() {
        EntityModel entity = new EntityModel();
        // entity.setName(configurationManager.getAppConfigData().port());
        entity.setName(testLogic.getTest());
        entity.setAddress(testLogic.getTest());
        return Response.ok().entity(entity).build();
    }

//    @GET
//    @Path("/getstring")
//    @ApiOperation(value="Get Test")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getString() {
//        return Response.ok().entity().build();
//    }

}

package com.sdua.api.resource;

import com.sdua.api.bean.Bug;
import com.sdua.api.bean.MyResponse;
import com.sdua.api.service.sduaService;
import com.sdua.api.bean.DisplayData;
import com.sdua.api.bean.Result;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/sdua")
@Api(value = "/sdua")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class sduaResource {

    @Inject
    public sduaResource(com.sdua.api.service.sduaService sduaService) {
        this.sduaService = sduaService;
    }
    private  final sduaService  sduaService;



    @GET
    @Timed
    @Path("/squareroot{value1}")
    public Result squareroot(@PathParam("value1") Double value1) {

        return sduaService.squareroot(value1);
    }


    @POST
    @Path("/userdetails")

    public Object show(@ApiParam()@Valid DisplayData userData){

        return sduaService.show(userData);
    }


    @POST
    @Path("/bugs")
    public MyResponse createbug(@ApiParam()@Valid Bug userbug){
        return  sduaService.createbug(userbug);


    }


    @GET
    @Path("/bugs")
    public MyResponse getbugs(@QueryParam("sort_type") String sort_type , @QueryParam("sort_value") String sort_value){
        return sduaService.getbugs(sort_type, sort_value);

    }

    @PUT
    @Path("/bugs")
    public MyResponse updatebug(@ApiParam()@Valid Bug userbug){
        return sduaService.updatebug(userbug);
    }

    @DELETE
    @Path("/bugs")
    public MyResponse deletebug(@QueryParam("bug_id") int bug_id){

        return sduaService.deletebug(bug_id);
    }




}

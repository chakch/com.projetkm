/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetkm;

import dataRepo.RepoData;
import java.net.URISyntaxException;
import java.util.Calendar;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * REST Web Service
 *
 * @author chaaben mohamed
 */
@Path("")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of tweets.GenericResource
     * @return an instance of java.lang.String
     * @throws java.net.URISyntaxException
     * 
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    
    public String Getall() throws URISyntaxException {
        
        return RepoData.Getall();
    }
      @GET
    @Path("allLables")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    
    public String GetallLables() throws URISyntaxException {
        
        return RepoData.GetallLabels();
    }
    @GET
    @Path("{type}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    
    public String GetByType(@PathParam("type") String type) throws URISyntaxException {
        
        return RepoData.GetType(type);
    }
    @GET
    @Path("{class}/{instance}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String GetByTypeConnection(@PathParam("class") String cla,@PathParam("instance") String ins) throws URISyntaxException {
        
        return RepoData.GetConIns(cla,ins);
    }
    
    @GET
    @Path("{instance1}/{class}/{instance2}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String GetByTypeConnectionTwoInst(@Context UriInfo uriInfo, @PathParam("class") String cla, @PathParam("instance1") String ins1, @PathParam("instance2") String ins2) throws URISyntaxException {
        String mInstance, mClass = "";
        mInstance = uriInfo.getQueryParameters().getFirst("I");
        mClass = uriInfo.getQueryParameters().getFirst("C");
        System.out.println(mInstance);
        if (mInstance == null && mClass == null) {
            return RepoData.GetInConnIn(ins1, cla, ins2);
        } else if (mInstance == null) {
            return RepoData.GetInClaInCla(ins1, cla, ins2, mClass);
        } else if (mClass == null) {
            return RepoData.GetInClaInIn(ins1, cla, ins2, mInstance);
        } else {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
    
    
    
   /* @GET
    @Path("{first}/{second}/{third}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String GetElement(@PathParam("first") String first,
                            @PathParam("second") String second,
                            @PathParam("third") String third,
                            @QueryParam("type") String type
    ) throws URISyntaxException {
        System.out.println(first);
        
        return RepoData.GetConnConnIn(first.replace("+", ""),second,third,type);
    }*/
   


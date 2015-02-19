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
    @Path("{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetByType(@PathParam("type") String type) throws URISyntaxException {
        
        return RepoData.GetType(type);
    }
    @GET
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetByType() throws URISyntaxException {
        
        return "hello";
    }

}

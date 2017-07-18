/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verif.projectgen;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author cesi
 */
@Path("verif")
public class VerifResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VerifResource
     */
    public VerifResource() {
    }

    /**
     * Retrieves representation of an instance of com.verif.projectgen.VerifResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        String restMsg="{\"message\":\"hello REST\"}";
        return restMsg; 
    }

    /**
     * PUT method for updating or creating an instance of VerifResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}

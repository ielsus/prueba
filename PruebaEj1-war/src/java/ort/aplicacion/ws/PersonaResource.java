/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.aplicacion.ws;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ort.aplicacion.entidades.Persona;

/**
 * REST Web Service
 *
 * @author chevi
 */
@Path("personas")
public class PersonaResource {

    @Context
    private UriInfo context;
    
    private Gson gson;
    

    /**
     * Creates a new instance of PersonaResource
     */
    public PersonaResource() {
        
        this.gson = new Gson();
        
    }

    /**
     * Retrieves representation of an instance of ort.aplicacion.ws.PersonaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@QueryParam("nombre") String nombre) {
        //TODO return proper representation object
        
        Response r;
       
      if (nombre == null) {
            r = Response.status(Response.Status.BAD_REQUEST).entity("falta nombre").build();
        } else {
            Persona persona = new Persona(1L, nombre);
            String personaJson = gson.toJson(persona);
            r = Response
                .status(Response.Status.OK)
                .entity(personaJson)
                .build();
        }
        
        /*
        Response response;
        
        if (nombre == null) {
            response = Response
                .status(400)
                .entity("falta nombre")
                .build();
        } else {
            Persona persona = new Persona(1L, "Juan");
            String personaJson = gson.toJson(persona);
            response = Response
                .status(Response.Status.OK)
                .entity(personaJson)
                .build();
        }
        */
        return r;

    }

    /**
     * PUT method for updating or creating an instance of PersonaResource
     * @param content representation for the resource
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(String content) {
        Persona persona = gson.fromJson(content, Persona.class);

        return Response
                .status(Response.Status.OK)
                .entity("Persona creada")
                .build();
    }
}

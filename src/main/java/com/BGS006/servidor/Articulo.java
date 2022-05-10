package com.BGS006.servidor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("articulos")
public class Articulo {


    @GET
    @Path("/verArticulos")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<com.BGS006.cliente.jdo.Articulo > getArticulos() {
        ArrayList<com.BGS006.cliente.jdo.Articulo > articulos = new ArrayList<>();
        //UsuarioDB.getAllUsers(Articulo);
        return articulos;
    }

    @POST
    @Path("/anyadirArticulos")
    public Boolean AnyadirArticulo(Articulo articulo){


        return true;
    }
}

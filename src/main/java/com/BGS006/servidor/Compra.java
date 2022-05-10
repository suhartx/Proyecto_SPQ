package com.BGS006.servidor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("compras")
public class Compra {

    @GET
    @Path("/verCompras")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<com.BGS006.cliente.jdo.Compra > getUsers() {
        ArrayList<com.BGS006.cliente.jdo.Compra > compras = new ArrayList<>();
        //ComprasDB.(users);
        return compras;
    }

    @POST
    @Path("/anyadirCompras")
    public Boolean AnyadirUsuario(Usuario usuario){


        return true;
    }
}

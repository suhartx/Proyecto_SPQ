package com.BGS006.servidor;

import com.BGS006.bbdd.UsuarioDB;
import com.BGS006.dao.UsuarioDAO;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * CLASE USUARIO DEL SERVIDOR QUE PERMITE GUARDAR EN LA BASE DE DATOS
 */
@Path("usuarios")
public class Usuario {



    /**
     * This method returns a list of all the users
     * @return
     */
    @GET
    @Path("/VerUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<com.BGS006.cliente.jdo.Usuario> getUsers() {
        ArrayList<com.BGS006.cliente.jdo.Usuario> users = new ArrayList<>();
        UsuarioDB.getAllUsers(users);
        return users;
    }
    /**
     * this method allows you to introduce an user in the database
     * @param usuario
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/AnyadirUsuario")
    public void AnyadirUsuario(com.BGS006.cliente.jdo.Usuario usuario){


        UsuarioDAO.getInstance().saveObject(usuario);


    }



}
package com.BGS006.servidor;

import com.BGS006.bbdd.UsuarioDB;
import com.BGS006.dao.UsuarioDAO;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/AnyadirUsuario")
    public void AnyadirUsuario(com.BGS006.cliente.jdo.Usuario usuario){

//        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
//
//        System.out.println("DataNucleus AccessPlatform with JDO");
//        System.out.println("===================================");
//
//        System.out.println(usuario.toString());
//
//
//        // Persistence of a set of Accounts and a User
//        PersistenceManager pm = pmf.getPersistenceManager();
//        Transaction tx=pm.currentTransaction();
//
//        try
//        {
//            tx.begin();
//            System.out.println("Persisting users");
//            pm.makePersistent(usuario);
//            System.out.println("Persisting users");
//
//            tx.commit();
//            System.out.println("Persisting users");
//
//            System.out.println("User and his articles have been persisted");
//
//            System.out.println("USUARIO AÑADIDO CON EL SERVIDOR");
//
//            System.out.println("Usuario Creado: " + usuario.toString() );
//
//
//
//        }
//        finally
//        {
//            if (tx.isActive())
//            {
//                tx.rollback();
//            }
//            pm.close();
//        }
//        System.out.println("");


//        //return Response.ok().build();


//        UsuarioDB.getInstance().insertarUsuarios(usuario);

        System.out.println(usuario.getNombre());
        System.out.println(usuario.getContrasenya());
        System.out.println(usuario.getTarjetaPago());
        System.out.println(usuario.getRutaAvatar());

        UsuarioDAO.getInstance().saveObject(usuario);


    }



}
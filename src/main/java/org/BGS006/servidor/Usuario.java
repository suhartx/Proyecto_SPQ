package org.BGS006.servidor;

import org.BGS006.database.UsuarioDB;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("usuarios")
public class Usuario {

    /**
     * This method returns a list of all the users
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<org.BGS006.cliente.jdo.Usuario > getUsers() {
        ArrayList<org.BGS006.cliente.jdo.Usuario > users = new ArrayList<>();
        UsuarioDB.getAllUsers(users);
        return users;
    }

}
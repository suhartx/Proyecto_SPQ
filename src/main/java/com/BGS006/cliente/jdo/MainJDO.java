package com.BGS006.cliente.jdo;

import com.BGS006.dao.UsuarioDAO;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class MainJDO {
/*
 * Clase que inserta datos haciendo uso de maven y jdo
 */
public static void main(String[] args)
{
//    // Create a PersistenceManagerFactory for this datastore
//    PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
//
//    System.out.println("DataNucleus AccessPlatform with JDO");
//    System.out.println("===================================");
//
//    // Persistence of a set of Accounts and a User
//    PersistenceManager pm = pmf.getPersistenceManager();
//    Transaction tx=pm.currentTransaction();
//    try
//    {
//        tx.begin();
//        System.out.println("Persisting users");
//        Usuario dipina = new Usuario("dipina", "dipina","","");
////        Articulo articulo1 = new Articulo("Nike1",100, "src/main/resources/imagenes/airJordan1Retro.jpg");
////        Articulo articulo2 = new Articulo("Nike2",100,"src/main/resources/imagenes/airJordan1Retro.jpg");
////        dipina.getCarro().add(articulo1);
////        dipina.getCarro().add(articulo2);
//        pm.makePersistent(dipina);
//        tx.commit();
//        System.out.println("User and his articles have been persisted");
//    }
//    finally
//    {
//        if (tx.isActive())
//        {
//            tx.rollback();
//        }
//        pm.close();
//    }
//    System.out.println("");
    UsuarioDAO u = new UsuarioDAO();

    Usuario suhar = new Usuario("suhar", "suhar","","src/main/resources/avatares/Avatar2.png");


    Articulo a1 = new Zapatillas("Jordan 1 Retro",20,1,"src/main/resources/imagenes/airJordan1Retro.jpg",6,5, "negro","H");
    Articulo a2 = new Calcetines("Nike shocks",9,2,"src/main/resources/imagenes/calcetinesNike.jpg",9,5,"rojo","h");
    Articulo a3 = new Limpiador("Creep Clean",19,3,"src/main/resources/imagenes/limpiadorCreep.jpg",33,true);


    Compra c1 = new Compra(1,"suhar",30,5);
    c1.anyadirArticulo(a1);
    suhar.addCarrito(a3);
    c1.anyadirArticulo(a2);
    suhar.addPedido(c1);



    u.saveObject(suhar);



//
//
//    // Basic Extent of all Messages
//    pm = pmf.getPersistenceManager();
//    tx = pm.currentTransaction();
//    try
//    {
//        tx.begin();
//        System.out.println("Retrieving Extent for Messages");
//        Extent<Articulo> e = pm.getExtent(Articulo.class, true);
//        Iterator<Articulo> iter = e.iterator();
//        while (iter.hasNext())
//        {
//            Object obj = iter.next();
//            System.out.println(">  " + obj);
//        }
//        tx.commit();
//    }
//    catch (Exception e)
//    {
//        System.out.println("Exception thrown during retrieval of Extent : " + e.getMessage());
//    }
//    finally
//    {
//        if (tx.isActive())
//        {
//            tx.rollback();
//        }
//        pm.close();
//    }
//    System.out.println("");
//
//
//
//    // Clean out the database
//    pm = pmf.getPersistenceManager();
//    tx = pm.currentTransaction();
//    try
//    {
//        tx.begin();
//
//        System.out.println("Deleting all users from persistence");
//        Query<Usuario> q2 = pm.newQuery(Usuario.class);
//        long numberInstancesDeleted2 = q2.deletePersistentAll();
//        System.out.println("Deleted " + numberInstancesDeleted2 + " users");
//
//        tx.commit();
//    }
//    finally
//    {
//        if (tx.isActive())
//        {
//            tx.rollback();
//        }
//        pm.close();
//    }
//
//    System.out.println("");
//    System.out.println("End of JDO extension for RMI assignment");
    }
}
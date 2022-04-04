package com.BGS006.Cliente.jdo;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class MainJDO {
/*
 * Clase que inserta datos haciendo uso de maven y jdo
 */
    public static void main(String[] args) {

            PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                
/*                 Usuario userA = new Usuario("John", "Smith","","","","jdo","",1,false);
                pm.makePersistent(userA);
                Usuario userB = new Usuario("Albert", "Einstein","","","","mekatorke","",1,false);
                pm.makePersistent(userB);
                Usuario userC = new Usuario("Isaac", "Newton","","","","gnomo","",12,true);
                pm.makePersistent(userC);

                Producto productoA = new Producto("nVidiaGTX","gygabyte",300.0f,"Grafica series 3000");
                pm.makePersistent(productoA); */


                tx.commit();


            } finally {
            	
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }
}
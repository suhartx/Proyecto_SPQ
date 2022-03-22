/**********************************************************************
Copyright (c) 2003 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
    ...
**********************************************************************/
package org.datanucleus.samples.jdo.tutorial;


import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Extent;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

/**
 * Controlling application for the DataNucleus Tutorial using JDO.
 * Relies on the user defining a file "datanucleus.properties" to be in the CLASSPATH
 * and to include the JDO properties for the DataNucleus PersistenceManager.
 * @author      Diego Lopez-de-Ipina 
 * @version     1.0                                    
 * @since       2012-02-01        
 */
public class Main
{
    @SuppressWarnings("unchecked")
	public static void main(String args[])
    {
    	System.out.println("Starting ....");
        // Create a PersistenceManagerFactory for this datastore
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        // Persistence of a Product and a Book.
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("Persisting products");
            Product product = new Product("Sony Discman","A standard discman from Sony",200.00);
            Book book = new Book("Lord of the Rings by Tolkien","The classic story",49.99,"JRR Tolkien", "12345678", "MyBooks Factory");
            pm.makePersistent(product);
            pm.makePersistent(book);
 
            tx.commit();
            System.out.println("Product and Book have been persisted");
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");

        // Basic Extent of all Products
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("Retrieving Extent for Products");
            Extent<Product> e = pm.getExtent(Product.class, true);
            Iterator<Product> iter = e.iterator();
            while (iter.hasNext())
            {
                Object obj = iter.next();
                System.out.println(">  " + obj);
            }
            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception thrown during retrieval of Extent : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");

        // Perform some query operations
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("Executing Query for Products with price below 150.00");
            Extent<Product> e=pm.getExtent(Product.class,true);
            Query<Product> q=pm.newQuery(e, "price < 150.00");
            q.setOrdering("price ascending");
                        
            for (Product product : (List<Product>)q.execute()) {
            	System.out.println(">  " + product);
            	if (product instanceof Book)
                {
                    Book b = (Book)product;
                    // Give an example of an update
                    b.setDescription("This book has been reduced in price!");
                    System.out.println("This book has been reduced in price!");
                }
    
            }

            tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");

        // Clean out the database
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("Deleting all products from persistence");
            Query<Product> q = pm.newQuery(Product.class);
            long numberInstancesDeleted = q.deletePersistentAll();
            System.out.println("Deleted " + numberInstancesDeleted + " products");

            tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }

        System.out.println("");
        System.out.println("End of Tutorial");
		pmf.close();
    }
}

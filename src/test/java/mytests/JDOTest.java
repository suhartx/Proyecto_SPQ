package	mytests;

import org.junit.*;

import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Extent;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

import org.datanucleus.samples.jdo.tutorial.*;

/**
 * @author      Diego López-de-Ipiña <dipina@deusto.es>
 * @version     1.0
 * @since       2012-02-01
 * <p><This program shows how to use a set of classes prepared to be made serializable through <b>JDO</b></p>
 *
 */

public class JDOTest {
	/**
	 * This variable represents the persistence manager factory instance
	 */
	private PersistenceManagerFactory pmf = null;
	/**
	* This variable represents the persistence manager instance
	*/
	private PersistenceManager pm = null;
	/**
	* This variable represents the transaction instance
	*/
	private Transaction tx = null;

	/**
	 * It initializes the variables used by the other methods
	 */
	@Before
    public void setUp() throws Exception {
        // Code executed before each test
		this.pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        // Persistence of a Product and a Book.
        this.pm = this.pmf.getPersistenceManager();
        this.tx = this.pm.currentTransaction();
    }

	/**
	 * Converts to upper cases. Simple (bogus) method only created to show how to document the input parameters and output of a method.
	 * @param str String to convert to capital letters
	 * @return The string converted into capital letters
	*/
	private String convert2Upcase(String str) {
		return str.toUpperCase();
	}


	/**
	 * Tests Product creation
	*/
	@Test
    public void testProductCreation() {
        try
        {
            tx.begin();
            System.out.println(this.convert2Upcase("Persisting products"));
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
	}

	/**
	 * Tests Product Extents
	*/
	@Test
    public void testProductExtent() {
        // Basic Extent of all Products
        this.pm = this.pmf.getPersistenceManager();
        this.tx = this.pm.currentTransaction();
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
	}

	/**
	 * Tests Product queries
	*/
	@SuppressWarnings("unchecked")
	@Test
    public void testProductQuery() {
        // Perform some query operations
        this.pm = this.pmf.getPersistenceManager();
        this.tx = pm.currentTransaction();
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
	}

	/**
	 * Tests Product deletion
	*/
	@Test
    public void testProductDeletion() {
        // Clean out the database
        pm = this.pmf.getPersistenceManager();
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
    }

	/**
	 * Temoves everything not needed after executing a test
	*/
	@After
    public void tearDown() throws Exception {

        if (this.pm != null) {
			this.pm.close();
		}

    }
}

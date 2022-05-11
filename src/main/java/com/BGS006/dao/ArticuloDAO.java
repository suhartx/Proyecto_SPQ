package com.BGS006.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.BGS006.cliente.jdo.Articulo;
import com.BGS006.cliente.jdo.Compra;


public class ArticuloDAO extends DataAccessObjectBase implements IDataAccessObject<Articulo> {

    private static ArticuloDAO instance;

    public static ArticuloDAO getInstance() {
        if (instance == null) {
            instance = new ArticuloDAO();
        }

        return instance;
    }

    private ArticuloDAO() {
    }

    @Override
    public void delete(Articulo object) {
        // TODO Auto-generated method stub
        super.deleteObject(object);
    }

    @Override
    public Articulo find(String param) {
        // TODO Auto-generated method stub
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        Articulo result = null;

        try {
            tx.begin();

            Query<?> query = pm.newQuery("SELECT FROM " + Compra.class.getName() + " WHERE IDCOMPRA == " + param);
            query.setUnique(true);
            result = (Articulo) query.execute();

            tx.commit();
        } catch (Exception ex) {
            System.out.println("  $ Error solicitando la compra: " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            pm.close();
        }

        return result;
    }

    @Override
    public List<Articulo> getAll() {
        // TODO Auto-generated method stub
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        List<Articulo> articulos = new ArrayList<>();

        try {
            tx.begin();

            Extent<Articulo> extent = pm.getExtent(Articulo.class, true);

            for (Articulo category : extent) {
                articulos.add(category);
            }

            tx.commit();
        } catch (Exception ex) {
            System.out.println("  $ Error devolviendo todas las compras: " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            pm.close();
        }

        return articulos;
    }

    @Override
    public void save(Articulo object) {
        // TODO Auto-generated method stub
        super.saveObject(object);
    }

}

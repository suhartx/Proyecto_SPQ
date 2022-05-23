package com.BGS006.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.BGS006.cliente.jdo.Compra;


public class CompraDAO extends DataAccessObjectBase implements IDataAccessObject<Compra> {

	private static CompraDAO instance;

	/**
	 * Metodo que permite la conexion entre objetos
	 * @return instancia del obejto compra
	 */
	public static CompraDAO getInstance() {
		if (instance == null) {
			instance = new CompraDAO();
		}

		return instance;
	}

	private CompraDAO() {
	}

	/**
	 * Metodo que elimina una compra
	 * @param object
	 */
	@Override
	public void delete(Compra object) {
		// TODO Auto-generated method stub
		super.deleteObject(object);
	}

	/**
	 * Metodo que busca una compra
	 * @param param Nombre de la compra
	 * @return Compra
	 */
	@Override
	public Compra find(String param) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		Compra result = null;

		try {
			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + Compra.class.getName() + " WHERE IDCOMPRA == " + param);
			query.setUnique(true);
			result = (Compra) query.execute();

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

	/**
	 * Metodo que devuele una lista con compras
	 * @return lista de Compras
	 */
	@Override
	public List<Compra> getAll() {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Compra> compras = new ArrayList<>();

		try {
			tx.begin();

			Extent<Compra> extent = pm.getExtent(Compra.class, true);

			for (Compra category : extent) {
				compras.add(category);
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

		return compras;
	}

	/**
	 * Metodo que guarda una compra
	 * @param object
	 */
	@Override
	public void save(Compra object) {
		// TODO Auto-generated method stub
		super.saveObject(object);
	}

}

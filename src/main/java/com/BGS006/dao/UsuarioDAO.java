package com.BGS006.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.BGS006.cliente.jdo.Usuario;


//This class implements Singleton and DAO patterns
public class UsuarioDAO extends DataAccessObjectBase implements IDataAccessObject<Usuario> {

	private static UsuarioDAO instance;

	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}

		return instance;
	}

	private UsuarioDAO() {
	}

	@Override
	public void delete(Usuario object) {
		super.deleteObject(object);
	}

	@Override
	public Usuario find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		Usuario result = null;

		try {
			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE NOMBRE == '" + param + "'");
			query.setUnique(true);
			result = (Usuario) query.execute();

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a User: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}

	@Override
	public List<Usuario> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Usuario> users = new ArrayList<>();

		try {
			tx.begin();

			Extent<Usuario> userExtent = pm.getExtent(Usuario.class, true);

			for (Usuario user : userExtent) {
				users.add(user);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all users: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return users;
	}

	@Override
	public void save(Usuario object) {

		super.saveObject(object);
	}
}
package com.BGS006.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.BGS006.cliente.jdo.Usuario;


/**
 * Clase que gestiona el DAO del usuario
 */
public class UsuarioDAO extends DataAccessObjectBase implements IDataAccessObject<Usuario> {

	/**
	 * Metodo que elimina un usario
	 * @param object
	 */
	@Override
	public void delete(Usuario object) {
		super.deleteObject(object);
	}

	/**
	 * Metodo que busca un usuario
	 * @param param
	 * @return
	 */
	@Override
	public Usuario find(String param) {
		Transaction tx = pmf.getPersistenceManager().currentTransaction();

		Usuario result = null;

		try {
			tx.begin();

			Query<?> query = pmf.getPersistenceManager().newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE NOMBRE == '" + param + "'");
			query.setUnique(true);
			result = (Usuario) query.execute();

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a User: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pmf.getPersistenceManager().close();
		}

		return result;
	}

	/**
	 * Metodo que devuelve una lista con todos los usuarios
	 * @return lista de usuarios
	 */
	@Override
	public List<Usuario> getAll() {

		List<Usuario> users = new ArrayList<>();

		try {
			pmf.getPersistenceManager().currentTransaction().begin();

			Extent<Usuario> userExtent = pmf.getPersistenceManager().getExtent(Usuario.class, true);

			for (Usuario user : userExtent) {
				users.add(user);
			}

			pmf.getPersistenceManager().currentTransaction().commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all users: " + ex.getMessage());
		} finally {
			if (pmf.getPersistenceManager().currentTransaction() != null && pmf.getPersistenceManager().currentTransaction().isActive()) {
				pmf.getPersistenceManager().currentTransaction().rollback();
			}

			pmf.getPersistenceManager().close();
		}

		return users;
	}

	/**
	 * Metodo que guarda un usuario
	 * @param object
	 */
	@Override
	public void save(Usuario object) {

		super.saveObject(object);
	}
}
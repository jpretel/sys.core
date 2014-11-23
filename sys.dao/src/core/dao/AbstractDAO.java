package core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import core.DAOConfig;

public abstract class AbstractDAO<T> {
	private Class<T> entityClass;
	protected EntityManagerFactory factory;
	protected EntityManager em;
	protected CriteriaBuilder cb;

	public AbstractDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
		factory = DAOConfig.entityFactory; //Persistence.createEntityManagerFactory("sys.dao");
		em = factory.createEntityManager();
		cb = getEntityManager().getCriteriaBuilder();
	}

	public EntityManager getEntityManager() {
		return this.em;
	}

	public void create(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(entity);
		getEntityManager().getTransaction().commit();
	}

	public void create(List<T> entities) {
		getEntityManager().getTransaction().begin();
		for (T entity : entities) {
			getEntityManager().persist(entity);
		}
		getEntityManager().getTransaction().commit();
	}

	public void edit(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();
	}

	public void crear_editar(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();
	}

	public void remove(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(getEntityManager().merge(entity));
		getEntityManager().getTransaction().commit();
	}

	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}

	/**
	 * 
	 * @return Todos los registros de una tabla SELECT * FROM
	 */
	public List<T> findAll() {
		CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder()
				.createQuery(entityClass);
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}

	// Lista los objetos por rango de busqueda
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> findRange(int[] range) {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder()
				.createQuery();
		cq.select(cq.from(entityClass));
		Query q = getEntityManager().createQuery(cq);
		q.setMaxResults(range[1] - range[0]);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	/**
	 * 
	 * @return El total de registros de una tabla SELECT COUNT(*) FROM
	 */
	public int count() {
		CriteriaQuery<Long> cq = getEntityManager().getCriteriaBuilder()
				.createQuery(Long.class);
		Root<T> rt = cq.from(entityClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		return getEntityManager().createQuery(cq).getSingleResult().intValue();
	}

	public List<T> rangeOfList(List<T> array, int[] range) {
		List<T> lista = new ArrayList<T>();
		for (int i = range[0]; i < range[1]; i++) {
			if (i >= array.size())
				break;
			lista.add(array.get(i));
		}
		return lista;
	}
}

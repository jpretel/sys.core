package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import core.entity.Almacen;
import core.entity.Consumidor;

public class ConsumidorDAO extends AbstractDAO<Consumidor> {

	public ConsumidorDAO() {
		super(Consumidor.class);
	}

	public List<Consumidor> findAllOrderByJerarquia() {
		CriteriaQuery<Consumidor> q = cb.createQuery(Consumidor.class);
		Root<Consumidor> c = q.from(Consumidor.class);
		q.select(c);
		q.orderBy(cb.asc(c.get("jerarquia")));
		return getEntityManager().createQuery(q).getResultList();
	}

	public String findMaxJerarquia() {
		CriteriaQuery<String> q = cb.createQuery(String.class);
		Root c = q.from(Consumidor.class);
		q.select((Selection<? extends String>) cb.max(c.get("jerarquia")));
		return getEntityManager().createQuery(q).getSingleResult();
	}
	
	public List<Consumidor> borrarByJerarquia() {
		CriteriaQuery<Consumidor> q = cb.createQuery(Consumidor.class);
		Root<Consumidor> c = q.from(Consumidor.class);
		q.select(c);
		q.orderBy(cb.asc(c.get("jerarquia")));
		return getEntityManager().createQuery(q).getResultList();
	}

	public void borrarPorConsumidor(Consumidor consumidor) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<Almacen> delete = cb.createCriteriaDelete(Almacen.class);
		Root<Almacen> c = delete.from(Almacen.class);
		delete.where(cb.equal(c.get("consumidor"), consumidor));
		Query query = getEntityManager().createQuery(delete);
		query.executeUpdate();
		getEntityManager().getTransaction().commit();
	}
}
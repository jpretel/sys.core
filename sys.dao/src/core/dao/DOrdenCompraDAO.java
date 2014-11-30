package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.DOrdenCompra;
import core.entity.OrdenCompra;

public class DOrdenCompraDAO extends AbstractDAO<DOrdenCompra> {

	public DOrdenCompraDAO() {
		super(DOrdenCompra.class);
	}

	public List<DOrdenCompra> getPorOrdenCompra(OrdenCompra oc) {
		CriteriaQuery<DOrdenCompra> q = cb.createQuery(DOrdenCompra.class);
		Root<DOrdenCompra> c = q.from(DOrdenCompra.class);
		Predicate condicion = cb.equal(c.get("ordencompra"), oc);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getResultList();
	}

	public void borrarPorOrdenCompra(OrdenCompra oc) {
		try {
			getEntityManager().getTransaction().begin();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			getEntityManager().getTransaction().begin();
		}

		CriteriaDelete<DOrdenCompra> delete = cb
				.createCriteriaDelete(DOrdenCompra.class);
		Root<DOrdenCompra> c = delete.from(DOrdenCompra.class);
		delete.where(cb.equal(c.get("ordencompra"), oc));
		Query query = getEntityManager().createQuery(delete);
		query.executeUpdate();
		try {
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		}
	}

}

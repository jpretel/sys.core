package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.CotizacionCompra;
import core.entity.DCotizacionCompra;

public class DCotizacionCompraDAO extends AbstractDAO<DCotizacionCompra> {

	public DCotizacionCompraDAO() {
		super(DCotizacionCompra.class);
	}

	public List<DCotizacionCompra> getPorCotizacionCompra(CotizacionCompra oc) {
		CriteriaQuery<DCotizacionCompra> q = cb
				.createQuery(DCotizacionCompra.class);
		Root<DCotizacionCompra> c = q.from(DCotizacionCompra.class);
		Predicate condicion = cb.equal(c.get("cotizacioncompra"), oc);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getResultList();
	}

	public void borrarPorCotizacionCompra(CotizacionCompra oc) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<DCotizacionCompra> delete = cb
				.createCriteriaDelete(DCotizacionCompra.class);
		Root<DCotizacionCompra> c = delete.from(DCotizacionCompra.class);
		delete.where(cb.equal(c.get("cotizacioncompra"), oc));
		Query query = getEntityManager().createQuery(delete);
		try {
			query.executeUpdate();
			getEntityManager().getTransaction().commit();			
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		}
	}

}

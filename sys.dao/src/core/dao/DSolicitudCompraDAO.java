package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.DSolicitudCompra;
import core.entity.SolicitudCompra;

public class DSolicitudCompraDAO extends AbstractDAO<DSolicitudCompra> {

	public DSolicitudCompraDAO() {
		super(DSolicitudCompra.class);
		// TODO Auto-generated constructor stub
	}

	public List<DSolicitudCompra> getPorSolicitudCompra(SolicitudCompra oc) {
		CriteriaQuery<DSolicitudCompra> q = cb
				.createQuery(DSolicitudCompra.class);
		Root<DSolicitudCompra> c = q.from(DSolicitudCompra.class);
		Predicate condicion = cb.equal(c.get("solicitudcompra"), oc);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getResultList();
	}

	public void borrarPorSolicitudCompra(SolicitudCompra solicitud) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<DSolicitudCompra> delete = cb
				.createCriteriaDelete(DSolicitudCompra.class);
		Root<DSolicitudCompra> c = delete.from(DSolicitudCompra.class);
		delete.where(cb.equal(c.get("solicitudcompra"), solicitud));
		Query query = getEntityManager().createQuery(delete);
		try {
			query.executeUpdate();
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		}
	}
}

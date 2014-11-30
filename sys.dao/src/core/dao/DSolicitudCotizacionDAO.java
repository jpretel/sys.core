package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.DSolicitudCotizacion;
import core.entity.SolicitudCotizacion;


public class DSolicitudCotizacionDAO extends AbstractDAO<DSolicitudCotizacion> {

	public DSolicitudCotizacionDAO() {
		super(DSolicitudCotizacion.class);
	}

	public List<DSolicitudCotizacion> getPorSolicitud(SolicitudCotizacion solicitud) {
		CriteriaQuery<DSolicitudCotizacion> q = cb.createQuery(DSolicitudCotizacion.class);
		Root<DSolicitudCotizacion> c = q.from(DSolicitudCotizacion.class);
		Predicate condicion = cb.equal(c.get("solicitud"), solicitud);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getResultList();
	}
	
	public void borrarPorSolicitudCorizacion(SolicitudCotizacion solicitud) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<DSolicitudCotizacion> delete = cb.createCriteriaDelete(DSolicitudCotizacion.class);
		Root<DSolicitudCotizacion> c = delete.from(DSolicitudCotizacion.class);
		delete.where(cb.equal(c.get("solicitud"), solicitud));
		Query query = getEntityManager().createQuery(delete);
		try {
			query.executeUpdate();
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		}
	}
}

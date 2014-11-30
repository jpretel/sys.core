package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.DOrdenServicio;
import core.entity.OrdenServicio;

public class DOrdenServicioDAO extends AbstractDAO<DOrdenServicio> {

	public DOrdenServicioDAO() {
		super(DOrdenServicio.class);
	}
	
	public List<DOrdenServicio> getPorOrdenServicio(OrdenServicio os) {
		CriteriaQuery<DOrdenServicio> q = cb.createQuery(DOrdenServicio.class);
		Root<DOrdenServicio> c = q.from(DOrdenServicio.class);
		Predicate condicion = cb.equal( c.get("ordenservicio"), os);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getResultList();
	}
	
	public void borrarPorOrdenServicio(OrdenServicio os) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<DOrdenServicio> delete = cb.createCriteriaDelete(DOrdenServicio.class);
		Root<DOrdenServicio> c = delete.from(DOrdenServicio.class);
		delete.where(cb.equal(c.get("ordenservicio"), os));
		Query query = getEntityManager().createQuery(delete);
		try {
			query.executeUpdate();
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		}
	}
}

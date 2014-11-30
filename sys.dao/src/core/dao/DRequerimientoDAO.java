package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.DRequerimiento;
import core.entity.Requerimiento;

public class DRequerimientoDAO extends AbstractDAO<DRequerimiento> {

	public DRequerimientoDAO() {
		super(DRequerimiento.class);
	}

	public List<DRequerimiento> getPorRequerimiento(Requerimiento requerimiento) {
		CriteriaQuery<DRequerimiento> q = cb.createQuery(DRequerimiento.class);
		Root<DRequerimiento> c = q.from(DRequerimiento.class);
		Predicate condicion = cb.equal(c.get("requerimiento"), requerimiento);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getResultList();
	}
	
	public void borrarPorRequerimiento(Requerimiento requerimiento) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<DRequerimiento> delete = cb.createCriteriaDelete(DRequerimiento.class);
		Root<DRequerimiento> c = delete.from(DRequerimiento.class);
		delete.where(cb.equal(c.get("requerimiento"), requerimiento));
		Query query = getEntityManager().createQuery(delete);
		try {
			query.executeUpdate();
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		}
	}

//	public List<DRequerimiento> aEliminar(Requerimiento requerimiento,
//			List<DRequerimiento> detalle) {
//		List<DRequerimiento> eliminar = new ArrayList<DRequerimiento>();
//		for (DRequerimiento o1 : getPorRequerimiento(requerimiento)) {
//			boolean existe = false;
//			salir: for (DRequerimiento o2 : detalle) {
//				if (o1.getId().equals(o2.getId())) {
//					existe = true;
//					break salir;
//				}
//			}
//			if (!existe)
//				eliminar.add(o1);
//		}
//		return eliminar;
//	}
}

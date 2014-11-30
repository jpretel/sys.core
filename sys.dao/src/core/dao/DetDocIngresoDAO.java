package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.DetDocingreso;
import core.entity.Docingreso;

public class DetDocIngresoDAO extends AbstractDAO<DetDocingreso> {
	public DetDocIngresoDAO(){
		super(DetDocingreso.class);
	}
	
	public List<DetDocingreso> getPorIngreso(Docingreso ingreso){
		CriteriaQuery<DetDocingreso> q = cb.createQuery(DetDocingreso.class);
		Root<DetDocingreso> c = q.from(DetDocingreso.class);
		Predicate condicion = cb.equal(c.get("docingreso"), ingreso);
		q.multiselect(c).where(condicion);
		return getEntityManager().createQuery(q).getResultList();
	}
	
	public void borrarPorIngreso(Docingreso ingreso) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<DetDocingreso> delete = cb.createCriteriaDelete(DetDocingreso.class);
		Root<DetDocingreso> c = delete.from(DetDocingreso.class);
		delete.where(cb.equal(c.get("docingreso"), ingreso));
		Query query = getEntityManager().createQuery(delete);
		try {
			query.executeUpdate();
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		}
	}
}

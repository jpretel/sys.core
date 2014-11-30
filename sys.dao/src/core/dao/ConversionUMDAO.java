package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.ConversionUM;
import core.entity.Unimedida;

public class ConversionUMDAO extends AbstractDAO<ConversionUM> {

	public ConversionUMDAO() {
		super(ConversionUM.class);
	}

	public List<ConversionUM> getPorUnimedida(Unimedida unimedida) {
		CriteriaQuery<ConversionUM> q = cb.createQuery(ConversionUM.class);
		Root<ConversionUM> c = q.from(ConversionUM.class);
		Predicate condicion = cb.equal(c.get("unimedida"), unimedida);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getResultList();
	}
	
	public void borrarPorUnimedida(Unimedida unimedida) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<ConversionUM> delete = cb.createCriteriaDelete(ConversionUM.class);
		Root<ConversionUM> c = delete.from(ConversionUM.class);
		delete.where(cb.equal(c.get("unimedida"), unimedida));
		Query query = getEntityManager().createQuery(delete);
		query.executeUpdate();
		getEntityManager().getTransaction().commit();
	}
}

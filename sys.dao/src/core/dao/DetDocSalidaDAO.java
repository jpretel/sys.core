package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.DetDocsalida;
import core.entity.Docsalida;

public class DetDocSalidaDAO extends AbstractDAO<DetDocsalida> {
	public DetDocSalidaDAO() {
		super(DetDocsalida.class);
	}

	public List<DetDocsalida> getPorSalida(Docsalida salida) {
		CriteriaQuery<DetDocsalida> q = cb.createQuery(DetDocsalida.class);
		Root<DetDocsalida> c = q.from(DetDocsalida.class);
		Predicate condicion = cb.equal(c.get("docsalida"), salida);
		q.multiselect(c).where(condicion);
		return getEntityManager().createQuery(q).getResultList();
	}

	public void borrarPorSalida(Docsalida salida) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<Docsalida> delete = cb
				.createCriteriaDelete(Docsalida.class);
		Root<Docsalida> c = delete.from(Docsalida.class);
		delete.where(cb.equal(c.get("solicitud"), salida));
		Query query = getEntityManager().createQuery(delete);
		try {
			query.executeUpdate();
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		}
	}
}

package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.DocFormulario;
import core.entity.TipoDocumento;

public class DocFormularioDAO extends AbstractDAO<DocFormulario> {

	public DocFormularioDAO() {
		super(DocFormulario.class);
	}
	
	public List<DocFormulario> getPorDocumento(TipoDocumento documento){
		CriteriaQuery<DocFormulario> q = cb.createQuery(DocFormulario.class);
		Root<DocFormulario> c = q.from(DocFormulario.class);
		Predicate condicion = cb.equal(c.get("documento"), documento);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getResultList();
	}
	
	public DocFormulario getPorFormulario(String formulario){
		CriteriaQuery<DocFormulario> q = cb.createQuery(DocFormulario.class);
		Root<DocFormulario> c = q.from(DocFormulario.class);
		Predicate condicion = cb.equal(c.get("opcion"), formulario);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getSingleResult();
	}
	
	public void borrarPorDocumento (TipoDocumento documento) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<DocFormulario> delete = cb.createCriteriaDelete(DocFormulario.class);
		Root<DocFormulario> c = delete.from(DocFormulario.class);
		delete.where(cb.equal(c.get("documento"), documento));
		Query query = getEntityManager().createQuery(delete);
		query.executeUpdate();
		getEntityManager().getTransaction().commit();
	}
}

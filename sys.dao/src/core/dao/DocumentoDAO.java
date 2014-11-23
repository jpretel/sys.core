package core.dao;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.Documento;

public class DocumentoDAO extends AbstractDAO<Documento> {

	public DocumentoDAO() {
		super(Documento.class);
	}
	
	public Documento getPorDocumento(String formulario){
		CriteriaQuery<Documento> q = cb.createQuery(Documento.class);
		Root<Documento> c = q.from(Documento.class);
		Predicate condicion = cb.equal(c.get("formulario"), formulario);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getSingleResult();
	}


}

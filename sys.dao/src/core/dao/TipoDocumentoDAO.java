package core.dao;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.TipoDocumento;

public class TipoDocumentoDAO extends AbstractDAO<TipoDocumento> {

	public TipoDocumentoDAO() {
		super(TipoDocumento.class);
	}
	
	public TipoDocumento getPorDocumento(String formulario){
		CriteriaQuery<TipoDocumento> q = cb.createQuery(TipoDocumento.class);
		Root<TipoDocumento> c = q.from(TipoDocumento.class);
		Predicate condicion = cb.equal(c.get("formulario"), formulario);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getSingleResult();
	}


}

package core.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import core.entity.Requerimiento;

public class RequerimientoDAO extends AbstractDAO<Requerimiento> {

	public RequerimientoDAO() {
		super(Requerimiento.class);
	}

	@SuppressWarnings("unchecked")
	public int getPorSerie(String serie) {
		CriteriaQuery<Requerimiento> q = cb.createQuery(Requerimiento.class);
		Root c = q.from(Requerimiento.class);
		Predicate condicion = cb.equal(c.get("serie"), serie);
		q.select((Selection<? extends Requerimiento>) cb.max(c.get("numero"))).where(condicion);

		int Numero = 0;
		if (getEntityManager().createQuery(q).getSingleResult() instanceof Object)
			Numero = Integer.parseInt(((Object) getEntityManager().createQuery(
					q).getSingleResult()).toString());
		return Numero;
	}

	public List<Requerimiento> getFiltro(int idesde, int ihasta, String serie,
			int numero) {

		CriteriaQuery<Requerimiento> q = cb.createQuery(Requerimiento.class);
		Root<Requerimiento> c = q.from(Requerimiento.class);

		Expression<Integer> expfecha = c.get("fecha");

		Predicate ps = null;

		if (serie.trim().length() > 0)
			ps = cb.equal(c.get("serie"), serie);

		if (numero != 0)
			if (ps == null)
				ps = cb.equal(c.get("numero"), numero);
			else
				ps = cb.and(ps, cb.equal(c.get("numero"), numero));

		if (idesde != 0)
			if (ps == null) {
				ps = cb.greaterThanOrEqualTo(expfecha, idesde);
			} else {
				ps = cb.and(ps, cb.greaterThanOrEqualTo(expfecha, idesde));
			}

		if (ihasta != 0)
			if (ps == null) {
				ps = cb.lessThanOrEqualTo(expfecha, ihasta);
			} else {
				ps = cb.and(ps, cb.lessThanOrEqualTo(expfecha, ihasta));
			}

		if (ps != null) {
			q.select(c).where(ps);
		} else
			q.select(c);

		return getEntityManager().createQuery(q).getResultList();
	}

	public Requerimiento getPorSerieNumero(String serie, int numero) {
		CriteriaQuery<Requerimiento> q = cb.createQuery(Requerimiento.class);
		Root<Requerimiento> c = q.from(Requerimiento.class);
		Predicate condicion = cb.and(cb.equal(c.get("serie"), serie),
				cb.equal(c.get("numero"), numero));
		q.select(c).where(condicion);
		try {
			return getEntityManager().createQuery(q).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}

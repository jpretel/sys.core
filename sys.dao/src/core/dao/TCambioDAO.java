package core.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.Moneda;
import core.entity.TCambio;

public class TCambioDAO extends AbstractDAO<TCambio> {

	public TCambioDAO() {
		super(TCambio.class);
	}

	public TCambio getFechaMoneda(int anio, int mes, int dia, Moneda moneda) {
		CriteriaQuery<TCambio> q = cb.createQuery(TCambio.class);
		Root<TCambio> c = q.from(TCambio.class);
		Predicate condicion = cb.and(cb.equal(c.get("anio"), anio),
				cb.equal(c.get("mes"), mes), cb.equal(c.get("dia"), dia),
				cb.equal(c.get("moneda"), moneda));
		q.select(c).where(condicion);
		try {
			return getEntityManager().createQuery(q).getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}

	public List<TCambio> getMesMoneda(Moneda moneda, int anio, int mes) {
		CriteriaQuery<TCambio> q = cb.createQuery(TCambio.class);
		Root<TCambio> c = q.from(TCambio.class);
		Predicate condicion = cb.and(cb.equal(c.get("moneda"), moneda),
				cb.equal(c.get("id").get("anio"), anio),
				cb.equal(c.get("id").get("mes"), mes));
		q.select(c)
				.where(condicion)
				.orderBy(cb.asc(c.get("id").get("anio")),
						cb.asc(c.get("id").get("mes")),
						cb.asc(c.get("id").get("dia")));
		return getEntityManager().createQuery(q).getResultList();
	}
}
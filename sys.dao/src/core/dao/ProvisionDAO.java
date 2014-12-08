package core.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.Clieprov;
import core.entity.TipoDocumento;
import core.entity.Provision;
import core.entity.Provision;

public class ProvisionDAO extends AbstractDAO<Provision> {

	public ProvisionDAO() {
		super(Provision.class);
	}

	public boolean existeProvision(Clieprov proveedor, TipoDocumento documento,
			String serie, int numero, long idprovision) {
		CriteriaQuery<Provision> q = cb.createQuery(Provision.class);
		Root<Provision> from = q.from(Provision.class);

		Predicate where = cb.and(cb.equal(from.get("clieprov"), proveedor),
				cb.equal(from.get("documento"), documento),
				cb.equal(from.get("serie"), serie),
				cb.equal(from.get("numero"), numero),
				cb.notEqual(from.get("idprovision"), idprovision));
		q.select(from).where(where);

		Provision p = null;
		try {
			p = getEntityManager().createQuery(q).getSingleResult();
		} catch (Exception e) {
		}
		return (p != null);
	}

	public List<Provision> getFiltro(int idesde, int ihasta, String serie,
			int numero) {

		CriteriaQuery<Provision> q = cb.createQuery(Provision.class);
		Root<Provision> c = q.from(Provision.class);

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
}

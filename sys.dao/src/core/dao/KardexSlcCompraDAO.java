package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.KardexSlcCompra;
import core.entity.OrdenCompra;

public class KardexSlcCompraDAO extends AbstractDAO<KardexSlcCompra> {

	public KardexSlcCompraDAO() {
		super(KardexSlcCompra.class);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Tuple> getSaldoPorOrigen(long id_origen,
			OrdenCompra ordenCompra) {

		CriteriaQuery<Tuple> q = cb.createTupleQuery();
		Root from = q.from(KardexSlcCompra.class);

		// Join p = from.join("dordencompra", JoinType.LEFT);

		Predicate condicion = cb.and(
				cb.equal(from.get("id_origen"), id_origen),
				cb.and(cb.notEqual(from.get("id_referencia"),
						ordenCompra.getIdordencompra())));

		// q.multiselect(from,
		// p.get("id").get("idordencompra").alias("idordencompra"));

		q.multiselect(
				from.get("producto").alias("producto"),
				from.get("unimedida").alias("unimedida"),
				cb.sum(cb.prod(from.get("factor"), from.get("cantidad")))
						.alias("cantidad")).where(condicion);
		q.groupBy(from.get("producto"), from.get("unimedida"));
		q.having(cb.greaterThan(
				cb.sum(cb.prod(from.get("factor"), from.get("cantidad"))), 0));

		return em.createQuery(q).getResultList();
	}

	public void borrarPorIdOrigen(long idorigen) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<KardexSlcCompra> delete = cb
				.createCriteriaDelete(KardexSlcCompra.class);
		Root<KardexSlcCompra> c = delete.from(KardexSlcCompra.class);
		delete.where(cb.equal(c.get("id_origen"), idorigen));
		Query query = getEntityManager().createQuery(delete);
		query.executeUpdate();
		getEntityManager().getTransaction().commit();
	}

	public void borrarPorIdOrdenCompra(long idordencompra) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<KardexSlcCompra> delete = cb
				.createCriteriaDelete(KardexSlcCompra.class);
		Root<KardexSlcCompra> c = delete.from(KardexSlcCompra.class);
		delete.where(cb.and(cb.equal(c.get("id_referencia"), idordencompra),
				cb.equal(c.get("tipo_referencia"), "ORD_COMPRA")));
		Query query = getEntityManager().createQuery(delete);
		query.executeUpdate();
		getEntityManager().getTransaction().commit();
	}

}

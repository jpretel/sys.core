package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.Producto;
import core.entity.ProductoImpuesto;

public class ProductoImpuestoDAO extends AbstractDAO<ProductoImpuesto> {

	public ProductoImpuestoDAO() {
		super(ProductoImpuesto.class);
	}

	public List<ProductoImpuesto> getPorProducto(Producto producto) {
		CriteriaQuery<ProductoImpuesto> q = cb
				.createQuery(ProductoImpuesto.class);
		Root<ProductoImpuesto> c = q.from(ProductoImpuesto.class);
		Predicate condicion = cb.equal(c.get("producto"), producto);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getResultList();
	}
	
	
	
	public void borrarPorProducto(Producto producto) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<ProductoImpuesto> delete = cb.createCriteriaDelete(ProductoImpuesto.class);
		Root<ProductoImpuesto> c = delete.from(ProductoImpuesto.class);
		delete.where(cb.equal(c.get("producto"), producto));
		Query query = getEntityManager().createQuery(delete);
		query.executeUpdate();
		getEntityManager().getTransaction().commit();
	}
}

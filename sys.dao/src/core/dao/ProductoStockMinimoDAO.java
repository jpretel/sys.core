package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.Producto;
import core.entity.ProductoStockMinimo;

public class ProductoStockMinimoDAO extends AbstractDAO<ProductoStockMinimo> {

	public ProductoStockMinimoDAO() {
		super(ProductoStockMinimo.class);
	}
	
	public List<ProductoStockMinimo> getPorProducto(Producto producto) {
		CriteriaQuery<ProductoStockMinimo> q = cb
				.createQuery(ProductoStockMinimo.class);
		Root<ProductoStockMinimo> c = q.from(ProductoStockMinimo.class);
		Predicate condicion = cb.equal(c.get("producto"), producto);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getResultList();
	}
	
	public void borrarPorProducto (Producto producto) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<ProductoStockMinimo> delete = cb.createCriteriaDelete(ProductoStockMinimo.class);
		Root<ProductoStockMinimo> c = delete.from(ProductoStockMinimo.class);
		delete.where(cb.equal(c.get("producto"), producto));
		Query query = getEntityManager().createQuery(delete);
		query.executeUpdate();
		getEntityManager().getTransaction().commit();
	}	
}

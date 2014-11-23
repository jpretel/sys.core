package core.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import core.entity.Almacen;
import core.entity.PrivUsuarioAlmacen;
import core.entity.Sucursal;
import core.entity.Usuario;

public class PrivUsuarioAlmacenDAO extends AbstractDAO<PrivUsuarioAlmacen> {

	private SucursalDAO sucursalDAO = new SucursalDAO();
	private AlmacenDAO almacenDAO = new AlmacenDAO();

	public PrivUsuarioAlmacenDAO() {
		super(PrivUsuarioAlmacen.class);
	}

	public List<PrivUsuarioAlmacen> getPorUsuario(Usuario usuario) {
		CriteriaQuery<PrivUsuarioAlmacen> q = cb
				.createQuery(PrivUsuarioAlmacen.class);
		Root<PrivUsuarioAlmacen> c = q.from(PrivUsuarioAlmacen.class);
		Predicate condicion = cb.equal(c.get("usuario"), usuario);
		q.select(c).where(condicion);
		return getEntityManager().createQuery(q).getResultList();
	}

	public void borrarPorUsuario(Usuario usuario) {
		getEntityManager().getTransaction().begin();
		CriteriaDelete<PrivUsuarioAlmacen> delete = cb
				.createCriteriaDelete(PrivUsuarioAlmacen.class);
		Root<PrivUsuarioAlmacen> c = delete.from(PrivUsuarioAlmacen.class);
		delete.where(cb.equal(c.get("usuario"), usuario));
		Query query = getEntityManager().createQuery(delete);
		query.executeUpdate();
		getEntityManager().getTransaction().commit();
	}

	public List<Sucursal> getSucursalPorUsuario(Usuario usuario) {
		if (usuario.getGrupoUsuario().getEsAdministrador() == 0) {
			CriteriaQuery<Sucursal> q = cb.createQuery(Sucursal.class);
			Root<PrivUsuarioAlmacen> from = q.from(PrivUsuarioAlmacen.class);
			Predicate condicion = cb.equal(from.get("usuario"), usuario);

			Join sucursal = from.join("sucursal", JoinType.INNER);

			q.select(sucursal).where(condicion);
			return getEntityManager().createQuery(q).getResultList();
		} else {
			return sucursalDAO.findAll();
		}
	}

	public List<Almacen> getAlmacenPorUsuario(Usuario usuario, Sucursal sucursal) {
		if (usuario.getGrupoUsuario().getEsAdministrador() == 0) {
			CriteriaQuery<Almacen> q = cb.createQuery(Almacen.class);
			Root<PrivUsuarioAlmacen> from = q.from(PrivUsuarioAlmacen.class);
			Predicate condicion = cb.and(
					cb.equal(from.get("usuario"), usuario),
					cb.equal(from.get("sucursal"), sucursal));

			Join almacen = from.join("almacen", JoinType.INNER);

			q.select(almacen).where(condicion);
			return getEntityManager().createQuery(q).getResultList();
		} else {
			return almacenDAO.getPorSucursal(sucursal);
		}
	}
}

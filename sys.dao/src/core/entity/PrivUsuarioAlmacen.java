package core.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PrivUsuarioAlmacen
 *
 */
@Entity
@Table(name = "priv_usuario_almacen")
public class PrivUsuarioAlmacen implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idprivusuarioalmacen;

	private static final long serialVersionUID = 1L;

	public PrivUsuarioAlmacen() {
		super();
	}

	@ManyToOne
	@JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal")
	private Sucursal sucursal;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal", insertable = false, updatable = false),
			@JoinColumn(name = "idalmacen", referencedColumnName = "idalmacen") })
	private Almacen almacen;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public long getIdprivusuarioalmacen() {
		return idprivusuarioalmacen;
	}

	public void setIdprivusuarioalmacen(long idprivusuarioalmacen) {
		this.idprivusuarioalmacen = idprivusuarioalmacen;
	}

}

package core.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProductoImpuesto
 *
 */
@Entity
@Table(name = "producto_impuesto")
public class ProductoImpuesto implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long idproducto_impuesto;
	@ManyToOne
	@JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
	private Producto producto;
	@ManyToOne
	@JoinColumn(name = "idimpuesto", referencedColumnName = "idimpuesto")
	private Impuesto impuesto;

	private static final long serialVersionUID = 1L;

	public ProductoImpuesto() {
		super();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Impuesto getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
	}

	public long getIdproducto_impuesto() {
		return idproducto_impuesto;
	}

	public void setIdproducto_impuesto(long idproducto_impuesto) {
		this.idproducto_impuesto = idproducto_impuesto;
	}
}

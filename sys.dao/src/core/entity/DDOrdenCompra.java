package core.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: DDOrdenCompra
 *
 */
@Entity
@Table(name = "ddordencompra")
public class DDOrdenCompra implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long iddordencompra;
	
	@ManyToOne
	@JoinColumn(name="idordencompra", referencedColumnName ="idordencompra")
	private OrdenCompra ordencompra;
	
	@ManyToOne
	@JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
	private Producto producto;
	
	private long id_referencia;
	
	@Column(precision = 17, scale = 6)
	private float cantidad;
	
	@Column(length = 10)
	private String tipo_referencia;

	private static final long serialVersionUID = 1L;

	public DDOrdenCompra() {
		super();
	}

	public long getId_referencia() {
		return this.id_referencia;
	}

	public void setId_referencia(long id_referencia) {
		this.id_referencia = id_referencia;
	}

	public float getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo_referencia() {
		return this.tipo_referencia;
	}

	public void setTipo_referencia(String tipo_referencia) {
		this.tipo_referencia = tipo_referencia;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return super.toString();
	}

	public long getIddordencompra() {
		return iddordencompra;
	}

	public void setIddordencompra(long iddordencompra) {
		this.iddordencompra = iddordencompra;
	}

	public OrdenCompra getOrdencompra() {
		return ordencompra;
	}

	public void setOrdencompra(OrdenCompra ordencompra) {
		this.ordencompra = ordencompra;
	}
}

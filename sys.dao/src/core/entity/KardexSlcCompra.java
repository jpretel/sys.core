package core.entity;

import java.io.Serializable;

import javax.persistence.*;

import core.entity.Producto;
import core.entity.Unimedida;

/**
 * Entity implementation class for Entity: KardexSlcCompra
 *
 */
@Entity
@Table(name = "kardex_slc_compra")
public class KardexSlcCompra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 10)
	private String tipo_origen;
	
	private long id_origen;

	@Column(length = 10)
	private String tipo_referencia;
	private long id_referencia;

	@ManyToOne
	@JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "idunimedida", referencedColumnName = "idunimedida")
	private Unimedida unimedida;

	private int factor;

	@Column(precision = 17, scale = 6)
	private float cantidad;

	public KardexSlcCompra() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Unimedida getUnimedida() {
		return this.unimedida;
	}

	public void setUnimedida(Unimedida unimedida) {
		this.unimedida = unimedida;
	}

	public int getFactor() {
		return this.factor;
	}

	public void setFactor(int factor) {
		this.factor = factor;
	}

	public float getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public long getId_referencia() {
		return id_referencia;
	}

	public void setId_referencia(long id_referencia) {
		this.id_referencia = id_referencia;
	}

	public String getTipo_referencia() {
		return tipo_referencia;
	}

	public void setTipo_referencia(String tipo_referencia) {
		this.tipo_referencia = tipo_referencia;
	}

	public long getId_origen() {
		return id_origen;
	}

	public void setId_origen(long id_origen) {
		this.id_origen = id_origen;
	}

	public String getTipo_origen() {
		return tipo_origen;
	}

	public void setTipo_origen(String tipo_origen) {
		this.tipo_origen = tipo_origen;
	}

}

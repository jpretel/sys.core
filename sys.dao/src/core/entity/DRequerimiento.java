package core.entity;

import java.io.Serializable;

import javax.persistence.*;

import core.entity.Producto;
import core.entity.Unimedida;

/**
 * Entity implementation class for Entity: DRequerimiento
 *
 */
@Entity
@Table(name = "drequerimiento")
public class DRequerimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long iddrequerimiento;

	@ManyToOne
	@JoinColumn(name = "idrequerimiento", referencedColumnName = "idrequerimiento")
	private Requerimiento requerimiento;

	@ManyToOne
	@JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "idunimedida", referencedColumnName = "idunimedida")
	private Unimedida unimedida;

	@Column(precision = 17, scale = 6)
	private float cantidad;

	@ManyToOne
	@JoinColumn(name = "idconsumidor", referencedColumnName = "idconsumidor")
	private Consumidor consumidor;

	public DRequerimiento() {
		super();
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

	public float getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	public long getIddrequerimiento() {
		return iddrequerimiento;
	}

	public void setIddrequerimiento(long iddrequerimiento) {
		this.iddrequerimiento = iddrequerimiento;
	}

}

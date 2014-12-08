package core.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: DOrdenCompra
 *
 */
@Entity
public class DProvision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long iddprovision;

	@ManyToOne
	@JoinColumn(name = "idprovision", referencedColumnName = "idprovision")
	private Provision provision;
	
	@ManyToOne
	@JoinColumn(name = "idcuenta", referencedColumnName = "idcuenta")
	private Cuenta cuenta;
	
	@ManyToOne
	@JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "idunimedida", referencedColumnName = "idunimedida")
	private Unimedida unimedida;

	@Column(precision = 17, scale = 3)
	private float cantidad;

	@Column(precision = 17, scale = 2)
	private float precio;

	@Column(precision = 17, scale = 2)
	private float importe;

	public DProvision() {
		super();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Unimedida getUnimedida() {
		return unimedida;
	}

	public void setUnimedida(Unimedida unimedida) {
		this.unimedida = unimedida;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public long getIddprovision() {
		return iddprovision;
	}

	public void setIddprovision(long iddprovision) {
		this.iddprovision = iddprovision;
	}

	public Provision getProvision() {
		return provision;
	}

	public void setProvision(Provision provision) {
		this.provision = provision;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
}

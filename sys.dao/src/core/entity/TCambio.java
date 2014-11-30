package core.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TCambio
 *
 */
@Entity
public class TCambio implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long idtcambio;
	
	private int dia;
	
	private int mes;
	
	private int anio;
	
	@Column(precision = 17, scale = 6)
	private float compra;
	@Column(precision = 17, scale = 6)
	private float venta;

	@ManyToOne
	@JoinColumn(name = "idmoneda", referencedColumnName = "idmoneda")
	private Moneda moneda;

	private static final long serialVersionUID = 1L;

	public TCambio() {
		super();
	}

	public float getCompra() {
		return compra;
	}

	public void setCompra(float compra) {
		this.compra = compra;
	}

	public float getVenta() {
		return venta;
	}

	public void setVenta(float venta) {
		this.venta = venta;
	}

	public long getIdtcambio() {
		return idtcambio;
	}

	public void setIdtcambio(long idtcambio) {
		this.idtcambio = idtcambio;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

}

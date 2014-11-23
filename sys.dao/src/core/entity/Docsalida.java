package core.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "docsalida")
@NamedQuery(name = "Docsalida.findAll", query = "SELECT d FROM Docsalida d")
public class Docsalida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false)
	private long iddocsalida;

	@ManyToOne
	@JoinColumn(name = "idgcentralizacion", referencedColumnName = "idgcentralizacion", nullable = false)
	private GrupoCentralizacion grupoCentralizacion;

	@ManyToOne
	@JoinColumn(name = "idmoneda", referencedColumnName = "idmoneda", nullable = false)
	private Moneda moneda;

	@ManyToOne
	@JoinColumn(name = "idconcepto", referencedColumnName = "idconcepto", nullable = false)
	private Concepto concepto;

	@ManyToOne
	@JoinColumn(name = "idresponsable", referencedColumnName = "idresponsable", nullable = false)
	private Responsable responsable;

	@ManyToOne
	@JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal", nullable = false)
	private Sucursal sucursal;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal", insertable = false, updatable = false, nullable = false),
			@JoinColumn(name = "idalmacen", referencedColumnName = "idalmacen", nullable = false) })
	private Almacen almacen;

	@JoinColumn(name = "idsucursal_dest", referencedColumnName = "idsucursal", nullable = true)
	private Sucursal sucursal_dest;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "idsucursal_dest", referencedColumnName = "idsucursal", insertable = false, updatable = false, nullable = true),
			@JoinColumn(name = "idalmacen_dest", referencedColumnName = "idalmacen", nullable = true) })
	private Almacen almacen_dest;

	@Column(nullable = false, length = 500)
	private String glosa;

	@Column(nullable = false, length = 8)
	private int numero;

	@Column(nullable = false, length = 4)
	private String serie;

	@Column(nullable = false)
	private int dia;

	@Column
	private int fecha;

	@Column(nullable = false, precision = 10, scale = 2)
	private float tcambio;

	@Column(nullable = false, precision = 10, scale = 2)
	private float tcmoneda;

	@Column(length = 500)
	private String direccion;

	@Column(length = 500)
	private String llevadopor;

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	@Column(nullable = false)
	private int mes;

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	@Column(nullable = false)
	private int anio;

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Docsalida() {
	}

	public String getGlosa() {
		return this.glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public float getTcambio() {
		return tcambio;
	}

	public void setTcambio(float tcambio) {
		this.tcambio = tcambio;
	}

	public float getTcmoneda() {
		return tcmoneda;
	}

	public void setTcmoneda(float tcmoneda) {
		this.tcmoneda = tcmoneda;
	}

	public GrupoCentralizacion getGrupoCentralizacion() {
		return grupoCentralizacion;
	}

	public void setGrupoCentralizacion(GrupoCentralizacion grupoCentralizacion) {
		this.grupoCentralizacion = grupoCentralizacion;
	}

	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public long getIddocsalida() {
		return iddocsalida;
	}

	public void setIddocsalida(long iddocsalida) {
		this.iddocsalida = iddocsalida;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Almacen getAlmacen_dest() {
		return almacen_dest;
	}

	public void setAlmacen_dest(Almacen almacen_dest) {
		this.almacen_dest = almacen_dest;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLlevadopor() {
		return llevadopor;
	}

	public void setLlevadopor(String llevadopor) {
		this.llevadopor = llevadopor;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Sucursal getSucursal_dest() {
		return sucursal_dest;
	}

	public void setSucursal_dest(Sucursal sucursal_dest) {
		this.sucursal_dest = sucursal_dest;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

}
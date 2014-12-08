package core.entity;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: OrdenCompra
 *
 */
@Entity
public class Provision implements Serializable {

	@Id
	private Long idprovision;
	
	private TipoDocumento documento;
	
	private int numero;
	@Column(length = 4)
	private String serie;
	
	private int dia;
	private int mes;
	private int anio;
	private int fecha;
	
	@ManyToOne
	@JoinColumn(name = "idmoneda", referencedColumnName = "idmoneda")
	private Moneda moneda;
	@Column(precision = 10, scale = 4)
	private float tcambio;
	@Column(precision = 10, scale = 4)
	private float tcmoneda;
	
	private String glosa;
	
	@ManyToOne
	@JoinColumn(name = "idclieprov", referencedColumnName = "idclieprov")
	private Clieprov clieprov;
	
	private int con_retencion;
	
	private static final long serialVersionUID = 1L;

	public Provision() {
		super();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
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

	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public Clieprov getClieprov() {
		return clieprov;
	}

	public void setClieprov(Clieprov clieprov) {
		this.clieprov = clieprov;
	}

	public Long getIdprovision() {
		return idprovision;
	}

	public void setIdprovision(Long idprovision) {
		this.idprovision = idprovision;
	}

	public TipoDocumento getDocumento() {
		return documento;
	}

	public void setDocumento(TipoDocumento documento) {
		this.documento = documento;
	}

	public int getCon_retencion() {
		return con_retencion;
	}

	public void setCon_retencion(int con_retencion) {
		this.con_retencion = con_retencion;
	}

}

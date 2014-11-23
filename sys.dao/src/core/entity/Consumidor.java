package core.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the consumidor database table.
 * 
 */
@Entity
@NamedQuery(name = "Consumidor.findAll", query = "SELECT c FROM Consumidor c")
public class Consumidor implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false, length=15)
	private String idconsumidor;

	@Column(length=75)
	private String descripcion;

	@Column(length=200)
	private String jerarquia;

	@Column(length=1)
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "idref_consumidor", referencedColumnName="idconsumidor")
	private Consumidor consumidor;

	@OneToMany(mappedBy = "consumidor")
	private List<Consumidor> consumidors;

	public Consumidor() {
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getJerarquia() {
		return this.jerarquia;
	}

	public void setJerarquia(String jerarquia) {
		this.jerarquia = jerarquia;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Consumidor getConsumidor() {
		return this.consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	public List<Consumidor> getConsumidors() {
		return this.consumidors;
	}

	public void setConsumidors(List<Consumidor> consumidors) {
		this.consumidors = consumidors;
	}

	public Consumidor addConsumidor(Consumidor consumidor) {
		getConsumidors().add(consumidor);
		consumidor.setConsumidor(this);

		return consumidor;
	}
	
	public String getIdconsumidor() {
		return idconsumidor;
	}

	public void setIdconsumidor(String idconsumidor) {
		this.idconsumidor = idconsumidor;
	}

	public Consumidor removeConsumidor(Consumidor consumidor) {
		getConsumidors().remove(consumidor);
		consumidor.setConsumidor(null);

		return consumidor;
	}

	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println("No se puede duplicar");
		}
		return obj;
	}

}
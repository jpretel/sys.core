package core.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the responsable database table.
 * 
 */
@Entity
@Table(name="responsable")
@NamedQuery(name="Responsable.findAll", query="SELECT r FROM Responsable r")
public class Responsable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false, length=3)
	private String idresponsable;

	@Column(length=3)
	private String idarea;

	@Column(nullable=false, length=100)
	private String nombre;

	public Responsable() {
	}

	public String getIdresponsable() {
		return this.idresponsable;
	}

	public void setIdresponsable(String idresponsable) {
		this.idresponsable = idresponsable;
	}

	public String getIdarea() {
		return this.idarea;
	}

	public void setIdarea(String idarea) {
		this.idarea = idarea;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String historial(){
        return "C�digo: "+this.idresponsable + " Descripci�n: " + this.nombre + "idArea: "+this.idarea;
     }
}
package core.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the sys_formulario database table.
 * 
 */
@Entity
@Table(name = "sys_formulario")
@NamedQuery(name = "SysFormulario.findAll", query = "SELECT s FROM SysFormulario s")
public class SysFormulario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, length = 50)
	private String idformulario;

	@Column(length = 75)
	private String descripcion;

	@Column(length = 200)
	private String imagen;

	@Column(length = 200)
	private String paquete;

	@Column(length = 100)
	private String clase;

	private int es_lista;

	@Column(length = 200)
	private String paquete_doc;

	@Column(length = 100)
	private String clase_doc;

	public SysFormulario() {
	}

	public String getIdformulario() {
		return this.idformulario;
	}

	public void setIdformulario(String idformulario) {
		this.idformulario = idformulario;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getPaquete() {
		return paquete;
	}

	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public int getEs_lista() {
		return es_lista;
	}

	public void setEs_lista(int es_lista) {
		this.es_lista = es_lista;
	}

	public String getPaquete_doc() {
		return paquete_doc;
	}

	public void setPaquete_doc(String paquete_doc) {
		this.paquete_doc = paquete_doc;
	}

	public String getClase_doc() {
		return clase_doc;
	}

	public void setClase_doc(String clase_doc) {
		this.clase_doc = clase_doc;
	}

	public String getOpcion() {
		try {
			return getPaquete().concat(".").concat(getClase());
		} catch (Exception e) {
			return "";
		}
	}

}
package core.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the documento database table.
 * 
 */
@Entity
public class TipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false, length=4)
	private String idtipodocumento;

	@Column(name="nomenclatura", length=50)
	private String nomenclatura;
	
	@Column(name="cod_sunat", length=4)
	private String codSunat;

	@Column(name="descripcion", length=200)
	private String descripcion;

	public TipoDocumento() {
	}

	public String getCodSunat() {
		return this.codSunat;
	}

	public void setCodSunat(String codSunat) {
		this.codSunat = codSunat;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}
}
package core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the log database table.
 * 
 */
@Entity
@Table(name="log")
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false)
	private int idlog;

	@Column(nullable=false)
	private Timestamp date;

	@Lob
	@Column(nullable=false)
	private String log;

	@Column(name="nom_formulario", nullable=false, length=255)
	private String nomFormulario;

	@Column(nullable=false, length=255)
	private String tipo;

	@Column(nullable=false, length=255)
	private String usuario;

	public Log() {
	}

	public int getIdlog() {
		return this.idlog;
	}

	public void setIdlog(int idlog) {
		this.idlog = idlog;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getLog() {
		return this.log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getNomFormulario() {
		return this.nomFormulario;
	}

	public void setNomFormulario(String nomFormulario) {
		this.nomFormulario = nomFormulario;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
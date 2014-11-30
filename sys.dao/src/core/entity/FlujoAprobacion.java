package core.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SysFormularioAprobacion
 *
 */
@Entity
public class FlujoAprobacion implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long idflujoaprobacion;
	
	private int orden;
	
	@ManyToOne
	@JoinColumn(name = "idflujo", referencedColumnName = "idflujo")
	private Flujo flujo;

	@ManyToOne
	@JoinColumn(name = "idformulario", referencedColumnName = "idformulario")
	private SysFormulario sysFormulario;
	private static final long serialVersionUID = 1L;

	public FlujoAprobacion() {
		super();
	}
	
	public Flujo getFlujo() {
		return flujo;
	}

	public void setFlujo(Flujo flujo) {
		this.flujo = flujo;
	}

	public SysFormulario getSysFormulario() {
		return sysFormulario;
	}

	public void setSysFormulario(SysFormulario sysFormulario) {
		this.sysFormulario = sysFormulario;
	}

	public long getIdflujoaprobacion() {
		return idflujoaprobacion;
	}

	public void setIdflujoaprobacion(long idflujoaprobacion) {
		this.idflujoaprobacion = idflujoaprobacion;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}
}

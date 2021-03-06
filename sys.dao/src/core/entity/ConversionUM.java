package core.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConversionUM
 *
 */
@Entity
@Table(name = "conversion_um")
public class ConversionUM implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idconvercion_um;
	
	@Column(precision = 1, scale = 0)
	private float factor;
	@ManyToOne
	@JoinColumn(name = "idunimedida", referencedColumnName = "idunimedida", insertable = false, updatable = false, nullable = false)
	private Unimedida unimedida;
	@ManyToOne
	@JoinColumn(name = "idunimedida_equiv", referencedColumnName = "idunimedida", insertable = false, updatable = false, nullable = false)
	private Unimedida unimedida_equiv;
	private static final long serialVersionUID = 1L;

	public ConversionUM() {
		super();
	}

	public float getFactor() {
		return this.factor;
	}

	public void setFactor(float factor) {
		this.factor = factor;
	}

	public Unimedida getUnimedida() {
		return unimedida;
	}

	public void setUnimedida(Unimedida unimedida) {
		this.unimedida = unimedida;
	}

	public Unimedida getUnimedida_equiv() {
		return unimedida_equiv;
	}

	public void setUnimedida_equiv(Unimedida unimedida_equiv) {
		this.unimedida_equiv = unimedida_equiv;
	}

	public long getIdconvercion_um() {
		return idconvercion_um;
	}

	public void setIdconvercion_um(long idconvercion_um) {
		this.idconvercion_um = idconvercion_um;
	}

}

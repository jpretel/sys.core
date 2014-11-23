package core.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the unimedida database table.
 * 
 */
@Entity
@NamedQuery(name="Unimedida.findAll", query="SELECT u FROM Unimedida u")
public class Unimedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false, length=3)
	private String idunimedida;

	@Column(nullable=false, length=75)
	private String descripcion;

	@Column(nullable=false, length=20)
	private String nomenclatura;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="unimedida")
	private List<Producto> productos;

	public Unimedida() {
	}

	public String getIdunimedida() {
		return this.idunimedida;
	}

	public void setIdunimedida(String idunimedida) {
		this.idunimedida = idunimedida;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNomenclatura() {
		return this.nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setUnimedida(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setUnimedida(null);

		return producto;
	}

	public String historial(){
        return "Codigo: "+this.idunimedida + " Descripcion: " + this.descripcion + " Nomenclaruta: " + this.nomenclatura;
    }
}
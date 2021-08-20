package Main.dto;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="hoteles")
public class Hotel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="categoria")
	private int categoria;
	@Column(name="ubi_lat")
	private double ubi_lat;
	@Column(name="ubi_long")
	private double ubi_long;
	@Column(name="precio_noche")
	private float precio_noche;
	@Column(name="valoracion")
	private String valoracion;
	@Column(name="imagen")
	private String imagen;
	@Column(name="telefono")
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name="id_poblacion")
	private Poblacion poblacion;
	
	public Hotel() {
		
	}
	public Hotel(int id, String nombre, int categoria, double ubi_lat, double ubi_long, float precio_noche, String valoracion, String imagen, String telefono, Poblacion poblacion) {
		
		
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.ubi_lat = ubi_lat;
		this.ubi_long = ubi_long;
		this.precio_noche = precio_noche;
		this.valoracion = valoracion;
		this.imagen = imagen;
		this.telefono = telefono;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public double getUbi_lat() {
		return ubi_lat;
	}
	public void setUbi_lat(double ubi_lat) {
		this.ubi_lat = ubi_lat;
	}
	public double getUbi_long() {
		return ubi_long;
	}
	public void setUbi_long(double ubi_long) {
		this.ubi_long = ubi_long;
	}
	public float getPrecio_noche() {
		return precio_noche;
	}
	public void setPrecio_noche(float precio_noche) {
		this.precio_noche = precio_noche;
	}
	public String getValoracion() {
		return valoracion;
	}
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Poblacion getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(Poblacion poblacion) {
		this.poblacion = poblacion;
	}
	
}

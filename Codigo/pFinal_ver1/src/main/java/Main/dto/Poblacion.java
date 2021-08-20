package Main.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="poblaciones")
public class Poblacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	@Column(name="ubi_lat")
	private double ubi_lat;
	@Column(name="ubi_long")
	private double ubi_long;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Hotel> hotel;
	
	public Poblacion() {
		
	}
	public Poblacion(int id, String nombre, double ubi_lat, double ubi_long) {
		
		this.id = id;
		this.nombre = nombre;
		this.ubi_lat = ubi_lat;
		this.ubi_long = ubi_long;
		
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
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Hotel")
	public List<Hotel> getHotel() {
		return hotel;
	}
	public void setSala(List<Hotel> hotel) {
		this.hotel = hotel;
	}

}

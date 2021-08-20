package main.service;

import java.util.List;
import main.dto.Poblacion;
import main.dto.Hotel;

/*
 * 	@autor Diego Manriquez Canales
 * 	@version 0.1
 * 
 */

public interface IPoblacionService {

	public List<Poblacion> listar_poblaciones();
	
	public Poblacion buscar_id(int id);
	
	public Poblacion insertar_poblacion(Poblacion poblacion);
	
	public Poblacion actualizar_poblacion(Poblacion poblacion);
	
	public String eliminar_poblacion(int id);
	
	// Metodo para buscar por nombre
	public Poblacion findByName(String nombre);
	
	// Metodo para buscar los hoteles de una poblacion
	public List<Hotel> findHotelsByLocation(String nombre);
	
}

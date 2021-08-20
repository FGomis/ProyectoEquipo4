package main.controller;

import main.dto.Hotel;
import main.service.HotelServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 	@autor Diego Manriquez Canales
 * 	@version 0.1
 * 
 */

@RestController
@RequestMapping("/api")
public class HotelController {
	
	@Autowired
	HotelServiceImpl hotelServ;
	
	@GetMapping("/hoteles")
	public List<Hotel> listar_hoteles(){
		return hotelServ.listar_hoteles();
	}
	
	@GetMapping("/hoteles/{id_hotel}")
	public Hotel buscar_por_id(@PathVariable(name="id_hotel") int id) {
		return hotelServ.buscar_id(id);
	}
	
	@GetMapping("/hoteles/nombre/{nombre}")
	public List<Hotel> buscar_por_nombre(@PathVariable(name="nombre") String nombre){
		return hotelServ.findByName(nombre);
	}
	
	@PostMapping("/hoteles")
	public Hotel insertar_hotel(@RequestBody Hotel hotel) {
		return hotelServ.insertar_hotel(hotel);
	}
	
	@PutMapping("/hoteles/{id_hotel}")
	public Hotel actualizar_hotel(@PathVariable(name="id_hotel") int id, @RequestBody Hotel hotel) {
		Hotel hot = hotelServ.buscar_id(id);
		hot.setNombre(hotel.getNombre());
		hot.setCategoria(hotel.getCategoria());
		hot.setImagen(hotel.getImagen());
		hot.setPrecio_noche(hotel.getPrecio_noche());
		hot.setTelefono(hotel.getTelefono());
		hot.setValoracion(hotel.getValoracion());
		hot.setUbi_lat(hotel.getUbi_lat());
		hot.setUbi_long(hotel.getUbi_long());
		hot.setPoblacion(hotel.getPoblacion());
		return hotelServ.actualizar_hotel(hot);
	}
	
	@DeleteMapping("/hoteles/{id_hotel}")
	public String eliminar_hotel(@PathVariable(name="id_hotel") int id) {
		return hotelServ.eliminar_hotel(id);
	}

}

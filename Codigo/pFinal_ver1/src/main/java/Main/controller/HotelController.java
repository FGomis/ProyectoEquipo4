package Main.controller;

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

import Main.dto.Hotel;
import Main.service.HotelServiceImpl;

@RestController
@RequestMapping("/api")
public class HotelController {
	
	
	@Autowired
	HotelServiceImpl hotelServiceImpl;
	
	@GetMapping("/hoteles")
	public List<Hotel> listarHotel(){
		return hotelServiceImpl.listarHotel();
	}
	
	@PostMapping("/hoteles")
	public Hotel salvarHotel(@RequestBody Hotel hotel) {
		
		return hotelServiceImpl.guardarHotel(hotel);
	}
	
	@GetMapping("/hoteles/{id}")
	public Hotel hotelXID(@PathVariable(name="id") int id) {
		
		Hotel hotelid= new Hotel();
		
		hotelid=hotelServiceImpl.hotelXID(id);
		
		System.out.println("Hotel XID: "+hotelid);
		
		return hotelid;
	}
	
	@PutMapping("/hoteles/{id}")
	public Hotel actualizarSala(@PathVariable(name="id")int id,@RequestBody Hotel hotel) {
		
		Hotel hotelSeleccionado= new Hotel();
		Hotel hotelActualizado= new Hotel();
		
		hotelSeleccionado= hotelServiceImpl.hotelXID(id);
		
		hotelSeleccionado.setNombre(hotel.getNombre());
		hotelSeleccionado.setCategoria(hotel.getCategoria());
		hotelSeleccionado.setUbi_lat(hotel.getUbi_lat());
		hotelSeleccionado.setUbi_long(hotel.getUbi_long());
		hotelSeleccionado.setPrecio_noche(hotel.getPrecio_noche());
		hotelSeleccionado.setValoracion(hotel.getValoracion());
		hotelSeleccionado.setImagen(hotel.getImagen());
		hotelSeleccionado.setTelefono(hotel.getTelefono());
		hotelSeleccionado.setPoblacion(hotel.getPoblacion());
		
		hotelActualizado = hotelServiceImpl.actualizarHotel(hotelSeleccionado);
		
		System.out.println("El video actualizado es: "+ hotelActualizado);
		
		return hotelActualizado;
	}
	
	@DeleteMapping("/salas/{id}")
	public void eliminarSala(@PathVariable(name="id")int id) {
		hotelServiceImpl.eliminarHotel(id);
	}
}

package Main.service;

import java.util.List;

import Main.dto.Hotel;


public interface HotelService {

	
	public List<Hotel> listarHotel(); //Listar All 
	
	public Hotel guardarHotel(Hotel hotel);	//
	
	public Hotel hotelXID(int id); //
	
	public Hotel actualizarHotel(Hotel hotel); //
	
	public void eliminarHotel(int id);//
}

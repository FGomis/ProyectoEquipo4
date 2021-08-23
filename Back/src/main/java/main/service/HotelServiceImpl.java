package main.service;

import main.dto.Hotel;
import main.dao.IHotelDao;
import main.dao.IPoblacionDao;
import main.dto.Poblacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 	@autor Diego Manriquez Canales
 * 	@version 0.1
 * 
 */

@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	IHotelDao hotelDao;
	
	@Autowired
	IPoblacionDao ipobDao;
	
	@Override
	public List<Hotel> listar_hoteles(){
		return hotelDao.findAll();
	}
	
	@Override
	public Hotel buscar_id(int id){
		return hotelDao.findById(id).get();
	}
	
	@Override
	public Hotel insertar_hotel(Hotel hotel, int id_pob) {
		Poblacion pob = ipobDao.findById(id_pob).get();
		hotel.setPoblacion(pob);
		return hotelDao.save(hotel);
	}

	@Override
	public Hotel actualizar_hotel(Hotel hotel, int id_pob) {
		Poblacion pob = ipobDao.findById(id_pob).get();
		hotel.setPoblacion(pob);
		return hotelDao.save(hotel);
	}
	
	@Override
	public String eliminar_hotel(int id) {
		hotelDao.deleteById(id);
		return "Eliminado el registro con ID: "+id;
	}
	
	public List<Hotel> findByName(String nombre){
		List<Hotel> lista = hotelDao.findAll();
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getNombre().toLowerCase().equals(nombre.toLowerCase())==false) {
				lista.remove(i);
			}
		}
		return lista;
	}
}

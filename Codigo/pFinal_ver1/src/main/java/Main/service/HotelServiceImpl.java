package Main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main.dao.HotelDAO;
import Main.dto.Hotel;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	HotelDAO hotelDAO;

	@Override
	public List<Hotel> listarHotel() {
		// TODO Auto-generated method stub
		return hotelDAO.findAll();
	}

	@Override
	public Hotel guardarHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelDAO.save(hotel);
	}

	@Override
	public Hotel hotelXID(int id) {
		// TODO Auto-generated method stub
		return hotelDAO.findById(id).get();
	}

	@Override
	public Hotel actualizarHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelDAO.save(hotel);
	}

	@Override
	public void eliminarHotel(int id) {
		// TODO Auto-generated method stub
		hotelDAO.deleteById(id);
	}
	
}

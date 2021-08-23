package main.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.dao.IPoblacionDao;
import main.dto.Hotel;
import main.dto.Poblacion;

/*
 * 	@autor Diego Manriquez Canales
 * 	@version 0.1
 * 
 */

@Service
public class PoblacionServiceImpl implements IPoblacionService {

	@Autowired
	IPoblacionDao pobDao;
	
	@Override
	public List<Poblacion> listar_poblaciones(){
		return pobDao.findAll();
	}
	
	@Override
	public Poblacion buscar_id(int id){
		return pobDao.findById(id).get();
	}
	
	@Override
	public Poblacion insertar_poblacion(Poblacion pob) {
		return pobDao.save(pob);
	}

	@Override
	public Poblacion actualizar_poblacion(Poblacion pob) {
		return pobDao.save(pob);
	}
	
	@Override
	public String eliminar_poblacion(int id) {
		pobDao.deleteById(id);
		return "Eliminado el registro con ID: "+id;
	}
	
	@Override
	public Poblacion findByName(String nombre) {
		List<Poblacion> lista = pobDao.findAll();
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				return lista.get(i);
			}
		}
		return null;
	}
	
	@Override
	public List<Hotel> findHotelsByLocation(String nombre){
		Poblacion pobla = findByName(nombre);
		if(pobla==null) {
			List<Hotel> listita = new ArrayList<Hotel>();
			return listita;
		}
		return pobla.getHoteles();
	}
}

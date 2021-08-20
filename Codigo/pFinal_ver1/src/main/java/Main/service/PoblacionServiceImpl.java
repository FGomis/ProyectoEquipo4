package Main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main.dao.PoblacionDAO;
import Main.dto.Poblacion;

@Service
public class PoblacionServiceImpl implements PoblacionService{

	@Autowired
	PoblacionDAO poblacionDAO;

	@Override
	public List<Poblacion> listarPoblacion() {
		// TODO Auto-generated method stub
		return poblacionDAO.findAll();
	}

	@Override
	public Poblacion guardarPoblacion(Poblacion poblacion) {
		// TODO Auto-generated method stub
		return poblacionDAO.save(poblacion);
	}

	@Override
	public Poblacion poblacionXID(int id) {
		// TODO Auto-generated method stub
		return poblacionDAO.findById(id).get();
	}

	@Override
	public Poblacion actualizarPoblacion(Poblacion poblacion) {
		// TODO Auto-generated method stub
		return poblacionDAO.save(poblacion);
	}

	@Override
	public void eliminarPoblacion(int id) {
		// TODO Auto-generated method stub
		poblacionDAO.deleteById(id);
	}
	
}

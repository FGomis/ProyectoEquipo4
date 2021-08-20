package Main.service;

import java.util.List;

import Main.dto.Poblacion;


public interface PoblacionService {

	public List<Poblacion> listarPoblacion(); //Listar All 
	
	public Poblacion guardarPoblacion(Poblacion poblacion);	//
	
	public Poblacion poblacionXID(int id); //
	
	public Poblacion actualizarPoblacion(Poblacion poblacion); //
	
	public void eliminarPoblacion(int id);//
	
}

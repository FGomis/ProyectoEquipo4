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

import Main.dto.Poblacion;
import Main.service.PoblacionServiceImpl;


@RestController
@RequestMapping("/api")
public class PoblacionController {
	
	@Autowired
	PoblacionServiceImpl poblacionServiceImpl;

	@GetMapping("/poblaciones")
	public List<Poblacion> listarPeliculas(){
		
		return poblacionServiceImpl.listarPoblacion();
	}////
	@PostMapping("/poblaciones")
	public Poblacion salvarPoblacion(@RequestBody Poblacion poblacion) {
		
		return poblacionServiceImpl.guardarPoblacion(poblacion);
	}
	
	@GetMapping("/poblaciones/{id}")
	public Poblacion poblacionXID(@PathVariable(name="id") int id) {
		
		Poblacion poblacionid= new Poblacion();
		
		poblacionid=poblacionServiceImpl.poblacionXID(id);
		
		System.out.println("Poblacion XID: "+poblacionid);
		
		return poblacionid;
	}
	
	@PutMapping("/poblaciones/{id}")
	public Poblacion actualizarPoblacion(@PathVariable(name="id")int id,@RequestBody Poblacion poblacion) {
		
		Poblacion poblacionSeleccionada= new Poblacion();
		Poblacion poblacionActualizada= new Poblacion();
		
		poblacionSeleccionada= poblacionServiceImpl.poblacionXID(id);
		
		poblacionSeleccionada.setNombre(poblacion.getNombre());
		poblacionSeleccionada.setUbi_lat(poblacion.getUbi_lat());
		poblacionSeleccionada.setUbi_long(poblacion.getUbi_long());

		
		
		poblacionActualizada = poblacionServiceImpl.actualizarPoblacion(poblacionSeleccionada);
		
		System.out.println("La poblacion actualizada es: "+ poblacionActualizada);
		
		return poblacionActualizada;
	}
	
	@DeleteMapping("/clientes/{id}")
	public void eliminarPelicula(@PathVariable(name="id")int id) {
		poblacionServiceImpl.eliminarPoblacion(id);
	}
}

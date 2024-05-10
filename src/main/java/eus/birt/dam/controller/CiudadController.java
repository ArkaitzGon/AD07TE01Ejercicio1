package eus.birt.dam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import eus.birt.dam.domain.Ciudad;
import eus.birt.dam.repository.CiudadRepository;
import eus.birt.dam.repository.PaisRepository;

//Por si queremos conectarlo a un frontend Angular
@CrossOrigin (origins= {"http://localhost:4200"})
@RestController 
@RequestMapping ("api/ciudades")
public class CiudadController {

	@Autowired
	CiudadRepository ciudadRepository;
	
	@Autowired
	PaisRepository paisRepository;
	
	
	/***
	 * Devuelve una lista de ciudades
	 * **/
	@GetMapping({"/", ""})
	public List<Ciudad> index(){
		return ciudadRepository.findAll();
	}
	
	/***
	 * Añadimos una ciudad
	 * **/
	@PostMapping({"","/"})
	@ResponseStatus (HttpStatus.CREATED)
	public Ciudad crearCiudad(@RequestBody Ciudad ciudad) {
		return ciudadRepository.save(ciudad);
	}
	
	/**
	 * Actualizamos una ciudad
	 * **/
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Ciudad updateCiudad(@RequestBody Ciudad ciudad, @PathVariable("id") int id) {
		Ciudad tempCiudad = ciudadRepository.findById(id).orElse(null);
		
		tempCiudad.setNombre(ciudad.getNombre());
		tempCiudad.setHabitantes(ciudad.getHabitantes());
		tempCiudad.setCodigo_postal(ciudad.getCodigo_postal());
		tempCiudad.setAltitud(ciudad.getAltitud());
		tempCiudad.setPais(ciudad.getPais());
		
		return ciudadRepository.save(tempCiudad);
	}
	
	/***
	 * Borramos una ciudad
	 * **/
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") int id) {
		ciudadRepository.deleteById(id);
	}
}

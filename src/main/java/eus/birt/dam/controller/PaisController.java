package eus.birt.dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Pais;
import eus.birt.dam.repository.PaisRepository;

// Por si queremos conectarlo a un frontend Angular
@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/paises")
public class PaisController {

	@Autowired
	PaisRepository paisRepository;
	
	/***
	 * Imprimimos la lista de paises
	 * **/
	@GetMapping({"/",""})
	public List <Pais> index() {
	return paisRepository.findAll();
	}
	
	
	/***
	 * Creamos un nuevo pais
	 * **/
	@PostMapping({"/",""})
	@ResponseStatus (HttpStatus.CREATED)
	public Pais creaPais(@RequestBody Pais pais) {
		return paisRepository.save(pais);
	}
	
	/***
	 * Actualizamos un pais mediante su id
	 * **/
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Pais update(@RequestBody Pais pais, @PathVariable("id") int id) {
		Pais tempPais = paisRepository.findById(id).orElse(null);
		
		tempPais.setNombre(pais.getNombre());
		tempPais.setIdioma(pais.getIdioma());
		tempPais.setPoblacion(pais.getPoblacion());

		return paisRepository.save(tempPais);
	}
	
	/***
	 * Borramos un team
	 * **/
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") int id) {
		paisRepository.deleteById(id);
	}
}

package eus.birt.dam.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name="pais")
public class Pais implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="idioma")
	private String idioma;
	
	@Column(name="poblacion")
	private int poblacion;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "pais",cascade = CascadeType.ALL)
	//@JoinColumn(name="pais_id")
	List<Ciudad> ciudades = new ArrayList<Ciudad>();
	
	public Pais(String nombre, String idioma, int poblacion) {
		super();
		this.nombre = nombre;
		this.idioma = idioma;
		this.poblacion = poblacion;
	}
}

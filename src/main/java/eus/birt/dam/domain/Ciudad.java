package eus.birt.dam.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="ciudad")
public class Ciudad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="habitantes")
	private int habitantes;
	
	@Column(name="codigo_postal")
	private int codigo_postal;
	
	@Column(name="altitud")
	private int altitud;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="pais_id")
	private Pais pais;
	
	//Añade propiedad teamName a JSON 
	@JsonProperty("nombre_pais")
	public String getNombrePais() {
	    return pais != null ? pais.getNombre() : null;
	}
}

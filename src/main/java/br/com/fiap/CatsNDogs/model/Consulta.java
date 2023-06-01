package br.com.fiap.CatsNDogs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Long animal;
	
	@NotNull
	private Long tutor;
	
	@NotNull
	private Long profissional;
	
	private String data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getAnimal() {
		return animal;
	}

	public void setAnimal(Long animal) {
		this.animal = animal;
	}

	public Long getTutor() {
		return tutor;
	}

	public void setTutor(Long tutor) {
		this.tutor = tutor;
	}

	public Long getProfissional() {
		return profissional;
	}

	public void setProfissional(Long profissional) {
		this.profissional = profissional;
	}

}

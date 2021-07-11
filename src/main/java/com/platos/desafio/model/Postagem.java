package com.platos.desafio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "cervejas")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String estilo;
	
	@NotNull
	private int temperaturaMin;
	
	@NotNull
	private int temperaturaMax;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public int getTemperaturaMin() {
		return temperaturaMin;
	}

	public void setTemperaturaMin(int temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}

	public int getTemperaturaMax() {
		return temperaturaMax;
	}

	public void setTemperaturaMax(int temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}

}
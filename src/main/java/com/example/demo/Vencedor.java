package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;


@Entity 
public class Vencedor {
	@NotBlank 
	@Size(min=2, max = 60)
	private String laureado;
	
	private String ano;
	private String pais;
	private String descricao;
	
	@NotBlank
	private String premio;
	
	@Id
	@GeneratedValue
	private Integer id;

	public String getLaureado() {
		return laureado;
	}

	public void setLaureado(String laureado) {
		this.laureado = laureado;
	}

	
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPremio() {
		return premio;
	}

	public void setPremio(String premio) {
		this.premio = premio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Vencedor() {
		
	}
	
	
}
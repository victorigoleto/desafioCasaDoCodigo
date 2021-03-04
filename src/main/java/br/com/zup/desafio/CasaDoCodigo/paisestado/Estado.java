package br.com.zup.desafio.CasaDoCodigo.paisestado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

//CRIAÇÃO DA TABELA
@Entity
public class Estado {

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	//MUITOS ESTADOS PARA UM PAÍS
	@ManyToOne
	private Pais pais;

	@Deprecated
	public Estado() {
	}
	

	//CONSTRUTOR
	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	//GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

	public Long getId() {
		return id;
	}

	//SOBESCRITA
	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}

}


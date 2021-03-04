package br.com.zup.desafio.CasaDoCodigo.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

//CRIAÇÃO DA TABELA
@Entity
@Table(name = "categorias")
public class Categoria {

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true)
	private String nome;

	@Deprecated
	public Categoria() {}
	
	//CONSTRUTOR
	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}

	//GETTERS E SETTERS
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	//SOBESCRITA DE METODO
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
	
	
}

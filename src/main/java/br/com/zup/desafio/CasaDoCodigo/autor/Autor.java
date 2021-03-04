package br.com.zup.desafio.CasaDoCodigo.autor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//CRIAÇÃO DA TABELA
@Entity
@Table(name = "autores")
public class Autor {
	
	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;
	
	@Email
	@NotBlank
	@Column(unique = true)
	private String email;

	@NotBlank
	@Size(max = 10)
	private String descricao;

	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Deprecated
	public Autor() {}
	
	//CONSTRUTOR
	public Autor(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max = 10) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	
	//GETTERS E SETTERS
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	
	//SOBESCRITA DE METODO
	@Override
	public String toString() {
		return "Autor [id=" + id + ", email=" + email + ", nome=" + nome + ", descricao=" + descricao + ", dataCriacao="
				+ dataCriacao + "]";
	}

}

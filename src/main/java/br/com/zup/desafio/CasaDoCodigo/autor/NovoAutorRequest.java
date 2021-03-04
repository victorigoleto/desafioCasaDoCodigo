package br.com.zup.desafio.CasaDoCodigo.autor;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.desafio.CasaDoCodigo.compartilhado.UniqueValue;

//CLASSE DE REQUISIÇÃO
public class NovoAutorRequest {

	//ATRIBUTOS
	@NotBlank
	private String nome;
	
	@Email
	@NotBlank
	@UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Email deve ser único!")
	private String email;

	@NotBlank
	@Size(max = 10)
	private String descricao;

	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Deprecated
	public NovoAutorRequest() {}
	
	//CONSTRUTOR
	public NovoAutorRequest(@NotBlank String nome, @Email @NotBlank String email,
			@NotBlank @Size(max = 10) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}


	//GETTERS E SETTERS
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

	public Autor toModel() {

		return new Autor(this.nome, this.email, this.descricao);
	}
	
}

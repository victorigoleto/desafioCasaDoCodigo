package br.com.zup.desafio.CasaDoCodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zup.desafio.CasaDoCodigo.compartilhado.UniqueValue;

//CLASSE DE REQUISIÇÃO
public class NovaCategoriaRequest {
	
	//ATRIBUTOS
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Nome da categoria deve ser único!")
	private String nome;

	@Deprecated
	public NovaCategoriaRequest() {}
	
	//CONSTRUTOR
	public NovaCategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}


	//GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

		
	

}

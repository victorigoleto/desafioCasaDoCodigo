package br.com.zup.desafio.CasaDoCodigo.paisestado;

import javax.validation.constraints.NotBlank;

import br.com.zup.desafio.CasaDoCodigo.compartilhado.UniqueValue;

//CLASSE DE REQUISIÇÃO
public class NovoPaisRequest {

	//ATRIBUTOS
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "O nome deve ser único!")
	private String nome;

	@Deprecated
	public NovoPaisRequest() {}
	
	//CONSTRUTOR
	public NovoPaisRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	//GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	//SOBRESCRITA
	public Pais toModel() {
		return new Pais(this.nome);
	}
}

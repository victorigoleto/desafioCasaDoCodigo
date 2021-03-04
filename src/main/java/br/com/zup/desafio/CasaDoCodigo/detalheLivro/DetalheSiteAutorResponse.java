package br.com.zup.desafio.CasaDoCodigo.detalheLivro;

import br.com.zup.desafio.CasaDoCodigo.autor.Autor;

public class DetalheSiteAutorResponse {

	private String nome;
	private String descricao;

	@Deprecated
	public DetalheSiteAutorResponse() {}
	public DetalheSiteAutorResponse(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
}

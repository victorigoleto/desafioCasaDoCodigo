package br.com.zup.desafio.CasaDoCodigo.detalheLivro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zup.desafio.CasaDoCodigo.livro.Livro;

public class DetalheSiteLivroResponse {

	private DetalheSiteAutorResponse autor;
	private String titulo;
	private String isbn;
	private Integer paginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private String dataPublicacao;

	@Deprecated
	public DetalheSiteLivroResponse() {}
	
	public DetalheSiteLivroResponse(Livro livro) {
		
		titulo = livro.getTitulo();
		autor = new DetalheSiteAutorResponse(livro.getIdAutor());
		isbn = livro.getIsbn();
		paginas = livro.getPaginas();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public DetalheSiteAutorResponse getAutor() {
		return autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getIsbn() {
		return isbn;
	}
	public Integer getPaginas() {
		return paginas;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public String getResumo() {
		return resumo;
	}
	public String getSumario() {
		return sumario;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}
	
}

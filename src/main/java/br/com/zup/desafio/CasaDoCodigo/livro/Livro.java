package br.com.zup.desafio.CasaDoCodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zup.desafio.CasaDoCodigo.autor.Autor;
import br.com.zup.desafio.CasaDoCodigo.categoria.Categoria;

//CRIAÇÃO DA TABELA
@Entity
@Table(name = "livros")
public class Livro {

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer paginas;
	private String isbn;
	private LocalDate dataPublicacao;
	
	//MUITOS LIVROS PARA UMA CATEGORIA
	@ManyToOne
	private Categoria idCategoria;
	
	//MUITOS LIVROS PARA UM AUTOR
	@ManyToOne
	private Autor idAutor;

	@Deprecated
	public Livro() {
	}

	//CONSTRUTOR
	public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String isbn,
			LocalDate dataPublicacao, Categoria idCategoria, Autor idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}


	//SOBESCRITA
	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", paginas=" + paginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", idCategoria=" + idCategoria + ", idAutor=" + idAutor + "]";
	}

	//GETTERS E SETTERS
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getIdCategoria() {
		return idCategoria;
	}

	public Autor getIdAutor() {
		return idAutor;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	

}

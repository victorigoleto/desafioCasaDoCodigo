package br.com.zup.desafio.CasaDoCodigo.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.zup.desafio.CasaDoCodigo.paisestado.Estado;
import br.com.zup.desafio.CasaDoCodigo.paisestado.Pais;

//CRIAÇÃO DA TABELA
@Entity
public class Cliente {

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String sobrenome;

	private String documento;

	private String endereco;

	private String complemento;

	private String cidade;

	//MUITOS CLIENTES PARA UM PAÍS
	@NotNull
	@ManyToOne
	private Pais pais;

	//MUITOS CLIENTES PARA UM ESTADO
	@ManyToOne
	private Estado estado;

	private String telefone;

	private String cep;

	@Deprecated
	public Cliente() {
	}
	
	//CONSTRUTOR
	public Cliente(@Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
			@NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, Pais pais,
			@NotBlank String telefone, @NotBlank String cep) {

		this.email = email;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;

	}

	//GETTERS E SETTERS
	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	//SOBESCRITA DE METODO
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", email=" + email + ", sobrenome=" + sobrenome + ", documento=" + documento
				+ ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade + ", pais=" + pais
				+ ", estado=" + estado + ", telefone=" + telefone + ", cep=" + cep + "]";
	}

}

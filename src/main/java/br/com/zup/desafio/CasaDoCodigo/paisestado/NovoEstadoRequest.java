package br.com.zup.desafio.CasaDoCodigo.paisestado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.zup.desafio.CasaDoCodigo.compartilhado.ExistsId;
import br.com.zup.desafio.CasaDoCodigo.paisestado.validacao.UniqueEstadoPais;

//CLASSE DE REQUISIÇÃO
@UniqueEstadoPais(domainClass = Estado.class,fieldName1 = "nome",fieldName2 = "idPais")
public class NovoEstadoRequest {

	//ATRIBUTOS
	@NotBlank
	private String nome;

	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id", message = "Este Pais não existe!")
	private Long idPais;

	@Deprecated
	public NovoEstadoRequest() {
	}

	//CONSTRUTOR
	public NovoEstadoRequest(String nome, Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	//SOBRESCRITA
    public Estado toModel(EntityManager em){
        Pais pais = em.find(Pais.class,this.idPais);
        return new Estado(this.nome,pais);
    }

    //GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}


}

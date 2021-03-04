package br.com.zup.desafio.CasaDoCodigo.autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {

	//ENCAPSULA NOSSOS DADOS QUE SERÃO SALVOS
	@PersistenceContext
	private EntityManager em;
	
	//REQUISIÇÃO PARA SALVAR UM AUTOR
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoAutorRequest autorRequest){
		Autor autor = autorRequest.toModel();
		em.persist(autor);
		
		return autor.toString();
	}
	
	
}

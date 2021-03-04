package br.com.zup.desafio.CasaDoCodigo.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.CasaDoCodigo.cliente.validacao.PaisPossuiEstadoValidator;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	//ENCAPSULA NOSSOS DADOS QUE SERÃO SALVOS
	@PersistenceContext
	private EntityManager em;

	//INJEÇÃO DE DEPENDENCIAS
	@Autowired
	private PaisPossuiEstadoValidator validator;
    
    @Autowired
    private ClienteRepository clienteRepository;
	
    //PARA QUE O SPRING RECONHEÇA NOSSO VALIDATOR
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(validator);
    }
	
    //REQUISIÇÃO PARA ACESSAR TODOS OS CLIENTES CADASTRADOS
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll(){
		return ResponseEntity.ok(clienteRepository.findAll());
	}
    
	//REQUISIÇÃO PARA SALVAR UM NOVO CLIENTE
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoClienteRequest request) {
		Cliente cliente = request.toModel(em);

		em.persist(cliente);

		return cliente.toString();

	}
}

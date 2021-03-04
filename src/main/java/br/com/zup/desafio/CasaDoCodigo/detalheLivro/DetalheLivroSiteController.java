package br.com.zup.desafio.CasaDoCodigo.detalheLivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.CasaDoCodigo.livro.Livro;

@RestController
@RequestMapping("/produtos")
public class DetalheLivroSiteController {
		
	@PersistenceContext
	private EntityManager em;
	
	@GetMapping("/id")
	public ResponseEntity<?> detalhar(@PathVariable Long id) {
		
		Livro livroBuscado = em.find(Livro.class, id);
		
		
		if(livroBuscado == null) {
			return ResponseEntity.notFound().build();
		}
		
		DetalheSiteLivroResponse detalheSiteLivroResponse = new DetalheSiteLivroResponse(livroBuscado);
		
		return ResponseEntity.ok(detalheSiteLivroResponse);	
	}

}
	
	

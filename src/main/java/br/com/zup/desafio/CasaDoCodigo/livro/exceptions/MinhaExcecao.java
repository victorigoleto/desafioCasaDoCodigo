package br.com.zup.desafio.CasaDoCodigo.livro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MinhaExcecao extends RuntimeException{

	public MinhaExcecao(String error) {
		super(error);
	}
	
}

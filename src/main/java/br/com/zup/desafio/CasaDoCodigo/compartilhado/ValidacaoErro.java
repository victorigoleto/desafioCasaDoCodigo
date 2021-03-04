package br.com.zup.desafio.CasaDoCodigo.compartilhado;

public class ValidacaoErro {
	
	private String campo;
	private String mensagem;

	public ValidacaoErro(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
}

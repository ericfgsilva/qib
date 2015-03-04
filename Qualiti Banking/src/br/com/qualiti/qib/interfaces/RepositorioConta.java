package br.com.qualiti.qib.interfaces;

import br.com.qualiti.qib.entidades.ContaAbstrata;
import br.com.qualiti.qib.negocio.excecoes.ContaJaCadastradaException;
import br.com.qualiti.qib.negocio.excecoes.ContaNaoEncontradaException;

public interface RepositorioConta {

	void inserir(ContaAbstrata c)  throws ContaJaCadastradaException;
	void remover(String num)throws ContaNaoEncontradaException;
	ContaAbstrata procurar(String num);
	void atualizar(ContaAbstrata c) throws ContaNaoEncontradaException;
	boolean existe(String numero);
	
	
}

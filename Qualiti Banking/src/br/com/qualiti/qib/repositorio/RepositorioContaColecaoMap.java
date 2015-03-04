package br.com.qualiti.qib.repositorio;

import java.util.HashMap;
import java.util.Map;

import br.com.qualiti.qib.entidades.ContaAbstrata;
import br.com.qualiti.qib.interfaces.RepositorioConta;
import br.com.qualiti.qib.negocio.excecoes.ContaJaCadastradaException;
import br.com.qualiti.qib.negocio.excecoes.ContaNaoEncontradaException;

public class RepositorioContaColecaoMap implements RepositorioConta {

	private Map<String, ContaAbstrata> contas = new HashMap<String, ContaAbstrata>();
	
	@Override
	public void inserir(ContaAbstrata c) throws ContaJaCadastradaException {
		contas.put(c.getNumero(), c);
		
	}

	@Override
	public void remover(String num) throws ContaNaoEncontradaException {
		contas.remove(num);
		
	}

	@Override
	public ContaAbstrata procurar(String num) {
		return contas.get(num);
	}

	@Override
	public void atualizar(ContaAbstrata c) throws ContaNaoEncontradaException {
		contas.put(c.getNumero(), c);
	}
		
	@Override
	public boolean existe(String numero) {
		return contas.containsKey(numero);
	}

}

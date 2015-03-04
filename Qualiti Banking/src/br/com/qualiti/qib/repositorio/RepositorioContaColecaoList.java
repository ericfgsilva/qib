package br.com.qualiti.qib.repositorio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.qualiti.qib.entidades.Conta;
import br.com.qualiti.qib.entidades.ContaAbstrata;
import br.com.qualiti.qib.interfaces.RepositorioConta;
import br.com.qualiti.qib.negocio.excecoes.ContaJaCadastradaException;
import br.com.qualiti.qib.negocio.excecoes.ContaNaoEncontradaException;

public class RepositorioContaColecaoList 
							implements RepositorioConta {
	
	private List<ContaAbstrata> contas = new ArrayList<ContaAbstrata>();
	

	@Override
	public void inserir(ContaAbstrata c) throws ContaJaCadastradaException {
		if (!existe(c.getNumero())){
			contas.add(c);		
		} else {
			throw new 
				ContaJaCadastradaException
				("A conta de número: " 
				+ c.getNumero() 
				+ " já está cadastrada em nosso sistema, senhor !");
		}
	}

	@Override
	public void remover(String num) throws ContaNaoEncontradaException {
		if (existe(num)){
			contas.remove(procurar(num));
		} else 
			throw new 
				ContaNaoEncontradaException
				("A conta de número " 
				+ num + " não se encontra em nosso sistema !");
	}

	@Override
	public ContaAbstrata procurar(String num) {
		Iterator<ContaAbstrata> ite = contas.iterator();
		ContaAbstrata conta = null;
		while(ite.hasNext()){
			conta = ite.next();
			if(conta.getNumero().equals(num)){
				return conta;
			}
		}
		return null;
	}

	@Override
	public void atualizar(ContaAbstrata c) throws ContaNaoEncontradaException {
		ContaAbstrata old = procurar(c.getNumero());
		if (old != null) {
			int i = contas.indexOf(old);
			contas.set(i, c);
		}
		
	}

	@Override
	public boolean existe(String numero) {
		return procurar(numero) != null;
		
	}

}

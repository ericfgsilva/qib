package br.com.qualiti.qib.repositorio;

import br.com.qualiti.qib.entidades.Conta;
import br.com.qualiti.qib.entidades.ContaAbstrata;
import br.com.qualiti.qib.interfaces.RepositorioConta;
import br.com.qualiti.qib.negocio.excecoes.ContaNaoEncontradaException;

public class RepositorioContaArray implements RepositorioConta {

	private ContaAbstrata[]  contas;
	private int indice;
	private final static int TAM_CACHE = 100;

	public RepositorioContaArray() {
		indice = 0;
		contas = new Conta[TAM_CACHE];
	}

	public void inserir(ContaAbstrata c){
		contas[indice] = c;
		indice = indice + 1;
	}

	private int procurarIndice(String num) {
		int i = 0;
		int ind = -1;
		for( ContaAbstrata c : contas ){
			if (c != null) {
				if ((c.getNumero()).equals(num)) {
					ind = i;
					break;
				}
				i++;
			}
		}
		return ind;
	}

	public boolean existe(String num) {
		boolean resp = false;
		int i = this.procurarIndice(num);
		if( i != -1){
			resp = true;
		}
		return resp;
	}


	public void atualizar(ContaAbstrata c) throws ContaNaoEncontradaException{

		int i = procurarIndice(c.getNumero());
		if (i != -1) {
			contas[i] = c;
		} else {
			throw new ContaNaoEncontradaException("Conta não encontrada !");
		}

	}

	public ContaAbstrata procurar(String num){
		ContaAbstrata c = null;
		if (existe(num)) {
			int i = this.procurarIndice(num);
			c = contas[i];
		} else {
			System.out.println( "Conta nao encontrada" );
		}
		return c;
	}    

	public void remover(String num){
		if (existe(num)) {
			int i = this.procurarIndice(num);
			contas[i] = contas[indice - 1];
			contas[indice - 1] = null;
			indice = indice - 1;
		} else {
			System.out.println( "Conta nao encontrada" );
		}
	}

}

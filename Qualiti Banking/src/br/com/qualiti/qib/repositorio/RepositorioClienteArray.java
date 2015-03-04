package br.com.qualiti.qib.repositorio;

import br.com.qualiti.qib.entidades.Cliente;
import br.com.qualiti.qib.interfaces.RepositorioCliente;
import br.com.qualiti.qib.negocio.excecoes.ClienteNaoCadastradoException;

public class RepositorioClienteArray implements RepositorioCliente {

	private Cliente[]  clientes;
	private int indice;
	private final static int TAM_CACHE = 100;

	public RepositorioClienteArray() {
		indice = 0;
		clientes = new Cliente[TAM_CACHE];
	}

	public void inserir(Cliente c){
		clientes[indice] = c;
		indice = indice + 1;
	}

	private int procurarIndice(String cpf) {
		int i = 0;
		int ind = -1;
		for( Cliente c : clientes ){
			if (c != null) {
				if ((c.getCpf()).equals(cpf) ) {
					ind = i;
					break;
				}
				i++;
			}
		}
		return ind;
	}

	public boolean existe(String cpf) {
		boolean resp = false;
		int i = this.procurarIndice(cpf);
		if( i != -1){
			resp = true;
		}
		return resp;
	}

	public void atualizar(Cliente c) throws ClienteNaoCadastradoException {
		int i = procurarIndice(c.getCpf());
		if (i != -1) {
			clientes[i] = c;
		} else {
			throw new ClienteNaoCadastradoException( "Cliente não cadastrado !" );
		}
	}

	public Cliente procurar(String cpf) throws ClienteNaoCadastradoException{
		Cliente c = null;
		if (existe(cpf)) {
			int i = this.procurarIndice(cpf);
			c = clientes[i];
		} else {
			throw new ClienteNaoCadastradoException( "Cliente não cadastrado !" );
		}
		return c;
	}    

	public void remover(String cpf) throws ClienteNaoCadastradoException{
		if (existe(cpf)) {
			int i = this.procurarIndice(cpf);
			clientes[i] = clientes[indice - 1];
			clientes[indice - 1] = null;
			indice = indice - 1;
		} else {
			throw new ClienteNaoCadastradoException( "Cliente não encontrada" );
		}
	}
}

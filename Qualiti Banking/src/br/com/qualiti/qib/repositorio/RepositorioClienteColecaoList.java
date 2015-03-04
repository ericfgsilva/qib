package br.com.qualiti.qib.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.com.qualiti.qib.entidades.Cliente;
import br.com.qualiti.qib.interfaces.RepositorioCliente;
import br.com.qualiti.qib.negocio.excecoes.ClienteNaoCadastradoException;

public class RepositorioClienteColecaoList implements RepositorioCliente {

	private List<Cliente> clientes;

	public RepositorioClienteColecaoList() {
		this.clientes = new ArrayList<Cliente>();
	}
	
	@Override
	public void inserir(Cliente c) {
		clientes.add(c);
		
	}

	@Override
	public Cliente procurar(String cpf) throws ClienteNaoCadastradoException {
		for (Cliente c : clientes){
			if (c.getCpf().equals(cpf)){
				return c;
			}
		}
		return null;
	}

	@Override
	public void remover(String cpf) throws ClienteNaoCadastradoException {
		if (!existe(cpf)){
			throw new ClienteNaoCadastradoException("Cliente com cpf " + cpf + " não encontrado !");
		}
		clientes.remove(procurar(cpf));
	}

	@Override
	public boolean existe(String cpf) throws ClienteNaoCadastradoException {
		return procurar(cpf) != null;
	}

	@Override
	public void atualizar(Cliente c) throws ClienteNaoCadastradoException {
		// TODO Auto-generated method stub
		
	}
	
}

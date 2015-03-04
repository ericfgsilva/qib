package br.com.qualiti.qib.repositorio;

import java.util.HashMap;
import java.util.Map;

import br.com.qualiti.qib.entidades.Cliente;
import br.com.qualiti.qib.interfaces.RepositorioCliente;
import br.com.qualiti.qib.negocio.excecoes.ClienteNaoCadastradoException;

public class RepositorioClienteColecaoMap implements RepositorioCliente {

	private Map<String, Cliente> cliente = new HashMap<String, Cliente>();

	@Override
	public void inserir(Cliente c) {
		cliente.put(c.getCpf(), c);	
	}

	@Override
	public Cliente procurar(String cpf) throws ClienteNaoCadastradoException {
		return cliente.get(cliente);
	}

	@Override
	public void remover(String cpf) throws ClienteNaoCadastradoException {
		cliente.remove(cpf);
	}

	@Override
	public boolean existe(String cpf) throws ClienteNaoCadastradoException {
		return cliente.containsKey(cpf);
	}

	@Override
	public void atualizar(Cliente c) throws ClienteNaoCadastradoException {
		cliente.put(c.getCpf(), c);
	}
	


}

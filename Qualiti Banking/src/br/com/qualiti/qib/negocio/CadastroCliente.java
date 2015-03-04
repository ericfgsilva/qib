package br.com.qualiti.qib.negocio;

import java.rmi.RemoteException;

import br.com.qualiti.qib.entidades.Cliente;
import br.com.qualiti.qib.interfaces.RepositorioCliente;
import br.com.qualiti.qib.negocio.excecoes.CampoNumericoPreenchidoComLetrasException;
import br.com.qualiti.qib.negocio.excecoes.CampoObrigatorioNaoPreenchidoException;
import br.com.qualiti.qib.negocio.excecoes.ClienteInvalidoException;
import br.com.qualiti.qib.negocio.excecoes.ClienteJaCadastradoException;
import br.com.qualiti.qib.negocio.excecoes.ClienteNaoCadastradoException;

public class CadastroCliente {

	private RepositorioCliente respositorioClientes;
	
	public CadastroCliente(RepositorioCliente r) {
		this.respositorioClientes = r;
	}
	
	public void atualizar(Cliente c) throws ClienteNaoCadastradoException, CampoNumericoPreenchidoComLetrasException, CampoObrigatorioNaoPreenchidoException, ClienteInvalidoException, RemoteException {
		validar(c);
		respositorioClientes.atualizar(c);
		
	}
	public void cadastrar(Cliente c) throws ClienteJaCadastradoException, CampoNumericoPreenchidoComLetrasException, CampoObrigatorioNaoPreenchidoException, ClienteInvalidoException, ClienteNaoCadastradoException, RemoteException {
		if (!respositorioClientes.existe(c.getCpf())) {
			validar(c);
			respositorioClientes.inserir(c);
			
		} else {  
			throw new ClienteJaCadastradoException("Cliente já cadastrado !");
		}
	}

	public void descadastrar(String n) throws ClienteNaoCadastradoException, RemoteException {
		respositorioClientes.remover(n);
	}
	public Cliente procurar(String n) throws ClienteNaoCadastradoException, RemoteException {
		return respositorioClientes.procurar(n);
	}
	
	public void validar(Cliente cliente) 
			throws CampoNumericoPreenchidoComLetrasException, 
				   CampoObrigatorioNaoPreenchidoException,
				   ClienteInvalidoException {
		if (cliente == null) {
			throw new ClienteInvalidoException("Cliente não informado !");
		}
		cliente.setNome(cliente.getNome().toUpperCase());
		cliente.setCpf(cliente.getCpf().trim().replaceAll("[^\\d]+", ""));
		
		if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
			throw new CampoObrigatorioNaoPreenchidoException("Favor informar o CPF do cliente !");
		}
		if (cliente.getCpf().length() != 11 ) {
			throw new ClienteInvalidoException("Favor informar CPF com 11 dígitos !");
		}
		if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
			throw new CampoObrigatorioNaoPreenchidoException("Favor informar o nome do cliente !");
		}
	}
}


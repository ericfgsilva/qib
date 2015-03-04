package br.com.qualiti.qib.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.com.qualiti.qib.entidades.Cliente;
import br.com.qualiti.qib.entidades.ContaAbstrata;
import br.com.qualiti.qib.interfaces.RepositorioCliente;
import br.com.qualiti.qib.interfaces.RepositorioConta;
import br.com.qualiti.qib.negocio.CadastroCliente;
import br.com.qualiti.qib.negocio.CadastroConta;
import br.com.qualiti.qib.negocio.excecoes.CampoNumericoPreenchidoComLetrasException;
import br.com.qualiti.qib.negocio.excecoes.CampoObrigatorioNaoPreenchidoException;
import br.com.qualiti.qib.negocio.excecoes.ClienteInvalidoException;
import br.com.qualiti.qib.negocio.excecoes.ClienteJaCadastradoException;
import br.com.qualiti.qib.negocio.excecoes.ClienteNaoCadastradoException;
import br.com.qualiti.qib.negocio.excecoes.ContaInvalidaException;
import br.com.qualiti.qib.negocio.excecoes.ContaJaCadastradaException;
import br.com.qualiti.qib.negocio.excecoes.ContaNaoEncontradaException;
import br.com.qualiti.qib.negocio.excecoes.SaldoInsuficienteException;
import br.com.qualiti.qib.repositorio.RepositorioContaArray;

public class Fachada {

	//1 - referência de si mesmo
	private static Fachada instancia;
	
	private CadastroConta cadastroContas;
	private CadastroCliente cadastroClientes;
	
	//2 - Construtor privado
	private Fachada() {
		initCadastros();
	}
	
	//3 - Método de acesso à referencia de si mesma
	public static Fachada obterInstancia() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}

	private void initCadastros() {
		RepositorioConta rep = 
				new RepositorioContaArray();
		cadastroContas = new CadastroConta(rep);

		RepositorioCliente repClientes = null;
		try {
			repClientes = (RepositorioCliente) Naming.lookup("//localhost/repositorio");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cadastroClientes = new CadastroCliente(repClientes);
	}

	public void atualizar (Cliente c) throws ClienteNaoCadastradoException, CampoNumericoPreenchidoComLetrasException, CampoObrigatorioNaoPreenchidoException, ClienteInvalidoException, RemoteException {
		cadastroClientes.atualizar(c);
	}
	public Cliente procurarCliente(String cpf) throws ClienteNaoCadastradoException, RemoteException {
		return cadastroClientes.procurar(cpf);
	}
	public void cadastrar(Cliente c) throws ClienteJaCadastradoException, CampoNumericoPreenchidoComLetrasException, CampoObrigatorioNaoPreenchidoException, ClienteInvalidoException, ClienteNaoCadastradoException, RemoteException {
		cadastroClientes.cadastrar(c);
	}
	public void descadastrarCliente(String cpf) throws ClienteNaoCadastradoException, RemoteException {
		cadastroClientes.descadastrar(cpf);
	}

	public void atualizar (ContaAbstrata c) throws ContaNaoEncontradaException {
		cadastroContas.atualizar(c);
	}
	public ContaAbstrata procurarConta(String n) {
		return cadastroContas.procurar(n);
	}
	public void cadastrar(ContaAbstrata c) throws ContaJaCadastradaException, ContaInvalidaException, ClienteNaoCadastradoException, RemoteException {
		cadastroContas.cadastrar(c);
	}

	public void removerConta(String n) throws ContaNaoEncontradaException {
		cadastroContas.descadastrar(n);
	}
	public void creditar(String n, double v) throws ContaNaoEncontradaException {
		cadastroContas.creditar(n, v);
	}
	public void debitar(String n, double v) throws SaldoInsuficienteException, ContaNaoEncontradaException {
		cadastroContas.debitar(n, v);
	}
	public void transferir(String origem, 
			String destino, double val) throws SaldoInsuficienteException, ContaNaoEncontradaException {  
		cadastroContas.transferir(origem, destino, val);
	}
}

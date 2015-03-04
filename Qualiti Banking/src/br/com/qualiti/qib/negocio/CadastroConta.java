package br.com.qualiti.qib.negocio;

import java.rmi.RemoteException;

import br.com.qualiti.qib.entidades.Cliente;
import br.com.qualiti.qib.entidades.ContaAbstrata;
import br.com.qualiti.qib.interfaces.RepositorioConta;
import br.com.qualiti.qib.main.Fachada;
import br.com.qualiti.qib.negocio.excecoes.ClienteNaoCadastradoException;
import br.com.qualiti.qib.negocio.excecoes.ContaInvalidaException;
import br.com.qualiti.qib.negocio.excecoes.ContaJaCadastradaException;
import br.com.qualiti.qib.negocio.excecoes.ContaNaoEncontradaException;
import br.com.qualiti.qib.negocio.excecoes.SaldoInsuficienteException;

public class CadastroConta {

	private RepositorioConta repositorioContas;
	public CadastroConta(RepositorioConta r) {
		this.repositorioContas = r;
	}
	public void atualizar(ContaAbstrata c) throws ContaNaoEncontradaException {
		repositorioContas.atualizar(c);
	}
	
	public void cadastrar(ContaAbstrata c) throws ContaJaCadastradaException, ContaInvalidaException, ClienteNaoCadastradoException, RemoteException{
		if (!repositorioContas.existe(c.getNumero())) {
			validarConta(c);			
			repositorioContas.inserir(c);
		} else {  
			throw new ContaJaCadastradaException("Número de conta já existente !");
		}
	}

	public void creditar(String n, double v) throws ContaNaoEncontradaException {
		ContaAbstrata c = repositorioContas.procurar(n);
		c.creditar(v);
		repositorioContas.atualizar(c);
	}
	public void debitar(String n, double v) 
			throws SaldoInsuficienteException, ContaNaoEncontradaException {
		ContaAbstrata c = repositorioContas.procurar(n);
		c.debitar(v);
		repositorioContas.atualizar(c);
	}
	public void descadastrar(String n) throws ContaNaoEncontradaException {
		repositorioContas.remover(n);
	}

	public ContaAbstrata procurar(String n) {
		return repositorioContas.procurar(n);
	}

	public void transferir(String origem, 
			String destino, 
			double val) throws SaldoInsuficienteException, ContaNaoEncontradaException {

		ContaAbstrata o = repositorioContas.procurar(origem);
		ContaAbstrata d = repositorioContas.procurar(destino);
		o.transferir(d, val);
		repositorioContas.atualizar(o);
		repositorioContas.atualizar(d);
	}
	
	/**
	 * @param c
	 * @throws ContaInvalidaException
	 * @throws ClienteNaoCadastradoException 
	 * @throws RemoteException 
	 */
	private void validarConta(ContaAbstrata c) throws ContaInvalidaException, ClienteNaoCadastradoException, RemoteException {
		
		if (c.getCliente() == null) {
			throw new ContaInvalidaException("Conta informada sem o cliente !");
		}
		if (c.getNumero() == null || c.getNumero().isEmpty()) {
			throw new ContaInvalidaException("Número da conta não foi informado !");
		}
		c.setNumero(c.getNumero().replaceAll("[^\\d]+", "").trim());
		
		if (c.getSaldo() < 0) {
			throw new ContaInvalidaException("O saldo da conta é menor que zero, favor corrigir !");
		}
		Cliente cliente = Fachada.obterInstancia().procurarCliente(c.getCliente().getCpf());
		if (cliente == null) {
			throw new ContaInvalidaException("Cliente desta conta não cadastrado no sistema, favor cadastrar !");
		}
	}
}

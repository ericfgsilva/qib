package br.com.qualiti.qib.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.qualiti.qib.entidades.Conta;
import br.com.qualiti.qib.entidades.ContaAbstrata;
import br.com.qualiti.qib.interfaces.RepositorioConta;
import br.com.qualiti.qib.negocio.excecoes.ContaJaCadastradaException;
import br.com.qualiti.qib.negocio.excecoes.ContaNaoEncontradaException;

public class RepositorioContaHibernate implements RepositorioConta {

	private EntityManager manager;
	
	
	public RepositorioContaHibernate() {
		manager = Persistence.createEntityManagerFactory("Qualiti_Banking")
					.createEntityManager();
	}

	@Override
	public void inserir(ContaAbstrata c) throws ContaJaCadastradaException {
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();		
	}

	@Override
	public void remover(String num) throws ContaNaoEncontradaException {
		manager.getTransaction().begin();
		manager.remove(manager.find(Conta.class, num));
		manager.getTransaction().commit();		
	}

	@Override
	public ContaAbstrata procurar(String num) {
		return manager.find(Conta.class, num);
	}

	@Override
	public void atualizar(ContaAbstrata c) throws ContaNaoEncontradaException {
		manager.getTransaction().begin();
		Conta conta = manager.find(Conta.class, c.getNumero());
		conta.setCliente(c.getCliente());
		conta.setSaldo(c.getSaldo());
		manager.persist(conta);
		manager.getTransaction().commit();		
	}

	@Override
	public boolean existe(String numero) {
		return procurar(numero) != null;
	}	

}

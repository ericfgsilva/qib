package br.com.qualiti.qib.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.qualiti.qib.entidades.Cliente;
import br.com.qualiti.qib.interfaces.RepositorioCliente;
import br.com.qualiti.qib.negocio.excecoes.ClienteNaoCadastradoException;

public class RepositorioClienteHibernate implements RepositorioCliente {

	private EntityManager manager;
	
	
	public RepositorioClienteHibernate() {
		manager = Persistence.createEntityManagerFactory("Qualiti_Banking")
					.createEntityManager();
	}
	
	@Override
	public void inserir(Cliente c) {
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
	}

	@Override
	public Cliente procurar(String cpf) throws ClienteNaoCadastradoException {
		return manager.find(Cliente.class, cpf);
	}

	@Override
	public void remover(String cpf) throws ClienteNaoCadastradoException {
		manager.getTransaction().begin();
		manager.remove(manager.find(Cliente.class, cpf));
		manager.getTransaction().commit();
	}

	@Override
	public boolean existe(String cpf) throws ClienteNaoCadastradoException {
		return procurar(cpf) != null;
	}

	@Override
	public void atualizar(Cliente c) throws ClienteNaoCadastradoException {
		manager.getTransaction().begin();
		Cliente cliente = manager.find(Cliente.class, c.getCpf());
		cliente.setNome(c.getNome());
		manager.persist(cliente);
		manager.getTransaction().commit();
	}
}

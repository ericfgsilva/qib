package br.com.qualiti.qib.interfaces;

import br.com.qualiti.qib.entidades.Cliente;
import br.com.qualiti.qib.negocio.excecoes.ClienteNaoCadastradoException;

public interface RepositorioCliente {
	
	void inserir(Cliente c);
	Cliente procurar(String cpf) throws ClienteNaoCadastradoException;
	void remover(String cpf) throws ClienteNaoCadastradoException;
	boolean existe(String cpf) throws ClienteNaoCadastradoException;
	void atualizar(Cliente c) throws ClienteNaoCadastradoException;

}

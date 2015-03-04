package br.com.qualiti.qib.repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.regexp.internal.recompile;

import br.com.qualiti.qib.entidades.Cliente;
import br.com.qualiti.qib.interfaces.RepositorioCliente;
import br.com.qualiti.qib.negocio.excecoes.ClienteNaoCadastradoException;
import br.com.qualiti.qib.util.QualitiUtil;

public class RepositorioClienteJDBC implements RepositorioCliente {

	@Override
	public void inserir(Cliente c) {
		String sql = "INSERT INTO TB_CLIENTE (CPF, NOME) VALUES ('" 
				+ c.getCpf() + "', '" + c.getNome() +"')";
		
		Connection conn = QualitiUtil.getConexao();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			QualitiUtil.fechaConexao(conn);
			if (i != 1){
				System.out.println("Erro ao inserir na base de dados !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Cliente procurar(String cpf) throws ClienteNaoCadastradoException {
		String sql = "SELECT * FROM TB_CLIENTE WHERE CPF = '" 
				+ cpf + "'";
		Connection conn = QualitiUtil.getConexao();
		Statement stmt;
		Cliente retorno = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				retorno = new Cliente();
				retorno.setNome(rs.getString("nome"));
				retorno.setCpf(rs.getString("cpf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public void remover(String cpf) throws ClienteNaoCadastradoException {
		String sql = "DELETE FROM TB_CLIENTE WHERE CPF = '" + cpf +"'";
		Connection conn = QualitiUtil.getConexao();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			if (i != 1){
				System.out.println("Erro ao remover da base de dados !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public boolean existe(String cpf) throws ClienteNaoCadastradoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void atualizar(Cliente c) throws ClienteNaoCadastradoException {
		String sql = "UPDATE TB_CLIENTE SET NOME = '" 
				+ c.getNome() + "' WHERE CPF = '" 
				+ c.getCpf() + "'";
		Connection conn = QualitiUtil.getConexao();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			if (i != 1){
				System.out.println("Erro ao atualizar cliente ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

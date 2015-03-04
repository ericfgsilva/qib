package br.com.qualiti.qib.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.qualiti.qib.entidades.Conta;
import br.com.qualiti.qib.entidades.ContaAbstrata;
import br.com.qualiti.qib.entidades.ContaBonificada;
import br.com.qualiti.qib.entidades.ContaImposto;
import br.com.qualiti.qib.entidades.ContaPoupanca;
import br.com.qualiti.qib.interfaces.RepositorioConta;
import br.com.qualiti.qib.negocio.excecoes.ContaJaCadastradaException;
import br.com.qualiti.qib.negocio.excecoes.ContaNaoEncontradaException;
import br.com.qualiti.qib.util.QualitiUtil;

public class RepositorioContaJDBC implements RepositorioConta {

	@Override
	public void inserir(ContaAbstrata c) throws ContaJaCadastradaException {
		String sql  = "INSERT INTO TB_CONTA (TB_CLIENTE_CPF, NUMERO, SALDO, TIPO)"
					+ "VALUES(?, ?, ?, ? )";
		
		Connection conn = QualitiUtil.getConexao();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getCliente().getCpf());
			ps.setString(2, c.getNumero());
			ps.setDouble(3, c.getSaldo());
			ps.setInt(4, getTipoConta(c));
			int result = ps.executeUpdate();
			if (result != 1){
				System.out.println("Erro ao inserir na base de dados !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int getTipoConta(ContaAbstrata c) {
		if (c instanceof ContaPoupanca){
			return 1;
		} else if (c instanceof ContaBonificada){
			return 2;
		} else if (c instanceof ContaImposto){
			return 3;
		}
		return 0;
	}

	@Override
	public void remover(String num) throws ContaNaoEncontradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conta procurar(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(ContaAbstrata c) throws ContaNaoEncontradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existe(String numero) {
		// TODO Auto-generated method stub
		return false;
	}

}

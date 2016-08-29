package br.com.qualiti.qib.main;

import java.sql.Connection;
import br.com.qualiti.qib.util.QualitiUtil;

public class TestaConexao {

	public static void main(String[] args) {
		Connection conn = QualitiUtil.getConexao();
		if (conn != null){
			System.out.println("OK");
		}
		QualitiUtil.fechaConexao(conn);

	}

}

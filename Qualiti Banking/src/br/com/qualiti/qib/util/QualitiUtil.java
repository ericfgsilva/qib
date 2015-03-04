package br.com.qualiti.qib.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QualitiUtil {

	private QualitiUtil(){

	}

	public static Connection getConexao(){
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			String url = "jdbc:hsqldb:hsql://localhost:9090/qib";
			Connection con = 
					DriverManager.getConnection(url, "sa", "");
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void fechaConexao(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

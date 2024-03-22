package com.escola.api.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {
	
	public static Connection conectar()throws SQLException, ClassNotFoundException {
		String url = "jdbc:postgresql://localhost:5432/aulajava";
		String usu = "postgres";
		String pass = "fnsj3053";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,usu,pass);
		return con;
	}
}

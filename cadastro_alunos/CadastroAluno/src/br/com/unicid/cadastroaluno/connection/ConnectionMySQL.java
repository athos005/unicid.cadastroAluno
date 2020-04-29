package br.com.unicid.cadastroaluno.connection;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionMySQL {

	public static Connection getConnection() throws Exception{
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbName = "localhost"; // nome do banco
			String dbPort = "3306"; // porta de acesso do banco
			String dbSchema = "cadastroaluno";
			String dbUserName = "root"; //nome do us�ario do banco de dados
			String dbPassword = "root"; //senha do banco de dados
			String dbUrl = "jdbc:mysql://" + dbName + ":" + dbPort + "/" + dbSchema + "?useTimezone=true&serverTimezone=UTC"; //url do banco
			return DriverManager.getConnection(dbUrl, dbUserName, dbPassword); //vari�vel de conex�o
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			Connection conn = ConnectionMySQL.getConnection();
			System.out.println("Conectado");
	}
		catch(Exception e){
			 e.printStackTrace();
			}
		}
	
}


package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
/* Módulo de Conexão*/
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver"; /* só funciona se tivermos importado o driver para a pasta lib*/
	private String url = "jdbc:mysql://127.0.0.1:3306/dbestoque1?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "123456";
	
	//Método de conexão
	
	private Connection conectar()
	{
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} 
	}
	
	public void testeConexao()
	{
		try {Connection con = conectar();
		System.out.println(con);
		con.close();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	} 
	
	
	public void inserirContato(JavaBeans contato) {
		String criar = "insert into clientes (idcon,idade,endereço,escolaridade) values (?,?,?,?)";
		try {
			
			
			Connection con = conectar();
			
			
			PreparedStatement pst = con.prepareStatement(criar);
			
			pst.setString(1,contato.getIdcon()); 
			pst.setString(2,contato.getIdade());
			pst.setString(3,contato.getEndereço());
			pst.setString(3,contato.getEscolaridade());
			
		
			pst.executeUpdate();
			
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
}

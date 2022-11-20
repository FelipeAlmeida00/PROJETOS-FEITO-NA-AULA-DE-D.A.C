package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet; 
import com.mysql.cj.protocol.Resultset;

public class DAO {
/* Módulo de Conexão*/
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver"; /* só funciona se tivermos importado o driver para a pasta lib*/
	private String url = "jdbc:mysql://127.0.0.1:3306/dbclientes?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "12345678";
	
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
	//teste de conexão
	public void testeConexao()
	{
		try {Connection con = conectar();
		System.out.println(con);
		con.close();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	} //descomentar para testar a conexão
	
	/* CRUDE */
	public void inserirContato(JavaBeans contato) {
		String criar = "insert into clientes (nome,fone,email) values (?,?,?)";
		try {
			
			//abrir a conexão com o banco
			Connection con = conectar();
			
			//preparar a query para a execução no banco de dados
			PreparedStatement pst = con.prepareStatement(criar);
			
			//Substituir os parâmetros (?,?,?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1,contato.getNome()); /* O 1 diz respeito ao primeiro ponto de interrogação*/
			pst.setString(2,contato.getFone());
			pst.setString(3,contato.getEmail());
			
			//Executar a query
			pst.executeUpdate();
			
			//Encerrar a conexão com o banco
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		/* CRUD Read */
		/* public ArrayList<JavaBeans> listarContatos(){
			String ler = "select * from clientes order by name";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(ler);
				Resultset rs = pst.executeQuery();
				//laço que será executado enquanto houver contatos
				while(rs.next()) {
					// variáveis de apoio que recebem os dados do banco
					String idcon = rs getString(1);
					String nome = rs getString(2);
					String idcon = rs getString(1);
				}
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		} */
		
	}
	
}

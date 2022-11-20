package model;

public class JavaBeans {

	private String idcon;
	private String idade;
	private String endereço;
	private String escolaridade;
	
	
	
	public JavaBeans() {
		super();
	}
	
	
	
	public JavaBeans(String idcon, String idade, String endereço, String escolaridade) {
		super();
		this.idcon = idcon;
		this.idade = idade;
		this.endereço = endereço;
		this.escolaridade = escolaridade;
	}



	public String getIdcon() {
		return idcon;
	}



	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}



	public String getIdade() {
		return idade;
	}



	public void setIdade(String idade) {
		this.idade = idade;
	}



	public String getEndereço() {
		return endereço;
	}



	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}



	public String getEscolaridade() {
		return escolaridade;
	}



	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}




	
	
}

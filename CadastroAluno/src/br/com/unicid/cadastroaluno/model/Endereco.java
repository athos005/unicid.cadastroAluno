package br.com.unicid.cadastroaluno.model;

public class Endereco {

	private int codEndereco;
	private String cep;
	private String endereco;
	private String bairro;
	private String complemento;
	private String numCasa;
	private String uf;
	private String cidade;

	
	public int getCodEndereco() {
		return this.codEndereco;
	}
	
	public void setCodEndereco(int codEndereco) {
		this.codEndereco = codEndereco;
	}
	
	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep.replaceAll("[\\D]", "");
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getBairro() {
		return this.bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getComplemento() {
		return this.complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getNumero() {
		return this.numCasa;
	}
	
	public void setNumero(String numero) {
		this.numCasa = numero;
	}
	
	public String getUf() {
		return this.uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}

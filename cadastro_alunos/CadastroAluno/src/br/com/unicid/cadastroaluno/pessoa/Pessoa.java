package br.com.unicid.cadastroaluno.pessoa;

public class Pessoa {
	
	private String nome;
	private String dataNascimento;
	private boolean genero;
	private int cpf;
	private String email;
	private String celular;
	private String telefone;
		
	protected Pessoa(){
		
	}
	
	protected Pessoa(String nome, int cpf){
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDataNascimento() {
		return this.dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public boolean getGereno() {
		return this.genero;
	}
	
	public void setGenero(boolean genero) {
		this.genero = genero;
	}
	
	public int getCpf() {
		return this.cpf;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;		
	}
	
	public String getCelular() {
		return this.celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}

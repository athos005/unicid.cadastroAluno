package br.com.unicid.cadastroaluno.model;

import javax.swing.JComboBox;

import br.com.unicid.cadastroaluno.DAO.EnderecoDAO;
import br.com.unicid.cadastroaluno.DAO.PessoaDAO;
import br.com.unicid.cadastroaluno.view.frmAluno;

public class Pessoa extends Endereco{
	
	private String nome;
	private String cpf;
	private String genero;
	private String email;
	private String celular;
	private String telefone;
		
	protected Pessoa() {
		
	}
	
	protected Pessoa(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf.replaceAll("[\\D]", "");;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public String getGereno() {
		return this.genero;
	}
	
	public void setGenero(JComboBox<?> genero) {
		
		switch (genero.getSelectedIndex()) {
		case 1: this.genero = "M";
		break;
		case 2: this.genero = "F";
		break;
		}
	}
	
	public String getCpf() {
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
		this.celular = celular.replaceAll("[\\D]", "");
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone.replaceAll("[\\D]", "");
	}
	
	public void salvarCadastro() throws Exception {
		
		EnderecoDAO DAOendereco = new EnderecoDAO();
		DAOendereco.salvaEndereco(frmAluno.aluno);
		
		PessoaDAO DAOpessoa = new PessoaDAO();
		DAOpessoa.salvarPessoa(frmAluno.aluno);
		
	}
}

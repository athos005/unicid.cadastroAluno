package br.com.unicid.cadastroaluno.model;

import javax.swing.JComboBox;

import br.com.unicid.cadastroaluno.DAO.EnderecoDAO;
import br.com.unicid.cadastroaluno.DAO.PessoaDAO;
import br.com.unicid.cadastroaluno.view.frmAluno;

public class Pessoa extends Endereco{
	
	/*ATRIBUTOS*/
	/*------------------------------------*/
	
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String genero;
	private String email;
	private String celular;
	private String telefone;
	
	
	/*CONSTRUTORES*/
	/*------------------------------------*/
	
	public Pessoa() {
		
	}
	
	protected Pessoa(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf.replaceAll("[\\D]", "");
	}
	
	
	/*GETTERS & SETTERS*/
	/*------------------------------------*/
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf.replaceAll("[\\D]", "");
	}
	
	public String getDataNascimento() {
		return this.dataNascimento.replaceAll("[\\D]", "");
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getGereno() {
		return this.genero;
	}
	
	public int getGenero(JComboBox<?> ComboGenero) {
		int index = 0;
		
		if(this.genero == "M") {
			index = 0;
		} else {
			index = 1;
		}
		
		ComboGenero.setSelectedIndex(index);
		
		return index; 
		
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setGenero(JComboBox<?> genero) {
		
		switch (genero.getSelectedIndex()) {
		case 1: this.genero = "M";
		break;
		case 2: this.genero = "F";
		break;
		}
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

	
	/*MÉTODOS DA CLASSE*/
	/*------------------------------------*/
	
	protected void salvarCadastro() throws Exception {
		
		EnderecoDAO DAOendereco = new EnderecoDAO();
		DAOendereco.salvaEndereco(frmAluno.aluno);
		
		PessoaDAO DAOpessoa = new PessoaDAO();
		DAOpessoa.salvarPessoa(frmAluno.aluno);
		
	}
	
	protected void connsultarCadastro() throws Exception {
		
		PessoaDAO DAOpessoa = new PessoaDAO();
		DAOpessoa.consultarPessoa(frmAluno.aluno.getCodPessoa());
		
		EnderecoDAO DAOendereco = new EnderecoDAO();
		DAOendereco.consultarEndereco(frmAluno.aluno.getCodEndereco());
	}
}

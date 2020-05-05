package br.com.unicid.cadastroaluno.model;

import javax.swing.JComboBox;

import br.com.unicid.cadastroaluno.DAO.EnderecoDAO;
import br.com.unicid.cadastroaluno.DAO.PessoaDAO;
import br.com.unicid.cadastroaluno.view.frmAluno;

public class Pessoa extends Endereco{
	
	/*ATRIBUTOS*/
	/*------------------------------------*/
	
	private int codPessoa;
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String genero;
	private String email;
	private String celular;
	private String telefone;
	private PessoaDAO DAOpessoa;
	private EnderecoDAO DAOendereco;
	
	
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
	
	public int getCodPessoa() {
		return this.codPessoa;
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}
	
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
		return this.dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento.replaceAll("[\\D]", "");
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
		
		DAOendereco = new EnderecoDAO();
		DAOendereco.salvarEndereco(frmAluno.aluno);
		
		DAOpessoa = new PessoaDAO();
		DAOpessoa.salvarPessoa(frmAluno.aluno);
	}
	
	protected void connsultarCadastro() throws Exception {
		
		DAOpessoa = new PessoaDAO();
		DAOpessoa.consultarPessoa(frmAluno.aluno.getCodPessoa());
		
		DAOendereco = new EnderecoDAO();
		DAOendereco.consultarEndereco(frmAluno.aluno.getCodEndereco());
	}
	
	protected void alterarCadastro() throws Exception{
		
		DAOendereco = new EnderecoDAO();
		DAOendereco.alterarEndereco(frmAluno.aluno);
		
		DAOpessoa = new PessoaDAO();
		DAOpessoa.alterarPessoa(frmAluno.aluno);
		
	}
	
	protected void excluirCadastrato() throws Exception{
			
		DAOpessoa = new PessoaDAO();
		DAOpessoa.excluirCadastro(frmAluno.aluno.getCodPessoa());
		
		DAOendereco = new EnderecoDAO();
		DAOendereco.excluirEndereco(frmAluno.aluno.getCodEndereco());
		
	}
}

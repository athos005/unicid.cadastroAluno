package br.com.unicid.cadastroaluno.model;

import javax.swing.JComboBox;

import br.com.unicid.cadastroaluno.DAO.EnderecoDAO;
import br.com.unicid.cadastroaluno.DAO.PessoaDAO;
import br.com.unicid.cadastroaluno.view.frmAluno;

public class Pessoa extends Endereco{
	
	private int codPessoa;
	private String nome;
	private String cpf;
	private String genero;
	private String email;
	private String celular;
	private String telefone;
		
	public Pessoa() {
		
	}
	
	protected Pessoa(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf.replaceAll("[\\D]", "");;
	}
	
	
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
		
	public String getGereno() {
		return this.genero;
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
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	protected void salvarCadastro() throws Exception {
		
		EnderecoDAO DAOendereco = new EnderecoDAO();
		DAOendereco.salvaEndereco(frmAluno.aluno);
		
		PessoaDAO DAOpessoa = new PessoaDAO();
		DAOpessoa.salvarPessoa(frmAluno.aluno);
		
	}
	
	public void consultarCadastro() throws Exception{
		PessoaDAO DAOpessoa = new PessoaDAO();
		DAOpessoa.consultarPessoa();
		System.out.println(codPessoa);
	}
}

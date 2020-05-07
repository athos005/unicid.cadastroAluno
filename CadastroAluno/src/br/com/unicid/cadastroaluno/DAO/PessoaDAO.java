package br.com.unicid.cadastroaluno.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.unicid.cadastroaluno.connection.ConnectionDB;
import br.com.unicid.cadastroaluno.model.Aluno;
import br.com.unicid.cadastroaluno.model.Endereco;
import br.com.unicid.cadastroaluno.model.Pessoa;
import br.com.unicid.cadastroaluno.view.frmAluno;

public class PessoaDAO {

	protected Pessoa pessoa;
	private Connection conn; //Conecta com o banco
	private PreparedStatement ps; //executa a query
	private ResultSet rs;

	/*INICIA A CONEÇÃO COM O BANCO AO CONSTRUIR O OBJETO*/
	public PessoaDAO() throws Exception{
		try {
			conn = ConnectionDB.getConnection();
		}
		catch(Exception e) {
			throw new Exception("Erro " + e.getMessage());
		}
	}

	/*SALVAR PESSOA*/
	
	public void salvarPessoa(Pessoa pessoa) throws Exception{				

		try {
			String sql = "INSERT INTO pessoa(nome, cpf, nascimento, genero, email, celular, telefone, cod_Endereco)" + "VALUES(?,?,?,?,?,?,?,?)";
			
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setString(3, pessoa.getDataNascimento());
			ps.setString(4, pessoa.getGereno());
			ps.setString(5, pessoa.getEmail());
			ps.setString(6, pessoa.getCelular());
			ps.setString(7, pessoa.getTelefone());
			ps.setInt(8, pessoa.getCodEndereco());
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();  
			rs.next();
			pessoa.setCodPessoa(rs.getInt(1)); 

			ps.close();
		}
		catch(Exception e) {
			throw new Exception("Erro ao Salvar" + e.getMessage());
		}
	}

	/*CONSULTAR PESSOA*/
	
	public void consultarPessoa(int codPessoa) throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM pessoa WHERE cod_pessoa=?");
			ps.setInt(1, codPessoa);
			rs = ps.executeQuery(); 
			if(rs.next()) {
				pessoa = frmAluno.aluno;
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setDataNascimento(rs.getString("nascimento"));
				pessoa.setGenero(rs.getString("genero"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setCelular(rs.getString("celular"));
				pessoa.setTelefone(rs.getString("Telefone"));
				pessoa.setCodEndereco(rs.getInt("cod_endereco"));
				ps.close();
			}

		}
		catch (Exception e) {
			throw new Exception("Erro ao consultar" + e.getMessage());
		}
	}
	
	/*ALTERAR PESSOA*/
	
	public void alterarPessoa(Pessoa pessoa) throws Exception{				

		try {
			String sql = "UPDATE pessoa SET nome=?, cpf=?, nascimento=?, genero=?, email=?, celular=?, telefone=? WHERE cod_pessoa=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setString(3, pessoa.getDataNascimento());
			ps.setString(4, pessoa.getGereno());
			ps.setString(5, pessoa.getEmail());
			ps.setString(6, pessoa.getCelular());
			ps.setString(7, pessoa.getTelefone());
			ps.setInt(8, pessoa.getCodPessoa());
			
			ps.executeUpdate();
			ps.close();
			
			
		}
		catch(Exception e) {
			throw new Exception("Erro ao Salvar" + e.getMessage());
		}
	}
	
	/*EXCLUIR CADASTRO*/
	
	public void excluirCadastro(int codPessoa) throws Exception{
		
		try {

			String sql = "DELETE FROM pessoa WHERE cod_pessoa=?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codPessoa);
			
			ps.executeUpdate();
			ps.close();
		}
		catch(Exception e) {
			throw new Exception("Erro ao Excluir" + e.getMessage());
		}
	}
}

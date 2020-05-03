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

public class PessoaDAO {

	private Pessoa pessoa;
	private Connection conn; //Conecta com o banco
	private PreparedStatement ps; //executa a query
	private ResultSet rs;
	protected static int codPessoa;

	public PessoaDAO() throws Exception{
		try {
			conn = ConnectionDB.getConnection();
		}
		catch(Exception e) {
			throw new Exception("Erro " + e.getMessage());
		}
	}
	
	public void salvarPessoa(Pessoa pessoa) throws Exception{				
		
		try {
			String sql = "INSERT INTO pessoa(nome, cpf, genero, email, celular, telefone, cod_Endereco)" + "VALUES(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setString(3, pessoa.getGereno());
			ps.setString(4, pessoa.getEmail());
			ps.setString(5, pessoa.getCelular());
			ps.setString(6, pessoa.getTelefone());
			ps.setInt(7, EnderecoDAO.codEndereco);
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();  
			rs.next();
			codPessoa = rs.getInt(1);

			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");

			ps.close();
		}
		catch(Exception e) {
			throw new Exception("Erro ao Salvar" + e.getMessage());
		}
	}
}

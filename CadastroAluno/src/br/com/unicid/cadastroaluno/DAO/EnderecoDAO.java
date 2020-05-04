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

public class EnderecoDAO{

	private Endereco endereco;
	private Connection conn; //Conecta com o banco
	private PreparedStatement ps; //executa a query
	private ResultSet rs;
	protected static int codEndereco;

	public EnderecoDAO() throws Exception{
		try {
			conn = ConnectionDB.getConnection();
		}
		catch(Exception e) {
			throw new Exception("Erro " + e.getMessage());
		}
	}

	public void salvaEndereco(Endereco endereco) throws Exception {

		try {

			String sql = "INSERT INTO endereco(cep, endereco, bairro, complemento, numero, uf, cidade)" + "VALUES(?,?,?,?,?,?,?)";

			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, endereco.getCep());
			ps.setString(2, endereco.getEndereco());
			ps.setString(3, endereco.getBairro());
			ps.setString(4, endereco.getComplemento());
			ps.setString(5, endereco.getNumero());
			ps.setString(6, endereco.getUf());
			ps.setString(7, endereco.getCidade());
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();  
			rs.next();
			codEndereco = rs.getInt(1);

			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");

			ps.close();
		}
		catch(Exception e) {
			throw new Exception("Erro ao Salvar" + e.getMessage());
		}
	}

	public void consultarEndereco(int codEndereco) throws Exception {

		try {
			ps = conn.prepareStatement("SELECT * FROM endereco WHERE cod_endereco=?");
			ps.setInt(1, codEndereco);
			rs = ps.executeQuery(); 
			if(rs.next()) {
				endereco = frmAluno.aluno;
				endereco.setCep(rs.getString("cep"));
				endereco.setEndereco(rs.getString("endereco"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setUf(rs.getString("uf"));
				endereco.setCidade(rs.getString("cidade"));
				ps.close();
			}

		}
		catch (Exception e) {
			throw new Exception("Erro ao consultar" + e.getMessage());
		}
	}
}

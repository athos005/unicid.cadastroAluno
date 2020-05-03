package br.com.unicid.cadastroaluno.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

import br.com.unicid.cadastroaluno.connection.ConnectionDB;
import br.com.unicid.cadastroaluno.model.Aluno;
import jdk.nashorn.internal.ir.SetSplitState;

public class AlunoDAO{
	
	private Aluno aluno;
	private Connection conn; //Conecta com o banco
	private PreparedStatement ps; //executa a query
	private ResultSet rs;

	public AlunoDAO() throws Exception {
		try {
			conn = ConnectionDB.getConnection();
		}
		catch(Exception e) {
			throw new Exception("Erro " + e.getMessage());
		}
	}

	public void salvarAluno(Aluno aluno) throws Exception{
		System.out.println("Passou pelo AlunoDAO");
		try {
			
			String sql = "INSERT INTO aluno(rgm, periodo, cod_pessoa)" + "VALUES(?,?,?)";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, aluno.getRgm());
			ps.setString(2, aluno.getPeriodo());
			ps.setInt(3, PessoaDAO.codPessoa);
			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");

			ps.close();
		}
		catch(Exception e) {
			throw new Exception("Erro ao Salvar" + e.getMessage());
		}
	}

	public List listarTodos() throws Exception{

		List<Aluno> lista = new ArrayList<Aluno>();
		try{
			ps = conn.prepareStatement("SELECT * FROM ALUNO");
			rs = ps.executeQuery();
			while(rs.next()) {
				int codAluno = rs.getInt("Nome da coluna");
			}
		}
		catch(Exception e) {
			throw new Exception("Erro ao Listar" + e.getMessage());
		}
		return lista;
	}
}

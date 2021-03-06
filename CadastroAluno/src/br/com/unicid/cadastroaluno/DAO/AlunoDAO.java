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
import br.com.unicid.cadastroaluno.view.frmAluno;
import jdk.nashorn.internal.ir.SetSplitState;

public class AlunoDAO{

	private Aluno aluno;
	private Connection conn; //Conecta com o banco
	private PreparedStatement ps; //executa a query
	private ResultSet rs;

	/*INICIA A CONE��O COM O BANCO AO CONSTRUIR O OBJETO*/
	public AlunoDAO() throws Exception {
		try {
			conn = ConnectionDB.getConnection();
		}
		catch(Exception e) {
			throw new Exception("Erro " + e.getMessage());
		}
	}

	/*SALVAR ALUNO*/

	public void salvarAluno(Aluno aluno) throws Exception{

		try {

			String sql = "INSERT INTO aluno(rgm, periodo, campus, cod_curso, cod_pessoa)" + "VALUES(?,?,?,?,?)";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, aluno.getRgm());
			ps.setString(2, aluno.getPeriodo());
			ps.setString(3, aluno.getCampus());
			ps.setInt(4, aluno.curso.getCodCurso());
			ps.setInt(5, aluno.getCodPessoa());
			ps.executeUpdate();
			ps.close();
		}
		catch(Exception e) {
			throw new Exception("Erro ao Salvar" + e.getMessage());
		}
	}

	/*CONSULTAR ALUNO*/

	public Aluno consultarAluno(int rgm) throws Exception {

		try {
			ps = conn.prepareStatement("SELECT * FROM aluno WHERE rgm=?");
			ps.setInt(1, rgm);
			rs = ps.executeQuery();
			if(rs.next()) {
				aluno = frmAluno.aluno;
				aluno.setPeriodo(rs.getString("periodo"));
				aluno.setCodPessoa(rs.getInt("cod_pessoa"));
				aluno.setCampus(rs.getString("campus"));
				aluno.curso.setCodCurso(rs.getInt("cod_curso"));
				ps.close();
			}  
		}
		catch (Exception e) {
			throw new Exception("Erro ao consultar" + e.getMessage());
		}

		return aluno;
	}

	/*ALTERAR ALUNO*/

	public void alterarAluno(Aluno aluno) throws Exception{

		try {

			String sql = "UPDATE aluno SET periodo=?, campus=? WHERE rgm=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, aluno.getPeriodo());
			ps.setString(2, aluno.getCampus());
			ps.setInt(3, aluno.getRgm());
			ps.executeUpdate();

			ps.close();
		}
		catch(Exception e) {
			throw new Exception("Erro ao Alterar" + e.getMessage());
		}
	}

	/*EXLUIR ALUNO*/

	public void excluirAluno(int rgm) throws Exception{
		try {

			String sql = "DELETE FROM aluno WHERE RGM=?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, rgm);

			ps.executeUpdate();
			ps.close();
		}
		catch(Exception e) {
			throw new Exception("Erro ao Excluir" + e.getMessage());
		}
	}
	
	
	/*GERA RGM*/
	
	public int geraRGM() throws Exception {

		int rgm = 0;
		
		try {
			ps = conn.prepareStatement("SELECT cod_aluno FROM aluno ORDER BY cod_aluno DESC LIMIT 1");
			rs = ps.executeQuery();
			if(rs.next()) {
				rgm = rs.getInt("cod_aluno");
				ps.close();
			}  
		}
		catch (Exception e) {
			throw new Exception("Erro ao gerar" + e.getMessage());
		}

		rgm += 1000;
		
		return rgm;
	}
}

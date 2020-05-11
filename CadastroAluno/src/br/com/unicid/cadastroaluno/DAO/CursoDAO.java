package br.com.unicid.cadastroaluno.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import br.com.unicid.cadastroaluno.connection.ConnectionDB;
import br.com.unicid.cadastroaluno.model.Aluno;
import br.com.unicid.cadastroaluno.model.Curso;
import br.com.unicid.cadastroaluno.view.frmAluno;

public class CursoDAO {

	private Connection conn; //Conecta com o banco
	private PreparedStatement ps; //executa a query
	private ResultSet rs;

	/*INICIA A CONEÇÃO COM O BANCO AO CONSTRUIR O OBJETO*/
	public CursoDAO() throws Exception{
		try {
			conn = ConnectionDB.getConnection();
		}
		catch(Exception e) {
			throw new Exception("Erro " + e.getMessage());
		}
	}

	public List getNomesCursos() throws Exception{

		List<String> listaCurso = new ArrayList<String>();

		try {

			ps = conn.prepareStatement("SELECT * FROM curso ORDER BY nome_curso");
			rs = ps.executeQuery();
			listaCurso.add("Selecione -");
			while(rs.next()) {
				listaCurso.add(rs.getString("nome_curso"));
			}
			ps.close();
			return listaCurso;
		}
		catch(Exception e) {
			throw new Exception("Erro ao Buscar" + e.getMessage());
		}
	}

	public int getCodCurso(String nomeCurso) throws Exception{

		try {

			ps = conn.prepareStatement("SELECT cod_curso FROM curso WHERE nome_curso=?");
			ps.setString(1, nomeCurso);
			rs = ps.executeQuery();
			if(rs.next()) {
				frmAluno.aluno.curso.setCodCurso((rs.getInt("cod_curso")));
			}
			ps.close();

			return frmAluno.aluno.curso.getCodCurso();

		}
		catch(Exception e) {
			throw new Exception("Erro ao Buscar" + e.getMessage());
		}
	}

	public String getNomeCurso(int codCurso) throws Exception{

		try {

			ps = conn.prepareStatement("SELECT nome_curso FROM curso WHERE cod_curso=?");
			ps.setInt(1, codCurso);
			rs = ps.executeQuery();
			if(rs.next()) {
				frmAluno.aluno.curso.setNomeCurso(rs.getString("nome_curso"));
			}
			ps.close();

			return frmAluno.aluno.curso.getNomeCurso();

		}
		catch(Exception e) {
			throw new Exception("Erro ao Buscar" + e.getMessage());
		}
	}
}

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

public class CursoDAO {

	private Curso curso;
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

	public List buscarCurso() throws Exception{

		List<String> listaCurso = new ArrayList<String>();

		try {

			ps = conn.prepareStatement("SELECT * FROM curso");
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

	public List buscarDisciplinas(JComboBox<?> NomeCurso) throws Exception{

		String nomeCurso = NomeCurso.getSelectedItem().toString();
		int codCurso = 0;

		try {
			ps = conn.prepareStatement("SELECT cod_curso FROM curso WHERE nome_curso=?");
			ps.setString(1, nomeCurso); 
			rs = ps.executeQuery(); 
			if(rs.next()) {
				codCurso = rs.getInt("cod_curso");
			}

		} catch (Exception e) {

		}

		List<String> listaDisciplinas = new ArrayList<String>();

		try {

			ps = conn.prepareStatement("SELECT * FROM disciplina WHERE cod_curso=?");
			ps.setInt(1, codCurso);
			rs = ps.executeQuery();
			listaDisciplinas.add("Selecione -");
			while(rs.next()) {
				listaDisciplinas.add(rs.getString("nome_disciplina"));
			}
			ps.close();
			return listaDisciplinas;
		}
		catch(Exception e) {
			throw new Exception("Erro ao Buscar" + e.getMessage());
		}	
	}
}

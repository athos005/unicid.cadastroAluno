package br.com.unicid.cadastroaluno.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import br.com.unicid.cadastroaluno.connection.ConnectionDB;
import br.com.unicid.cadastroaluno.view.frmAluno;

public class DisciplinaDAO {

	public DisciplinaDAO() throws Exception{
		try {
			conn = ConnectionDB.getConnection();
		}
		catch(Exception e) {
			throw new Exception("Erro " + e.getMessage());
		}
	}

	private Connection conn; //Conecta com o banco
	private PreparedStatement ps; //executa a query
	private ResultSet rs;

	public List getCodDisciplinas(int codCurso) throws Exception{

		codCurso = frmAluno.aluno.curso.getCodCurso();
		List<Integer> listaCodDisciplina = new ArrayList<>();

		try {
			ps = conn.prepareStatement("SELECT cod_disciplina FROM disciplina WHERE cod_curso=?");
			ps.setInt(1, codCurso);
			rs = ps.executeQuery();
			while(rs.next()) {
				listaCodDisciplina.add(rs.getInt("cod_disciplina"));
			}
			ps.close();
			return listaCodDisciplina;
		}
		catch(Exception e) {
			throw new Exception("Erro ao Buscar" + e.getMessage());
		}	
	}

	public List getNomesDisciplinas(int codCurso) throws Exception{

		codCurso = frmAluno.aluno.curso.getCodCurso();
		List<String> listaNomesDisciplinas = new ArrayList<String>();

		try {
			ps = conn.prepareStatement("SELECT nome_disciplina FROM disciplina WHERE cod_curso=?");
			ps.setInt(1, codCurso);
			rs = ps.executeQuery();
			listaNomesDisciplinas.add("Selecione -");
			while(rs.next()) {
				listaNomesDisciplinas.add(rs.getString("nome_disciplina"));
			}
			ps.close();
			return listaNomesDisciplinas;
		}
		catch(Exception e) {
			throw new Exception("Erro ao Buscar" + e.getMessage());
		}	
	}

	public String buscaNomeDisciplina(int codDisciplina) throws Exception{

		String nomeDisciplina = null;

		try {
			ps = conn.prepareStatement("SELECT nome_disciplina FROM disciplina WHERE cod_disciplina=?");
			ps.setInt(1, codDisciplina);
			rs = ps.executeQuery();
			if(rs.next()) {
				nomeDisciplina = rs.getString("nome_disciplina");
			}
			ps.close();
			
			return nomeDisciplina;
		}
		catch(Exception e) {
			throw new Exception("Erro ao Buscar" + e.getMessage());
		}		
	}

	public int buscaCodDisciplina(String nomeDisciplina) throws Exception{

		int codDisciplina = 0;

		try {
			ps = conn.prepareStatement("SELECT cod_disciplina FROM disciplina WHERE nome_disciplina=?");
			ps.setString(1, nomeDisciplina);
			rs = ps.executeQuery();
			if(rs.next()) {
				codDisciplina = rs.getInt("cod_disciplina");
			}
			ps.close();
			return codDisciplina;
		}
		catch(Exception e) {
			throw new Exception("Erro ao Buscar" + e.getMessage());
		}	
	}


}

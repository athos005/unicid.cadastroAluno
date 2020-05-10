package br.com.unicid.cadastroaluno.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.unicid.cadastroaluno.connection.ConnectionDB;
import br.com.unicid.cadastroaluno.model.Aluno;

public class DisciplinaAlunoDAO {

	private DisciplinaAlunoDAO disciplinaAlunoDAO;
	private Connection conn; //Conecta com o banco
	private PreparedStatement ps; //executa a query
	private ResultSet rs;


	public DisciplinaAlunoDAO() throws Exception {
		try {
			conn = ConnectionDB.getConnection();
		}
		catch(Exception e) {
			throw new Exception("Erro " + e.getMessage());
		}
	}	

	public void salvarDisciplinaAluno(Aluno aluno) throws Exception{
		
		List<Integer> listaDisciplina = new ArrayList<Integer>();
		aluno.curso.buscaCodDisciplinas(listaDisciplina);
		try {
			for (int i = 0; i <= listaDisciplina.size(); i++) {
				
				int cod = listaDisciplina.get(i);
				String sql = "INSERT INTO disciplina_aluno(rgm, cod_disciplina)" + "VALUES(?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, aluno.getRgm());
				ps.setInt(2, cod);
				ps.executeUpdate();
			}
			ps.close();
		}
		catch(Exception e) {
			throw new Exception("Erro ao Salvar" + e.getMessage());
		}
	}
}

package br.com.unicid.cadastroaluno.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.unicid.cadastroaluno.connection.ConnectionDB;
import br.com.unicid.cadastroaluno.model.Aluno;
import br.com.unicid.cadastroaluno.model.Disciplina;
import br.com.unicid.cadastroaluno.view.frmAluno;
import br.com.unicid.cadastroaluno.view.frmNotasFaltas;

public class DisciplinaAlunoDAO {

	public Disciplina disciplina;
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

	public void SalvarNotaFalta(double nota, int faltas) throws Exception {

		Calendar ano = Calendar.getInstance();
		String anoAtual = Integer.toString(ano.get(Calendar.YEAR));

		try {

			String sql = "UPDATE disciplina_aluno SET nota=?, faltas=?, semestre=? WHERE rgm=? AND cod_disciplina=?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, nota);
			ps.setInt(2, faltas);
			ps.setString(3, frmNotasFaltas.disciplina.getSemestre() + " / " + anoAtual);
			ps.setInt(4, frmAluno.aluno.getRgm());
			ps.setInt(5, frmNotasFaltas.disciplina.getCodDisciplina());
			ps.executeUpdate();	
			ps.close();
		}
		catch(Exception e) {
			throw new Exception("Erro ao Salvar" + e.getMessage());
		}
	}

	/*LISTAR ALUNOS*/

	public List listarAlunos() throws Exception{

		List<Disciplina> listaAluno = new ArrayList<>();
		disciplina = new Disciplina();

		try{
			ps = conn.prepareStatement("SELECT * FROM disciplina_aluno where rgm=?");
			ps.setInt(1, frmAluno.aluno.getRgm());
			rs = ps.executeQuery();
			while(rs.next()) {
				int cod = rs.getInt("cod_disciplina");
				String nome = disciplina.buscaNomeDisciplina(cod);
				double nota = rs.getDouble("nota");
				int faltas = rs.getInt("faltas");
				String semestre = rs.getString("semestre");
				listaAluno.add( new Disciplina(cod, nome, nota, semestre, faltas));
			}

			ps.close();
			return listaAluno;
		}
		catch(Exception e) {
			throw new Exception("Erro ao Listar" + e.getMessage());
		}
	}

	public void excluirNotas(int rgm) throws Exception{

		try {

			String sql = "DELETE FROM disciplina_aluno WHERE rgm=? and COD_DISCIPLINA_ALUNO > 0;";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, rgm);

			ps.executeUpdate();
			ps.close();
		}
		catch(Exception e) {
			throw new Exception("Erro ao Excluir" + e.getMessage());
		}
	}

}

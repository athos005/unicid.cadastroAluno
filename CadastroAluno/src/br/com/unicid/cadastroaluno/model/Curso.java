package br.com.unicid.cadastroaluno.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import br.com.unicid.cadastroaluno.DAO.CursoDAO;
import br.com.unicid.cadastroaluno.DAO.EnderecoDAO;

public class Curso {

	private String nomeCurso;
	private String disciplina;
	private int codCurso;
	private int codDisciplina;

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public List buscarCurso(JComboBox<String> cmbCurso){

		List<String> listaCursos = new ArrayList<String>();

		try {

			CursoDAO DAOcurso = new CursoDAO();			
			listaCursos = DAOcurso.buscarCurso();

			for(String curso: listaCursos) {

				cmbCurso.addItem(curso);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	

		return listaCursos;
	}

	public List buscarDisciplina(JComboBox<String> cmbDisciplina, JComboBox<?> cmbCurso){

		List<String> listaDisciplina = new ArrayList<String>();

		try {

			CursoDAO DAOcurso = new CursoDAO();			
			listaDisciplina = DAOcurso.buscarDisciplinas(cmbCurso);

			for(String curso: listaDisciplina) {

				cmbDisciplina.addItem(curso);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	

		return listaDisciplina;
	}
}

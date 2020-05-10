package br.com.unicid.cadastroaluno.model;

import br.com.unicid.cadastroaluno.DAO.DisciplinaAlunoDAO;
import br.com.unicid.cadastroaluno.view.frmAluno;

public class DisciplinasAluno{

	private DisciplinaAlunoDAO DAOdisciplinasAluno;
	private double nota;
	private int faltas;
	private String semestre;

	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public int getFaltas() {
		return faltas;
	}
	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public void salvarDisciplinasAluno() {

		try {
			DAOdisciplinasAluno = new DisciplinaAlunoDAO();
			DAOdisciplinasAluno.salvarDisciplinaAluno(frmAluno.aluno);
		}
		catch(Exception e){

		}

	}

}

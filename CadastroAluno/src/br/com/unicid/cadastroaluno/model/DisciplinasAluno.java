package br.com.unicid.cadastroaluno.model;

import java.awt.TextArea;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import br.com.unicid.cadastroaluno.DAO.DisciplinaAlunoDAO;
import br.com.unicid.cadastroaluno.view.frmAluno;
import br.com.unicid.cadastroaluno.view.frmNotasFaltas;

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

	public void salvarNotaFaltas() {

		double nota = frmNotasFaltas.disciplina.getNotaDisciplina();
		int falta = frmNotasFaltas.disciplina.getFaltasDisciplina();

		try {

			DAOdisciplinasAluno = new DisciplinaAlunoDAO();
			DAOdisciplinasAluno.SalvarNotaFalta(nota, falta);
			JOptionPane.showMessageDialog(null, "Salvo com sucesso a nota e faltas de " + "\n" +
					frmNotasFaltas.disciplina.getNomeDisciplina());

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void exbirNotasFaltas(TextArea boletim) {
		try {
			
			List<Disciplina> lista = new ArrayList<Disciplina>();
			DAOdisciplinasAluno = new DisciplinaAlunoDAO();
			lista = DAOdisciplinasAluno.listarAlunos();
			for(Disciplina aluno : lista) {
				boletim.append("Disciplina: " + aluno.getNomeDisciplina() + "\n" + "Semestre: " + aluno.getSemestre() + "\n");
				boletim.append("Nota: " + aluno.getNotaDisciplina() + " Faltas: " + aluno.getFaltasDisciplina() + "\n");
				boletim.append("............................................................................" + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

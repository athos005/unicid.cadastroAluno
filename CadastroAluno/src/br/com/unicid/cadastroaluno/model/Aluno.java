package br.com.unicid.cadastroaluno.model;

import javax.swing.JRadioButton;

import com.mysql.cj.jdbc.exceptions.NotUpdatable;

import br.com.unicid.cadastroaluno.DAO.AlunoDAO;
import br.com.unicid.cadastroaluno.view.frmAluno;

public class Aluno extends Pessoa{

	private int rgm;
	private String nomeCurso;
	private String periodo;
	private String campus;
	private String nomeDisciplina;
	private String notaDisciplina;
	private int faltasDisciplina;


	public Aluno(String nomeAluno, String cpfAluno){
		super(nomeAluno, cpfAluno);
	}

	public int getRgm() {
		return rgm;
	}

	public void setRgm(int rgm) {
		this.rgm = rgm;
	}

	public String getNomeCurso() {
		return this.nomeCurso;
	} 

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getCampus() {
		return this.campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(JRadioButton matutino, JRadioButton vespertino, JRadioButton noturno) {

		if(matutino.isSelected()) {
			this.periodo = "Matutino";
		} else 
			if(vespertino.isSelected()) {
				this.periodo = "Vespertino";
			} else 
				if(noturno.isSelected()) {
					this.periodo = "Noturno";
				}
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getNotaDisciplina() {
		return notaDisciplina;
	}

	public void setNotaDisciplina(String notaDisciplina) {
		this.notaDisciplina = notaDisciplina;
	}

	public int getFaltasDisciplina() {
		return faltasDisciplina;
	}

	public void setFaltasDisciplina(int faltasDisciplina) {
		this.faltasDisciplina = faltasDisciplina;
	}

	public void salvarAluno() throws Exception {
		
		salvarCadastro();
		
		AlunoDAO DAOaluno = new AlunoDAO();
		DAOaluno.salvarAluno(frmAluno.aluno);

	}

}

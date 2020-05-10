package br.com.unicid.cadastroaluno.model;

import br.com.unicid.cadastroaluno.DAO.DisciplinaDAO;

public class Disciplina {

	private int codDisciplina;
	private String nomeDisciplina;
	private double notaDisciplina;
	private String semestre;
	private int faltasDisciplina;


	public Disciplina(){

	}

	public Disciplina(int cod, String nome, double nota, String semestre, int faltas){
		this.codDisciplina = cod;
		this.nomeDisciplina = nome;
		this.notaDisciplina = nota;
		this.faltasDisciplina = faltas;
		this.semestre = semestre;
	}

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {

		int cod;
		try {
			DisciplinaDAO disciplina = new DisciplinaDAO();
			cod = disciplina.buscaCodDisciplina(codDisciplina);
			this.codDisciplina = cod;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public double getNotaDisciplina() {
		return notaDisciplina;
	}
	public void setNotaDisciplina(double notaDisciplina) {
		this.notaDisciplina = notaDisciplina;
	}

	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public int getFaltasDisciplina() {
		return faltasDisciplina;
	}
	public void setFaltasDisciplina(int faltasDisciplina) {
		this.faltasDisciplina = faltasDisciplina;
	}

	public String buscaNomeDisciplina(int codDisciplina) {

		String nomeDisciplina = null;

		try {
			DisciplinaDAO disciplina = new DisciplinaDAO();
			nomeDisciplina = disciplina.buscaNomeDisciplina(codDisciplina);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nomeDisciplina;
	}

}

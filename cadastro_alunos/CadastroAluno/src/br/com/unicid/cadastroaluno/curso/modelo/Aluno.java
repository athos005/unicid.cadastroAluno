package br.com.unicid.cadastroaluno.curso.modelo;

public class Aluno extends Pessoa{
		
	private int rgm;
	private int semestre;
	private String nomeDisciplina;
	private String notaDisciplina;
	private int faltasDisciplina;

	
	public Aluno(int rgm, String nomeAluno, String cpfAluno, String dataNascAluno, String genero, String nomeDisciplina, int semestre){
		super(nomeAluno, cpfAluno, dataNascAluno, genero);
		this.rgm = rgm;
		this.nomeDisciplina = nomeDisciplina;
		this.semestre = semestre;
	}
	
	public int getRgm() {
		return rgm;
	}

	public void setRgm(int rgm) {
		this.rgm = rgm;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
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
	
	public void criaAluno() {
		
	}
	
	
}

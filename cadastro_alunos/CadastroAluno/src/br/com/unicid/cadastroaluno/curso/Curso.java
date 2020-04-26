package br.com.unicid.cadastroaluno.curso;

public class Curso {
	
	private String nomeCurso;
	private String campus;
	private String periodo;
	
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
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
}
